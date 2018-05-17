package sample;

import javafx.beans.InvalidationListener;

public class Donor extends CustomerDecorator{
    Customer c;
    public Donor(Customer c){
        this.c = c;
    }

    @Override
    public void renewMaterial(int materialId) {

    }

    public String getType(){
        return "donor";
    }

    @Override
    public void addListener(InvalidationListener listener) {

    }

    @Override
    public void removeListener(InvalidationListener listener) {

    }
}
