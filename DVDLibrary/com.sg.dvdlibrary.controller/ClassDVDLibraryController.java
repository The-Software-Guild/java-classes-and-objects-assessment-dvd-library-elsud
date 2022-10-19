package DVDLibrary.com.sg.dvdlibrary.controller;

import DVDLibrary.com.sg.dvdlibrary.dao.ClassDVDDaoException;
import DVDLibrary.com.sg.dvdlibrary.dao.ClassDVDLibraryDao;
import DVDLibrary.com.sg.dvdlibrary.dto.DVD;
import DVDLibrary.com.sg.dvdlibrary.ui.ClassDVDLibraryView;

public class ClassDVDLibraryController {
    private ClassDVDLibraryView view;
    private ClassDVDLibraryDao dao;

    public ClassDVDLibraryController(ClassDVDLibraryView view, ClassDVDLibraryDao dao) {
        this.view = view;
        this.dao = dao;
    }

    /**
     * Main method to run application. Keeps displaying the menu and
     * processing user's choices until the user wouldn't choose to exit
     */
    public void run() {
        boolean keepGoing = true;
        int menuSelection = 0;
        try {
            while (keepGoing) {
                menuSelection = getMenuSelection();

                switch (menuSelection) {
                    case 1:
                        addDVD();
                        break;
                    case 2:
                        removeDVD();
                        break;
                    case 3:
                        editDVD();
                        break;
                    case 4:
                        listDVD();
                        break;
                    case 5:
                        displayDVD();
                        break;
                    case 6:
                        searchDVD();
                        break;
                    case 7:
                        keepGoing = false;
                        break;
                    default:
                        view.displayUnknownCommandBanner();
                }
            }
            view.displayExitBanner();
        } catch (ClassDVDDaoException e) {
            view.displayErrorMessage(e.getMessage());
        }
    }

    /**
     * Gets the user's choice for the menu button from the view
     *
     * @return integer associated with menu button
     */
    private int getMenuSelection() {
        return view.printMenuAndGetSelection();
    }

    /**
     * Implements action to add DVD to the collection.
     * Adds DVD if DVD with such name doesn't exist.
     *
     * @throws ClassDVDDaoException
     */
    private void addDVD() throws ClassDVDDaoException {
        view.displayAddDVDBanner();
        String dvdTitle = view.getDVDTitle();
        if (dao.getDVD(dvdTitle) != null) {
            view.displayDVDExistsBanner();
        }
        else {
            DVD newDVD = view.getDVDInfo(dvdTitle);
            dao.addDVD(newDVD);
            view.displaySuccessfulAddBanner();
        }
    }

    /**
     * Implements action for search button. Displays if DVD
     * with entered title exists or not
     *
     * @throws ClassDVDDaoException
     */
    private void searchDVD() throws ClassDVDDaoException {
        view.displaySearchDVDBanner();
        String dvdTitle = view.getDVDTitle();
        DVD dvd = dao.getDVD(dvdTitle);
        view.displaySearchResultBanner(dvd);

    }

    /**
     * Implements action to delete DVD by title
     *
     * @throws ClassDVDDaoException
     */
    private void removeDVD() throws ClassDVDDaoException {
        view.displayRemoveDVDBanner();
        String dvdTitle = view.getDVDTitle();
        DVD dvd = dao.removeDVD(dvdTitle);
        view.displayRemoveResultBanner(dvd);
    }

    /**
     * Implements action to display all DVDs from the collection
     *
     * @throws ClassDVDDaoException
     */
    private void listDVD() throws ClassDVDDaoException {
        view.displayAllDVDBanner();
        view.displayDVDList(dao.getAllDVDs());
    }

    /**
     * Implements action to display all information for DVD
     * with entered title
     *
     * @throws ClassDVDDaoException
     */
    private void displayDVD() throws ClassDVDDaoException {
        view.displayDVDBanner();
        String dvdTitle = view.getDVDTitle();
        view.displayDVDInfo(dao.getDVD(dvdTitle));
    }

    /**
     * Implements action to edit DVD with entered title.
     * Edits DVD only if such DVD exists.
     *
     * @throws ClassDVDDaoException
     */
    private void editDVD() throws ClassDVDDaoException {
        view.displayEditDVDBanner();
        String dvdTitle = view.getDVDTitle();
        if (dao.getDVD(dvdTitle) != null) {
            DVD dvd = view.getDVDInfo(dvdTitle);
            dao.editDVD(dvd);
            view.displaySuccessfulEditDVDBanner();
        }
        else {
        view.displayDVDDoesNotExistBanner();
        }
    }
}
