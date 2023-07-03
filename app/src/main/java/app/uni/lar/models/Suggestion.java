package app.uni.lar.models;

public class Suggestion {
    private final String title;
    private final int imageID;

    public Suggestion(String title, int imageID) {
        this.title = title;
        this.imageID = imageID;
    }

    public String getTitle() {
        return title;
    }

    public int getImageID() {
        return imageID;
    }

}
