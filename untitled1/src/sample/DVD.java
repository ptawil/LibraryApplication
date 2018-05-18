package sample;

import java.util.Observable;

public class DVD extends Material{
    String movieTitle;
    String director;

    public DVD(javafx.beans.Observable observable) {
        super(observable);
    }

    @Override
    public void update(Observable o, Object arg) {

    }
}

