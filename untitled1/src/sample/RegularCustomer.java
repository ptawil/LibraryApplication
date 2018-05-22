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
                Statement statement = getConn().createStatement();
                statement.executeUpdate("UPDATE Materials SET dueDate = dueDate + 14 WHERE materialId = " + materialId + ";");

            } catch (SQLException a) {
                System.out.println(a);


            }
        }
    }

}
