package sample;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public abstract class Customer implements Observable{
    ArrayList<Material> materials = new ArrayList<Material>();
    public int timesRenewed = 0;

    public int getTimesAllowed() {
        return timesAllowed;
    }

    public int timesAllowed = 2;

    public Customer() {}
    protected static Connection c = null;
    public static Connection getConn(){
        if(c == null) {
            try {
                Class.forName("org.sqlite.JDBC");
                c = DriverManager.getConnection("jdbc:sqlite:/Applications/IntelliJ IDEA.app/Contents/bin/CustomerDatabase.sqlite");
            }
            catch (SQLException a){
                System.out.println(a);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return c;
    }

    public void loadCustomer(int id) {
        try {
            Class.forName("org.sqlite.JDBD");
        }
        catch (ClassNotFoundException e) {
        }

        try {
            Statement statement = getConn().createStatement();
            ResultSet rs = statement.executeQuery("SELECT customerId, firstName, lastName, ssn, type  From Customers Where customerId =" + id);

            if (rs.next()) { // there was a result
                ID = id;
                first = rs.getString("firstName");
                last = rs.getString("lastName");
                SSN = rs.getString("ssn");
                type = rs.getString("type");
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
    public String getType(){
        return type;
    }


    int ID;
    String first, last, SSN, type;

    public void registerCustomer() {
        try {
            Statement statement = getConn().createStatement();
            statement.executeUpdate("INSERT INTO Customers VALUES(" + getID() + ",\"" + getFirst() + "\",\"" + getLast() + "\",\"" + getSSN() + "\",\"" + getType() + "\");");

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
        //m.loadMaterial(materialID);
        //materials.add(m);
        try {
            Statement statement = getConn().createStatement();
            statement.executeUpdate("UPDATE Materials SET customerId = " + getID() + " WHERE materialId = " + materialID + ";");
        }
        catch (SQLException a) {
            System.out.println(a);
        }
    }
    public void returnBook(int materialID){
        try {
            Statement statement = getConn().createStatement();
            statement.executeUpdate("UPDATE Materials SET customerId = 0  WHERE materialId = " + materialID + ";");
        }
        catch (SQLException a) {
            System.out.println(a);
        }
    }
    public void getTakenOutBooks(int customerId) {
        try {
            Statement statement = getConn().createStatement();
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

    public void addObserver(Observer o){
        materials.add((Material)o);
    }

    public void removeObserver(Observer o){
        materials.remove(o);
    }

    public void notifyObservers(){
        for (Material observer:materials){  // loop through and call update
            observer.update();
        }
    }
}
