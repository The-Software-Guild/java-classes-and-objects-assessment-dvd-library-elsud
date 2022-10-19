package DVDLibrary.com.sg.dvdlibrary.dao;

import DVDLibrary.com.sg.dvdlibrary.dto.DVD;

import java.io.*;
import java.util.*;

public class ClassDVDLibraryDaoFileImpl implements ClassDVDLibraryDao {
    private Map<String, DVD> dvds = new HashMap<>();

    // File to store DVD data
    public static final String DVD_FILE = "dvd.txt";

    // Delimiter between DVD fields
    public static final String DELIMITER = "::";

    private int numberOfDVDFields = 6;

    @Override
    public void addDVD(DVD dvd)  throws ClassDVDDaoException {
        loadDVDs();
        String dvdTitle = dvd.getTitle();
        dvds.put(dvdTitle, dvd);
        writeDVDs();
    }

    @Override
    public DVD removeDVD(String dvdTitle)  throws ClassDVDDaoException {
        loadDVDs();
        DVD removedDVD = dvds.remove(dvdTitle);
        if (removedDVD != null) {
            writeDVDs();
        }
        return removedDVD;
    }

    @Override
    public void editDVD(DVD dvd)  throws ClassDVDDaoException {
        loadDVDs();
        dvds.put(dvd.getTitle(), dvd);
        writeDVDs();
    }

    @Override
    public List<DVD> getAllDVDs()  throws ClassDVDDaoException {
        loadDVDs();
        return new ArrayList<DVD>(dvds.values());
    }

    @Override
    public DVD getDVD(String dvdTitle)  throws ClassDVDDaoException {
        loadDVDs();
        return dvds.get(dvdTitle);
    }

    /**
     * Takes one line from the file and split this line into fields with the delimiter.
     * Creates new DVD object with constructor that takes an Array with fields
     *
     * @param dvdAsText String with DVD info read from the file
     * @return new DVD object
     */
    private DVD unmarshallDVD(String dvdAsText) {
        String[] dvdTokens = new String[numberOfDVDFields];
        int currentIndex = 0;
        for (String field : dvdAsText.split(DELIMITER)) {
            dvdTokens[currentIndex] = field;
            currentIndex ++;
        }
        return new DVD(dvdTokens);
    }

    /**
     * Read all lines from the file with Scanner and adds created DVDs
     * to dvds HashMap
     *
     * @throws ClassDVDDaoException
     */
    private void loadDVDs() throws ClassDVDDaoException {
        Scanner scanner;
        try {
            scanner = new Scanner(new BufferedReader(new FileReader(DVD_FILE)));
        } catch (FileNotFoundException e) {
            throw new ClassDVDDaoException("-_- Could not load DVDs data into memory.", e);
        }
        String currentLine;
        DVD currentDVD;
        while (scanner.hasNextLine()) {
            currentLine = scanner.nextLine();
            currentDVD = unmarshallDVD(currentLine);
            dvds.put(currentDVD.getTitle(), currentDVD);
        }
        scanner.close();
    }

    /**
     * Takes one DVD object and creates a String which contains
     * DVD's fields separated with the delimiter
     *
     * @param dvd the DVD object to modify to String
     * @return String with DVD's info
     */
    private String marshallDVD(DVD dvd) {
        String dvdAsText = dvd.getTitle() + DELIMITER + dvd.getReleaseDate() +
                DELIMITER + dvd.getRating() + DELIMITER + dvd.getDirectorName() +
                DELIMITER + dvd.getStudio() + DELIMITER + dvd.getUserNote();
        return dvdAsText;
    }

    /**
     * Iterates through all DVD objects, modifies them to Strings
     * and writes those Strings to the file one by one
     *
     * @throws ClassDVDDaoException
     */
    private void writeDVDs() throws ClassDVDDaoException {
        PrintWriter out;
        try {
            out = new PrintWriter(new FileWriter(DVD_FILE));
        } catch (IOException e) {
            throw new ClassDVDDaoException("Could not save DVD data.", e);
        }
        String dvdAsText;
        for (DVD dvd : dvds.values()) {
            dvdAsText = marshallDVD(dvd);
            out.println(dvdAsText);
            out.flush();
        }
        out.close();
    }
}
