
package sample;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

public class frmCreateCustomer {
    public TextField txtFirstName;
    public TextField txtLastName;
    public TextField txtSSN;
    public TextField type;
    public CheckBox regular;
    public CheckBox donor;
    public CheckBox friend;

    int id = 1;

    Controller controller = new Controller();
    customerFactory cf = new customerFactory();

    @FXML
    void initialize() {
        // by writing @FXML and having an initialize method
        // I can control what happens when we first load the
        // form, namely to put up a sample customer.
    }

    public void createCustomer(ActionEvent actionEvent) {
        String firstName = txtFirstName.getText();
        String lastName = txtLastName.getText();
        String sSN = txtSSN.getText();
        controller.startWithSampleCustomer();
        controller.createCustomer(firstName, lastName, sSN);

    }

    class View {
        void drawScreen(Customer customer) {
            txtFirstName.setText(customer.getFirst());
            txtLastName.setText(customer.getLast());
        }
        String type(){
            if (regular.isSelected()){
                return "regular";
            }
            else if(friend.isSelected()){
                return "friend";
            }
            else if(donor.isSelected()){
                return "donor";
            }
            else{
                return "invalid";
            }
        }
    }

    class Controller {
        View view = new View();

        void startWithSampleCustomer() {
        }
        void createCustomer(String first, String last, String ssn){
            Customer c = cf.createCustomer(view.type());
            c.setFirst(first);
            c.setLast(last);
            c.setSSN(ssn);
            c.setID(id);
            id++;
            System.out.println(id);
            c.registerCustomer();
        }
    }

}