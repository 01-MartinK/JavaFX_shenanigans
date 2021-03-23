package ee.khk;

import com.sun.prism.Material;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.FlowPane;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.Box;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.text.Text;

import java.awt.*;

public class Main extends Application {

    public static int test = 0;

    public static void main(String[] args){
        Application.launch(args);
    }

    @Override
    public void start(Stage stage){

        Label label = new Label("Tere tulemast põrgusse!");
        label.setText(String.valueOf(test));
        Button button = new Button("Button");

        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

                test++;
                label.setText(String.valueOf(test));
            }
        });

        Group group = new Group(button);

        FlowPane root = new FlowPane(label, group);
        Scene scene = new Scene(root, 300, 300, Color.BLUE);
        stage.setScene(scene);

        stage.setTitle("Welcome to purgatory");

        stage.show();
    }
}
