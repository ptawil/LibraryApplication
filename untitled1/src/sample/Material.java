package sample;

import javafx.beans.Observable;

import java.util.Observer;

public abstract class Material implements Observer{
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


    public Material(Observable observable){
        observable.addListener();

        if (observable instanceof Customer){
            customer = (Customer)observable;
        }
    }

    public void update(){
        if (timesRenewed < 1 || customer.getType() != "regular"){
            dueDate += 14;
            timesRenewed++;
        }
    }
}
