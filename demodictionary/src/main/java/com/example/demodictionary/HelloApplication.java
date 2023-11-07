package com.example.demodictionary;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.paint.Color;
import javafx.scene.image.Image;
import java.io.IOException;

public class HelloApplication extends Application {
  public static Stage stg;
    public void start(Stage stage) throws IOException {
//        Group root = new Group();
      stg= stage;
      Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        Scene scene = new Scene(root,Color.BLACK);
        Image icon = new Image("C:\\Users\\thinh\\.m2\\repository\\eu\\hansolo\\toolbox\\demodictionary\\src\\380065668_292433456898356_6043872881905538236_n.png");
        stage.getIcons().add(icon);
        stage.setWidth(850);
        stage.setHeight(624);
        stage.setTitle("DICTIONARY");

        stage.setScene(scene);
        stage.show();
    }

  public void changeScene(String fxml) throws IOException {
    Parent pane = FXMLLoader.load(getClass().getResource(fxml));
    stg.getScene().setRoot(pane);
  }


  public static void main(String[] args) {
        launch();
    }
}