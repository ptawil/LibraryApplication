package sample;
import javafx.beans.Observable;

import java.sql.*;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.ResultSetMetaData;
import java.sql.DatabaseMetaData;
import java.util.ArrayList;

public abstract class Customer{
    ArrayList<Material> materials = new ArrayList<Material>();
    public Customer() {}

    public void loadCustomer(int id) {
        try {
            Class.forName("org.sqlite.JDBD");
        }
        catch (ClassNotFoundException e) {
        }

        try {
            Connection conn = DriverManager.getConnection("jdbc:sqlite:/Applications/IntelliJ IDEA.app/Contents/bin/CustomerDatabase.sqlite");
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("SELECT customerId, firstName, lastName, ssn  From Customers Where customerId =" + id);

            if (rs.next()) { // there was a result
                ID = id;
                first = rs.getString("firstName");
                last = rs.getString("lastName");
                SSN = rs.getString("ssn");
            }
        }
        catch (SQLException a){
            System.out.println(a);
        }
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public String getSSN() {
        return SSN;
    }

    public void setSSN(String ssn) {
        this.SSN = ssn;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public abstract String getType();

    int ID;
    String first, last, SSN;

    public void registerCustomer() {
        try {
            Connection conn = DriverManager.getConnection("jdbc:sqlite:/Applications/IntelliJ IDEA.app/Contents/bin/CustomerDatabase.sqlite");
            Statement statement = conn.createStatement();
            statement.executeUpdate("INSERT INTO Customers VALUES(" + getID() + ",\"" + getFirst() + "\",\"" + getLast() + "\",\"" + getSSN() + "\");");
        }
        catch (SQLException a) {
            System.out.println(a);
        }
    }
    public void takeOutBook(int materialID, String type){
        Material m;
        if (type == "Book"){
            m = new Book();
        }
        else{
            m = new DVD();
        }
        m.loadMaterial(materialID);
        materials.add(m);
        try {
            Connection conn = DriverManager.getConnection("jdbc:sqlite:/Applications/IntelliJ IDEA.app/Contents/bin/CustomerDatabase.sqlite");
            Statement statement = conn.createStatement();
            statement.executeUpdate("UPDATE Materials SET customerId = " + getID() + " WHERE materialId = " + materialID + ";");
        }
        catch (SQLException a) {
            System.out.println(a);
        }
    }
    public abstract void renewMaterial(int materialId);

}
