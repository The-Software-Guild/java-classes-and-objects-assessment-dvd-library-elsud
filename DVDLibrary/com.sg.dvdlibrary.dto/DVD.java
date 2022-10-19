package DVDLibrary.com.sg.dvdlibrary.dto;

public class DVD {
    private String title;
    private String releaseDate;
    private String rating;
    private String directorName;
    private String studio;
    private String userNote;

    public DVD(String title){
        this.title = title;
    }

    public DVD(
            String title, String releaseDate, String rating,
            String directorName, String studio, String userNote
    ) {
        this.title = title;
        this.releaseDate = releaseDate;
        this.rating = rating;
        this.directorName = directorName;
        this.studio = studio;
        this.userNote = userNote;
    }

    public DVD(String[] dvdTokens) {
        this.title = dvdTokens[0];
        this.releaseDate = dvdTokens[1];
        this.rating = dvdTokens[2];
        this.directorName = dvdTokens[3];
        this.studio = dvdTokens[4];
        this.userNote = dvdTokens[5];
    }

    public String getTitle() {
        return title;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getDirectorName() {
        return directorName;
    }

    public void setDirectorName(String directorName) {
        this.directorName = directorName;
    }

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    public String getUserNote() {
        return userNote;
    }

    public void setUserNote(String userNote) {
        this.userNote = userNote;
    }
}
