package sample;

import javafx.beans.InvalidationListener;

public class FriendOfLibrary extends CustomerDecorator{
    Customer c;
    public FriendOfLibrary(Customer c){
        this.c = c;
    }
    @Override
    public void renewMaterial(int materialId){

    }

    public String getType(){
        return "friend";
    }

    @Override
    public void renewMaterial() {

    }
}
