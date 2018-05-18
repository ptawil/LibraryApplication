package sample;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.ArrayList;

public class frmTakeOutMaterial {
    public Pane materialsAvailable;
    public ChoiceBox availableMaterials;
    public TextField ID;
    public TextField bookTitle;
    public CheckBox book;
    public CheckBox dvd;
    Controller controller = new Controller();

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
    }

        class Controller {

            View view = new View();

            void displayBooks() {

            }

            void menu() {
                view.loadGreetScreen();

            }
        }


        public void takeOutMaterial(ActionEvent actionEvent) {
            String title = bookTitle.getText();
            Material b = new Book(title);
        }
    }
