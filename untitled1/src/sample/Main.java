package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.util.ArrayList;

public class Main extends Application {
    ArrayList<Material> materials = new ArrayList<Material>();


    public static Main getInstance() {
        return uniqueInstance;
    }


    static Main uniqueInstance;
    Stage primaryStage;

    @Override
    public void start(Stage primaryStage) throws Exception{
        uniqueInstance = this;
        this.primaryStage = primaryStage;
        loadGreetScreen();
    }

    public void loadGreetScreen()  {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("frmGreeting.fxml"));
            primaryStage.setTitle("OOPS Library Application");
            primaryStage.setScene(new Scene(root, 500, 500));
            primaryStage.show();
        }
        catch (Exception e) {}

        }

    public void loadLoadCustomer() {
        try {

            Parent root = FXMLLoader.load(getClass().getResource("frmLoadCustomer.fxml"));
            primaryStage.setTitle("OOPS Library Application - Load Customer");
            primaryStage.setScene(new Scene(root, 500, 500));
            primaryStage.show();
        }
        catch (Exception e) {
        }
    }
    public void loadCreateCustomer()  {
        try {

            Parent root = FXMLLoader.load(getClass().getResource("frmCreateCustomer.fxml"));
            primaryStage.setTitle("OOPS Library Application - Create Customer");
            primaryStage.setScene(new Scene(root, 500, 500));
            primaryStage.show();
            }
            catch (Exception e) {}

}




    public void loadTakeOutMaterial() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("frmTakeOutMaterial.fxml"));
            primaryStage.setTitle("OOPS Library Application - Take Out Materials");
            primaryStage.setScene(new Scene(root, 500, 275));
            primaryStage.show();
        }
        catch (Exception e) {}


    }

    public void loadReturnMaterial() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("frmReturnMaterial.fxml"));
            primaryStage.setTitle("OOPS Library Application - Return Materials");
            primaryStage.setScene(new Scene(root, 500, 275));
            primaryStage.show();
        }
        catch (Exception e) {}

    }

    public void loadRenewMaterial() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("frmRenewMaterial.fxml"));
            primaryStage.setTitle("OOPS Library Application - Renew Materials");
            primaryStage.setScene(new Scene(root, 500, 275));
            primaryStage.show();
        }
        catch (Exception e) {}

    }
    public static void main(String[] args) {
        launch(args);
    }
}
