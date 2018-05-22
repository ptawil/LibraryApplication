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
            try {
                conn = DriverManager.getConnection("jdbc:sqlite:/Applications/IntelliJ IDEA.app/Contents/bin/CustomerDatabase.sqlite");
                Statement statement = conn.createStatement();
                statement.executeUpdate("UPDATE Materials SET dueDate = dueDate + 14 WHERE materialId = " + materialId + ";");
                timesRenewed++;
                conn.close();
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


    @Override
    public void addListener(InvalidationListener listener) {

    }

    @Override
    public void removeListener(InvalidationListener listener) {

    }

}
