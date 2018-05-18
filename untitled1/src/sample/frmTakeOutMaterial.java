package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.ArrayList;

public class frmTakeOutMaterial {
    public Pane materialsAvailable;
    public TextField ID;
    public TextField bookTitle;
    public CheckBox book;
    public CheckBox dvd;
    public TextField materialID;
    Controller controller = new Controller();
    String type;

    @FXML
    void initialize() {
        // by writing @FXML and having an initialize method
        // I can control what happens when we first load the
        // form, namely to put up a sample customer.
        controller.displayBooks();
    }

    public void returnToMenu(ActionEvent actionEvent) {
        controller.menu();
    }

    class View {
        void drawScreen(ArrayList<Material> available) {

        }

        Stage primaryStage;

        void loadGreetScreen() {
            Main.getInstance().loadGreetScreen();

        }
        String getTypeFromScreen(){
            if (book.isSelected()){
                return "Book";
            }
            else if(dvd.isSelected()){
                return "DVD";
            }
            else{
                return null;
            }
        }
        int getMaterialID(){
            return Integer.parseInt(ID.getText());
        }
        int getCustomerID(){
            return Integer.parseInt(materialID.getText());
        }

    }

        class Controller {

            View view = new View();

            void displayBooks() {

            }

            void menu() {
                view.loadGreetScreen();

            }
            void takeOut(){
                Material a;
                Customer c = new RegularCustomer();
                c.setID(view.getCustomerID());
                c.loadCustomer(c.getID());
                type = view.getTypeFromScreen();
                if(type == "Book"){
                    a = new Book();
                }
                else{
                    a = new DVD();
                }
                int materialid = view.getMaterialID();
                c.takeOutBook(materialid, type);


            }
        }


        public void takeOutMaterial(ActionEvent actionEvent) {
            controller.takeOut();
        }
    }
