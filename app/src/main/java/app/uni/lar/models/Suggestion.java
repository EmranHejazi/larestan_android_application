package app.uni.lar.models;

public class Suggestion {
    private String title;
    private int imageID;

    public Suggestion(String title, int imageID) {
        this.title = title;
        this.imageID = imageID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String description) {
        this.title = description;
    }

    public int getImageID() {
        return imageID;
    }

    public void setImageID(int imgId) {
        this.imageID = imgId;
    }
}
