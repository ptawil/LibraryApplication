package sample;

import javafx.beans.InvalidationListener;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class FriendOfLibrary extends CustomerDecorator{
    Customer c;

    public FriendOfLibrary(Customer c){
        this.c = c;
    }
    @Override
    public void renewMaterial(int materialId){

        if (timesRenewed < c.getTimesAllowed() + 2) {
            timesRenewed++;
            try {
                Statement statement = getConn().createStatement();
                statement.executeUpdate("UPDATE Materials SET dueDate = dueDate + 14 WHERE materialId = " + materialId + ";");

            }
            catch (SQLException a) {
                System.out.println(a);

            }
        }
    }

    @Override
    public String getType(){
        return "friend";
    }



}
