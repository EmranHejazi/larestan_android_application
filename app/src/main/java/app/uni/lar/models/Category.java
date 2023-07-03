package app.uni.lar.models;

public class Category {
    private final String title;
    private final int imageID;

    public Category(String title, int imageID) {
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
