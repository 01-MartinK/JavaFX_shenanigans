package ee.khk;

import javafx.application.Application;
import javafx.beans.Observable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import javafx.scene.control.TreeItem;
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
    public static String text = "";
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

        // puu asjad
        // määrame juurelemendi
        TreeItem<String> rootTreeNode = new TreeItem<String>("Keeled");

        // määrame sõlmed
        TreeItem<String> germanics = new TreeItem<String>("germanics");
        germanics.getChildren().add(new TreeItem<String>("German"));
        germanics.getChildren().add(new TreeItem<String>("English"));

        TreeItem<String> Roman = new TreeItem<String>("Roman");
        Roman.getChildren().add(new TreeItem<String>("French"));
        Roman.getChildren().add(new TreeItem<String>("Spanish"));
        Roman.getChildren().add(new TreeItem<String>("Italian"));

        // lisame rooti
        rootTreeNode.getChildren().add(germanics);
        rootTreeNode.getChildren().add(Roman);


        // Nupud ja muud asjad
        CheckBox clickCount = new CheckBox("Count Clicks");
        RadioButton doubleClick = new RadioButton("Click Doubled");
        CheckBox showClickCount = new CheckBox("Show clicks");
        clickCount.setSelected(true);
        showClickCount.setSelected(true);
        showClickCount.setOnAction(event -> show());

        ObservableList<String> langs = FXCollections.observableArrayList("java","C#","Python","Quack","Crack");
        ListView<String> langsViewList = new ListView<String>(langs);

        MultipleSelectionModel<String> langSelectionModel = langsViewList.getSelectionModel();

        langSelectionModel.selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String oldValue, String newValue) {
                text = newValue;
                lbl.setText(text + " lines coded: " + String.valueOf(clicks));
            }
        });

        ComboBox<String> comboBox = new ComboBox<String>(langs);
        comboBox.setOnAction(event -> text = comboBox.getValue());

        ChoiceBox<String> choiceBox = new ChoiceBox<String>(langs);
        choiceBox.setOnAction(event -> text = choiceBox.getValue());

        ToggleButton autoClicker = new ToggleButton("Auto Click");

        Label lbl = new Label(text+" lines coded: 0");
        Button btn = new Button("test");
        TextArea txa = new TextArea();

        txa.setPrefRowCount(2);
        txa.setPrefColumnCount(5);
        lbl.setPrefWidth(150);
        lbl.setAlignment(Pos.CENTER);
        btn.setPrefWidth(80);
        btn.setPrefHeight(40);

        TreeView<String> langsTreeView = new TreeView<String>(rootTreeNode);


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
                    if (showClickCount.isSelected()){ lbl.setText(text + " lines coded: " + String.valueOf(clicks));}
                }
            }
        });

        // Tseeni asjad ja muud
        FlowPane root = new FlowPane(Orientation.VERTICAL,10,10);
        root.getChildren().addAll( lbl, btn, clickCount, doubleClick, showClickCount, autoClicker, txa, langsViewList, comboBox, choiceBox, langsTreeView);
        root.setAlignment(Pos.CENTER);
        Scene scene = new Scene(root,0,0);

        stage.setScene(scene);

        stage.setTitle("test FXML");
        stage.setWidth(1000);
        stage.setHeight(600);

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
