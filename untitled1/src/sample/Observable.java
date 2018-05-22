package sample;

import java.util.ArrayList;

public abstract class Observable {
    ArrayList l = new ArrayList();

    public void addObserver(Observer o){
        l.add(o);
    }

    public void removeObserver(Observer o){
        l.remove(o);
    }
    public void notifyObservers(){
        for (observer : l){
            observer.update();
        }
    }
}
