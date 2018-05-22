package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.util.ArrayList;

public class frmReturnMaterial {
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

    class View {



        void loadGreetScreen() {
            Main.getInstance().loadGreetScreen();

        }
    }

    class Controller {

        View view = new View();



        void menu() {
            view.loadGreetScreen();

        }
    }
}
