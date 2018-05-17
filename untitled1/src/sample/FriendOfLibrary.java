package sample;

public class FriendOfLibrary extends CustomerDecorator{
    Customer c;
    public FriendOfLibrary(Customer c){
        this.c = c;
    }
    @Override
    public void renewMaterial(int materialId){

    }
}
