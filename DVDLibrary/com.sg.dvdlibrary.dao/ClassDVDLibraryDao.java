package DVDLibrary.com.sg.dvdlibrary.dao;

import DVDLibrary.com.sg.dvdlibrary.dto.DVD;

import java.util.List;

public interface ClassDVDLibraryDao {
    /**
     * Adds the given DVD to the collection and associates it with the
     * DVD title. This method is supposed to be called if such DVD
     * doesn't exist in the collection, otherwise this DVD will be rewritten
     *
     * @param dvd DVD object to be added to the collection
     */
    void addDVD(DVD dvd) throws ClassDVDDaoException;

    /**
     * Removes the DVD with the given title from the collection.
     * Returns the DVD object that was deleted or null if there wasn't
     * DVD with the given title
     *
     * @param dvdTitle title of the DVD to be removed
     * @return the removed DVD object if it existed, null otherwise
     */
    DVD removeDVD(String dvdTitle) throws ClassDVDDaoException;

    /**
     * Puts the given DVD object into the collection instead of the previous DVD
     *
     * @param dvd DVD object to put into the collection
     */
    void editDVD(DVD dvd) throws ClassDVDDaoException;

    /**
     * Returns a List of all DVDs in the collection.
     *
     * @return List containing all DVDs in the collection.
     */
    List<DVD> getAllDVDs() throws ClassDVDDaoException;

    /**
     * Returns the DVD object associated with the given title.
     * Returns null if no such DVD exists
     *
     * @param dvdTitle title of the DVD to retrieve
     * @return the DVD object associated with the given title,
     * null if no such DVD exists
     */
    DVD getDVD(String dvdTitle) throws ClassDVDDaoException;

}