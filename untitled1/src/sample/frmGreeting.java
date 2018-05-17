package sample;


import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.stage.StageStyle;

public class frmGreeting {

    public Button btnCreateCustomer;
    public Button btnLoadCustomer;

    public void btnCreateCustomer_click(ActionEvent actionEvent) {
        Main.getInstance().loadCreateCustomer();
    }

    public void btnLoadCustomer_click(ActionEvent actionEvent) {
        Main.getInstance().loadLoadCustomer();
    }

    public void btnTakeOutMaterial_click(ActionEvent actionEvent) {
        Main.getInstance().loadTakeOutMaterial();
    }

    public void btnReturnMaterial_click(ActionEvent actionEvent) {
        Main.getInstance().loadReturnMaterial();
    }

    public void btnRenewMaterial_click(ActionEvent actionEvent) {
        Main.getInstance().loadRenewMaterial();
    }
}
