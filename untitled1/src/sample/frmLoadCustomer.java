package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class frmLoadCustomer {
    public TextField txtFirstName;
    public TextField txtLastName;
    public TextField txtId;

    Controller controller = new Controller();

    @FXML
    void initialize() {
        // by writing @FXML and having an initialize method
        // I can control what happens when we first load the
        // form, namely to put up a sample customer.
    }

    public void search(ActionEvent actionEvent) {
        controller.loadCustomer();
    }

    public void returnToMenu(ActionEvent actionEvent) {
        controller.menu();

    }

    class View {
        void drawScreen(Customer customer) {
            txtFirstName.setText(customer.getFirst());
            txtLastName.setText(customer.getLast());
        }
        int getSearchId(){
            int id = Integer.parseInt(txtId.getText());
            return id;
        }
        void loadGreetScreen() {
            Main.getInstance().loadGreetScreen();

        }
    }

    class Controller {
        View view = new View();
        void menu(){
            view.loadGreetScreen();
        }

        void loadCustomer(){
            int id = view.getSearchId();
            Customer c = new RegularCustomer();
            c.loadCustomer(id);
            txtFirstName.setText(c.getFirst());
            txtLastName.setText(c.getLast());
    }


    }

}
