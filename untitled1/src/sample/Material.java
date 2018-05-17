package sample;

public class Material {
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    String title;
    String author;
    int bookID;
    int dueDate = 14;


    public Material(){
    }

    public int getDueDate() {
        return dueDate;
    }
}
