package ee.khk;

import com.sun.prism.Material;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Box;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.text.Text;
import java.awt.*;
//import java.awt.TextArea;
import java.util.Timer;
import java.util.concurrent.Flow;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;

import javax.swing.*;

public class Main extends Application {

    public static int clicks = 0;
    Checkbox clickCount;
    CheckBox showClickCount;
    Label lbl;
    ToggleButton autoClicker;
    TextArea txa;

    public static void main(String[] args){
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception{

        CheckBox clickCount = new CheckBox("Count Clicks");
        RadioButton doubleClick = new RadioButton("Click Doubled");
        CheckBox showClickCount = new CheckBox("Show clicks");
        clickCount.setSelected(true);
        showClickCount.setSelected(true);
        showClickCount.setOnAction(event -> show());

        ToggleButton autoClicker = new ToggleButton("Auto Click");

        Label lbl = new Label("clicks : 0");
        Button btn = new Button("test");
        TextArea txa = new TextArea();

        txa.setPrefRowCount(2);
        txa.setPrefColumnCount(5);
        lbl.setPrefWidth(80);
        lbl.setAlignment(Pos.CENTER);
        btn.setPrefWidth(80);
        btn.setPrefHeight(40);



        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if (clickCount.isSelected()) {
                    if (doubleClick.isSelected()){
                        clicks++;
                        clicks++;
                    }else{
                        clicks++;
                    }
                    if (showClickCount.isSelected()){ lbl.setText("clicks: " + String.valueOf(clicks));}
                }
            }
        });

        FlowPane root = new FlowPane(Orientation.VERTICAL,10,10);
        root.getChildren().addAll( lbl, btn, clickCount, doubleClick, showClickCount, autoClicker, txa);
        root.setAlignment(Pos.CENTER);
        Scene scene = new Scene(root,100,100);

        stage.setScene(scene);

        stage.setTitle("test FXML");
        stage.setWidth(300);
        stage.setHeight(300);

        stage.show();

    }

    private void show(){

        if (showClickCount.isSelected()) {
            lbl.setText("Clicks = "+String.valueOf(clicks));
        }else{
            lbl.setText("Wont show clicks to you!");
        }
    }
}
