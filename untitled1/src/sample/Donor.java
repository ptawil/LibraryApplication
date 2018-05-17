package sample;

public class Donor extends CustomerDecorator{
    Customer c;
    public Donor(Customer c){
        this.c = c;
    }

    @Override
    public void renewMaterial(int materialId) {

    }
}
