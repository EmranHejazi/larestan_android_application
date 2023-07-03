package app.uni.lar.models;

public class Item {
    private final String title;
    private final int imageID;
    private String content;

    public Item(String title, int imageID, String content) {
        this.title = title;
        this.imageID = imageID;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public int getImageID() {
        return imageID;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
