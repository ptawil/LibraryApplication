package sample;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class frmLoadCustomer {
    public TextField txtFirstName;
    public TextField txtLastName;

    Controller controller = new Controller();

    @FXML
    void initialize() {
        // by writing @FXML and having an initialize method
        // I can control what happens when we first load the
        // form, namely to put up a sample customer.
        controller.startWithSampleCustomer();
    }

    class View {
        void drawScreen(Customer customer) {
            txtFirstName.setText(customer.getFirst());
            txtLastName.setText(customer.getLast());
        }
    }

    class Controller {
        View view = new View();

        void startWithSampleCustomer() {
            Customer c = new Customer("Jesssica", "Jones");
            view.drawScreen(c);
        }

    }

    class Customer {
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

        String first, last;
        public Customer(String first, String last) {
            this.first = first;
            this.last = last;
        }
    }

}
