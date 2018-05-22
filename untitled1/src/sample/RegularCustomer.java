package sample;

import javafx.beans.InvalidationListener;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RegularCustomer extends Customer {

    @Override
    public String getType() {
        return "regular";
    }

    @Override
    public void renewMaterial(int materialId) {
        if (timesRenewed < timesAllowed) {
            timesRenewed++;
            try {
                conn = DriverManager.getConnection("jdbc:sqlite:/Applications/IntelliJ IDEA.app/Contents/bin/CustomerDatabase.sqlite");
                Statement statement = conn.createStatement();
                statement.executeUpdate("UPDATE Materials SET dueDate = dueDate + 14 WHERE materialId = " + materialId + ";");
                conn.close();
            } catch (SQLException a) {
                System.out.println(a);


            }
        }
    }

    @Override
    public void addListener(InvalidationListener listener) {

    }

    @Override
    public void removeListener(InvalidationListener listener) {

    }
}
