package sample;

import javafx.beans.Observable;

import java.util.Observer;

public abstract class Material{
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
    int timesRenewed = 0;
    Customer customer;

}
