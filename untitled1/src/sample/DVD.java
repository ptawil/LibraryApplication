package sample;



public class DVD extends Material{
    String movieTitle;
    String director;

    public DVD(Observable observable) {
        super((Customer) observable);
    }

}

