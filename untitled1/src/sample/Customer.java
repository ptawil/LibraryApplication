package sample;
import javafx.beans.Observable;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public abstract class Customer extends Observable{
    ArrayList<Material> materials = new ArrayList<Material>();
    public int timesRenewed = 0;

    public int getTimesAllowed() {
        return timesAllowed;
    }

    public int timesAllowed = 2;
    Connection conn;

    public Customer() {}

    public void loadCustomer(int id) {
        try {
            Class.forName("org.sqlite.JDBD");
        }
        catch (ClassNotFoundException e) {
        }

        try {
            conn = DriverManager.getConnection("jdbc:sqlite:/Applications/IntelliJ IDEA.app/Contents/bin/CustomerDatabase.sqlite");
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("SELECT customerId, firstName, lastName, ssn, type  From Customers Where customerId =" + id);

            if (rs.next()) { // there was a result
                ID = id;
                first = rs.getString("firstName");
                last = rs.getString("lastName");
                SSN = rs.getString("ssn");
                type = rs.getString("type");
            }
            conn.close();
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
    public String getType(){
        return type;
    }


    int ID;
    String first, last, SSN, type;

    public void registerCustomer() {
        try {
            conn = DriverManager.getConnection("jdbc:sqlite:/Applications/IntelliJ IDEA.app/Contents/bin/CustomerDatabase.sqlite");
            Statement statement = conn.createStatement();
            statement.executeUpdate("INSERT INTO Customers VALUES(" + getID() + ",\"" + getFirst() + "\",\"" + getLast() + "\",\"" + getSSN() + "\",\"" + getType() + "\");");
            conn.close();
        }
        catch (SQLException a) {
            System.out.println(a);
        }
    }
    public void takeOutBook(int materialID, String type){
        Material m;
        if (type.equals("Book")){
            m = new Book(this);
        }
        else{
            m = new DVD(this );
        }
        m.loadMaterial(materialID);
        materials.add(m);
        try {
            conn = DriverManager.getConnection("jdbc:sqlite:/Applications/IntelliJ IDEA.app/Contents/bin/CustomerDatabase.sqlite");
            Statement statement = conn.createStatement();
            statement.executeUpdate("UPDATE Materials SET customerId = " + getID() + " WHERE materialId = " + materialID + ";");
            conn.close();
        }
        catch (SQLException a) {
            System.out.println(a);
        }
    }
    public void getTakenOutBooks(int customerId) {
        try {
            conn = DriverManager.getConnection("jdbc:sqlite:/Applications/IntelliJ IDEA.app/Contents/bin/CustomerDatabase.sqlite");
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("SELECT materialId, typeOfMaterial from Materials WHERE customerId = " + customerId + ";");
            while (rs.next()) { // there was a result
                ID = customerId;
                int materialId = Integer.parseInt(rs.getString("materialId"));
                String typeOfMaterial = rs.getString("typeOfMaterial");
                Material m;
                if (typeOfMaterial.equals("Book")) {
                    m = new Book(this);
                } else {
                    m = new DVD(this);
                }
                m.loadMaterial(materialId);
                materials.add(m);
            }
            conn.close();

        } catch (SQLException a) {
            System.out.println(a);
        }
    }
    public ArrayList<Material> getCheckedOutMaterials(){
            return materials;
    }
    public abstract void renewMaterial(int materialId);
    public void renewAll(){
        notifyAll();
    }
}
