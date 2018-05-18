package sample;

import javafx.beans.InvalidationListener;

public class RegularCustomer extends Customer{
    int timesRenewed = 0;


    @Override
    public String getType() {
        return null;
    }

    @Override
    public void renewMaterial(int materialId) {

    }

    @Override
    public void addListener(InvalidationListener listener) {

    }

    @Override
    public void removeListener(InvalidationListener listener) {

    }
}
