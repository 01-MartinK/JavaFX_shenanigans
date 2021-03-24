package ee.khk;

import com.sun.prism.Material;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.FlowPane;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Box;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.text.Text;

import java.awt.*;
import java.util.concurrent.Flow;

public class Main extends Application {

    public static int clicks = 0;

    public static void main(String[] args){
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception{

        Label lbl = new Label("welcome");
        Button btn = new Button("test");

        lbl.setPrefWidth(80);
        btn.setPrefWidth(80);

        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                clicks++;
                lbl.setText(String.valueOf(clicks));
            }
        });

        FlowPane root = new FlowPane();
        root.getChildren().addAll(lbl,btn);
        Scene scene = new Scene(root,100,100);

        stage.setScene(scene);

        stage.setTitle("test FXML");
        stage.setWidth(300);
        stage.setHeight(300);

        stage.show();

    }
}
