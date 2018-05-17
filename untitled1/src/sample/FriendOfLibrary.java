package sample;

public class FriendOfLibrary extends CustomerDecorator{
    Customer c;
    int renewals = 2;
    public FriendOfLibrary(Customer c){
        this.c = c;
    }
    @Override
    public void renewMaterial(int materialId){
        if (renewals > 0){
            renewals--;
        }
        else{

        }
    }
}
