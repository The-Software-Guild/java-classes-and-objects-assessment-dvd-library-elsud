package DVDLibrary.com.sg.dvdlibrary;

import DVDLibrary.com.sg.dvdlibrary.controller.ClassDVDLibraryController;
import DVDLibrary.com.sg.dvdlibrary.dao.ClassDVDLibraryDao;
import DVDLibrary.com.sg.dvdlibrary.dao.ClassDVDLibraryDaoFileImpl;
import DVDLibrary.com.sg.dvdlibrary.ui.ClassDVDLibraryView;
import DVDLibrary.com.sg.dvdlibrary.ui.UserIO;
import DVDLibrary.com.sg.dvdlibrary.ui.UserIOConsoleImpl;

public class App {
    public static void main(String[] args) {
        ClassDVDLibraryDao dao = new ClassDVDLibraryDaoFileImpl();
        UserIO io = new UserIOConsoleImpl();
        ClassDVDLibraryView view = new ClassDVDLibraryView(io);
        ClassDVDLibraryController controller = new ClassDVDLibraryController(view, dao);
        controller.run();
    }
}
