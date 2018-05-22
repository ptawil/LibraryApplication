package sample;

import javafx.beans.InvalidationListener;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Donor extends CustomerDecorator{
    Customer c;

    public Donor(Customer c){
        this.c = c;
    }

    @Override
    public void renewMaterial(int materialId) {
        if (timesRenewed < c.getTimesAllowed() + 4) {

            try {
                Statement statement = getConn().createStatement();
                statement.executeUpdate("UPDATE Materials SET dueDate = dueDate + 14 WHERE materialId = " + materialId + ";");
                timesRenewed++;
            }
            catch (SQLException a) {
                System.out.println(a);


            }
        }

    }
    @Override
    public String getType(){
        return "donor";
    }


}
