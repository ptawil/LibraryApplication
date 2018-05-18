package sample;

import java.util.Observable;

public class Book extends Material{
    String title;
    String author;
    String dueDate;

    public Book(javafx.beans.Observable observable) {
        super(observable);
    }

    @Override
    public void update(Observable o, Object arg) {

    }
}

