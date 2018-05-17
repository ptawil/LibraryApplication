package sample;

public class Donor extends Customer{
    Customer c;
    public Donor(Customer c){
        this.c = c;
    }

    @Override
    public void renewMaterial(int materialId) {

    }
}
