package sample;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.ArrayList;

public class frmRenewMaterial {
    public Pane materialsAvailable;
    public TextField customerID;
    public TextField materialID;
    Controller controller = new Controller();
    customerFactory cf = new customerFactory();

    @FXML
    void initialize() {
        // by writing @FXML and having an initialize method
        // I can control what happens when we first load the
        // form, namely to put up a sample customer.
    }
    public void returnToMenu(ActionEvent actionEvent) {
        controller.menu();
    }

    public void renewMaterial(ActionEvent actionEvent) {
        controller.renewMaterial();
    }

    class View {

        void loadGreetScreen() {
            Main.getInstance().loadGreetScreen();
        }
        int getCustomerId(){
            return Integer.parseInt(customerID.getText());
        }
        int getMaterialId(){
            return Integer.parseInt(materialID.getText());
        }
    }

    class Controller {

        View view = new View();
        void menu() {
            view.loadGreetScreen();

        }

        void renewMaterial() {
                Customer c = new RegularCustomer();
                c.loadCustomer(view.getCustomerId());
                String type = c.getType();
                c = cf.createCustomer(type);
                c.loadCustomer(view.getCustomerId());
                c.renewMaterial(view.getMaterialId());
        }
    }
}


