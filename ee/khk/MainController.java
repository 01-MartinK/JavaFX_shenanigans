package ee.khk;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.awt.event.ActionEvent;

public class MainController {

    @FXML
    private Button btn;

    @FXML
    public void click(ActionEvent event){
        btn.setText("Clicked");
    }

    public void click(javafx.event.ActionEvent actionEvent) {
        btn.setText("Clicked");
    }
}
