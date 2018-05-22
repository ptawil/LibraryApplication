package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.util.ArrayList;

public class frmReturnMaterial {
    public TextField txtMaterialID;
    public TextField txtCustomerID;
    Controller controller = new Controller();

    @FXML
    void initialize() {
        // by writing @FXML and having an initialize method
        // I can control what happens when we first load the
        // form, namely to put up a sample customer.
    }

    public void returnToMenu(ActionEvent actionEvent) {
        controller.menu();
    }

    public void returnMaterial(ActionEvent actionEvent) {
        controller.returnMaterial();
    }

    class View {



        void loadGreetScreen() {
            Main.getInstance().loadGreetScreen();

        }
        int getMaterialID(){
            return Integer.parseInt(txtMaterialID.getText());
        }

        int getCustomerId(){
            return Integer.parseInt(txtCustomerID.getText());
        }

    }

    class Controller {

        View view = new View();



        void menu() {
            view.loadGreetScreen();

        }
        void returnMaterial(){
            int materialID = view.getMaterialID();
            int customerID = view.getCustomerId();
            Customer c = new RegularCustomer();
            c.returnBook(materialID);
        }
    }
}
