package sample;

import javafx.beans.Observable;

import java.sql.*;
import java.util.Observer;

public abstract class Material{
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    String title;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getBookID() {
        return bookID;
    }

    public void setBookID(int bookID) {
        this.bookID = bookID;
    }

    public int getDueDate() {
        return dueDate;
    }

    public void setDueDate(int dueDate) {
        this.dueDate = dueDate;
    }

    public int getTimesRenewed() {
        return timesRenewed;
    }

    public void setTimesRenewed(int timesRenewed) {
        this.timesRenewed = timesRenewed;
    }

    String author;
    int bookID;
    int dueDate = 14;
    int timesRenewed = 0;
    Customer customer;

    public void loadMaterial(int materialid) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:sqlite:/Applications/IntelliJ IDEA.app/Contents/bin/CustomerDatabase.sqlite");
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("SELECT materialId, title, author, dueDate  From Materials Where materialId =" + materialid);

            if (rs.next()) { // there was a result

                title = rs.getString("title");
                author = rs.getString("author");
                dueDate = Integer.parseInt(rs.getString("dueDate"));
                bookID = materialid;
            }
        } catch (SQLException a) {
            System.out.println(a);
        }
    }

}
