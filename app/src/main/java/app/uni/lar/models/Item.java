package app.uni.lar.models;

public class Item {
    private String title;
    private int imageID;
    private String content;

    public Item(String title, int imageID, String content) {
        this.title = title;
        this.imageID = imageID;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getImageID() {
        return imageID;
    }

    public void setImageID(int imageID) {
        this.imageID = imageID;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
