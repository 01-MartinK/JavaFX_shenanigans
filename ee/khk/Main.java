package ee.khk;

import com.sun.prism.Material;
import javafx.application.Application;
import javafx.scene.shape.Box;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.text.Text;

public class Main extends Application {
    public static void main(String[] args){
        Application.launch(args);
        System.out.println("Appication run");
    }

    public void start(Stage stage){
        System.out.println("Application starts");
        Text text = new Text("Tere tulemast põrgusse!");
        Box box = new Box();
        box.setWidth(50.0);
        box.setHeight(50.0);
        box.setLayoutY(100);
        box.setLayoutX(100);
        text.setLayoutY(100);
        text.setLayoutX(100);

        Group group = new Group(text,box);

        Scene scene = new Scene(group);

        stage.setScene(scene);
        stage.setTitle("Morning Anouncement");
        stage.setWidth(320);
        stage.setHeight(320);
        stage.show();
    }

    public void init() throws Exception {
        System.out.println("Application inits");
    }

    public void stop() throws Exception {
        System.out.println("Application stops");
    }
}
