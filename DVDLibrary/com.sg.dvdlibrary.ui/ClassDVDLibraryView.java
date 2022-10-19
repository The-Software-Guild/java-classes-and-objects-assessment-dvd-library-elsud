package DVDLibrary.com.sg.dvdlibrary.ui;

import DVDLibrary.com.sg.dvdlibrary.dto.DVD;

import java.util.List;

public class ClassDVDLibraryView {
    private final UserIO IO;

    public ClassDVDLibraryView(UserIO io) {
        this.IO = io;
    }

    /**
     * Display menu and wait for the user's choice
     *
     * @return integer that corresponds to user's choice
     */
    public int printMenuAndGetSelection() {
        IO.print("=== Main Menu ===");
        IO.print("1. Add a DVD");
        IO.print("2. Remove a DVD");
        IO.print("3. Edit a DVD");
        IO.print("4. List DVDs");
        IO.print("5. Display a DVD");
        IO.print("6. Search for a DVD by title");
        IO.print("7. Exit");

        return IO.readInt("Please select from the above choices.", 1, 7);
    }

    /**
     * Collect info from the user to create or update a DVD
     *
     * @param dvdTitle title of the DVD to create/update
     * @return new DVD object
     */
    public DVD getDVDInfo(String dvdTitle) {
        String releaseDate = IO.readString("Please enter the release date");
        String rating = IO.readString("Please enter the MPAA rating");
        String directorName = IO.readString("Please enter the director's name");
        String studio = IO.readString("Please enter the studio");
        String userNote = IO.readString("Please enter your rating or note");
        DVD newDVD = new DVD(dvdTitle, releaseDate, rating, directorName, studio, userNote);
        return newDVD;
    }

    /**
     * Asks the user to input DVD title and waits for that input
     *
     * @return DVD title
     */
    public String getDVDTitle() {
        String dvdTitle = IO.readString("Please enter the DVD title");
        return dvdTitle;
    }

    /**
     * Display list of DVDs in  the collection. There are DVD's
     * titles, director's names and release dates in the list to display
     *
     * @param dvdList list of DVD objects from the collection
     */
    public void displayDVDList(List<DVD> dvdList) {
        for (DVD dvd : dvdList) {
            String dvdInfo = String.format("%s : %s, %s",
                    dvd.getTitle(),
                    dvd.getDirectorName(),
                    dvd.getReleaseDate()
            );
            IO.print(dvdInfo);
        }
        IO.readString("Please hit enter to continue.");
    }

    /**
     * Displays all information about the DVD
     *
     * @param dvd DVD object to display
     */
    public void displayDVDInfo(DVD dvd) {
        if (dvd != null) {
            IO.print("Title - " + dvd.getTitle());
            IO.print("Director - " + dvd.getDirectorName());
            IO.print("Release date - " + dvd.getReleaseDate());
            IO.print("Studio - " + dvd.getStudio());
            IO.print("MPAA rating - " + dvd.getRating());
            IO.print("Note - " + dvd.getUserNote());
            IO.readString("Please hit enter to continue");
        }
        else {
            displayDVDDoesNotExistBanner();
        }
    }
    public void displayAddDVDBanner() {
        IO.print("=== Add DVD ===");
    }

    public void displaySuccessfulAddBanner() {
        IO.readString("DVD was successfully added. Please hit enter to continue");
    }

    public void displayDVDExistsBanner() {
        IO.readString("DVD with this title already exists. Please hit enter to continue");
    }

    public void displayDVDDoesNotExistBanner() {
        IO.readString("Such DVD doesn't exist. Please hit enter to continue");
    }

    public void displaySearchDVDBanner() {
        IO.print("=== Search for DVD ===");
    }

    public void displaySearchResultBanner(DVD dvd) {
        if (dvd != null) {
            IO.readString("DVD exists. Please hit enter to continue");
        }
        else {
            displayDVDDoesNotExistBanner();
        }
    }

    public void displayRemoveDVDBanner() {
        IO.print("=== Remove DVD ===");
    }

    public void displayRemoveResultBanner(DVD dvd) {
        if (dvd != null) {
            IO.readString("DVD was deleted. Please hit enter to continue");
        }
        else {
            displayDVDDoesNotExistBanner();
        }
    }

    public void displayAllDVDBanner() {
        IO.print("=== All DVDs ===");
    }

    public void displayDVDBanner() {
        IO.print("=== Display DVD info ===");
    }

    public void displayEditDVDBanner() {
        IO.print("=== Edit DVD ===");
    }

    public void displaySuccessfulEditDVDBanner() {
        IO.print("DVD was edited. Please hit enter to continue");
    }

    public void displayUnknownCommandBanner() {
        IO.print("UNKNOWN COMMAND");
    }

    public void displayExitBanner() {
        IO.print("GOOD BYE");
    }

    public void displayErrorMessage(String errorMsg) {
        IO.print("=== ERROR ===");
        IO.print(errorMsg);
    }
}
