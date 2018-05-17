package sample;

public class Donor extends CustomerDecorator{
    Customer c;
    int renewals = 4;
    public Donor(Customer c){
        this.c = c;
    }

    @Override
    public void renewMaterial(int materialId) {
        if(renewals > 0){
            renewals--;
        }
    }
}
