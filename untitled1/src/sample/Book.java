package sample;


public class Book extends Material{
    String title;
    String author;
    String dueDate;

    public Book(Observable observable) {
        super((Customer) observable);
    }

}

