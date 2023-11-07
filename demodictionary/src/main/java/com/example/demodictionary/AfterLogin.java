package com.example.demodictionary;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.FadeTransition;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;
import javafx.scene.image.ImageView;
import java.io.IOException;
import org.controlsfx.glyphfont.FontAwesome;

public class AfterLogin implements Initializable{

  @FXML
  private Button logout;


  public void userLogout(ActionEvent event) throws IOException {
    HelloApplication m = new HelloApplication();
    m.changeScene("hello-view.fxml");
  }
  public void home(ActionEvent event) throws IOException {
    HelloApplication m = new HelloApplication();
    m.changeScene("afterLogin.fxml");
  }
  public void yourVocab(ActionEvent event) throws IOException {
    HelloApplication m = new HelloApplication();
    m.changeScene("vocab.fxml");
  }
  public void game(ActionEvent event) throws IOException {
    HelloApplication m = new HelloApplication();
    m.changeScene("game.fxml");
  }
  public void account(ActionEvent event) throws IOException {
    HelloApplication m = new HelloApplication();
    m.changeScene("account.fxml");
  }
  public void analyze(ActionEvent event) throws IOException {
    HelloApplication m = new HelloApplication();
    m.changeScene("analyze.fxml");
  }

  public void amount(ActionEvent actionEvent) throws IOException {
    HelloApplication m = new HelloApplication();
    m.changeScene("amount.fxml");
  }

  public void time(ActionEvent actionEvent) throws IOException {
    HelloApplication m = new HelloApplication();
    m.changeScene("time.fxml");
  }

  public void info(ActionEvent actionEvent) throws IOException {
    HelloApplication m = new HelloApplication();
    m.changeScene("info.fxml");
  }
  @FXML
  private ImageView gaming_time;
  @FXML
  private Button hangman;
  @FXML
  private Button millionaire;
  @FXML
  private ImageView vocabulary;
  @FXML
  private Button your_words;
  @FXML
  private Button flashcard;
  @FXML
  private ImageView look;
  @FXML
  private AnchorPane intro;
  @FXML
  private AnchorPane searchbar;
  @FXML
  private Label tag1;
  @FXML
  private Label tag2;
  @FXML
  private Label tag3;
  @FXML
  private Label tag4;
  @FXML
  private Label tag5;
  public void FadeEffect(Button node) {
    FadeTransition fade = new FadeTransition();
    fade.setNode(node);
    fade.setDuration(Duration.millis(700));
    fade.setFromValue(0);
    fade.setToValue(1);
    fade.play();
  }
  public void FadeEffect2(Label node) {
    FadeTransition fade = new FadeTransition();
    fade.setNode(node);
    fade.setDuration(Duration.millis(1000));
    fade.setFromValue(0);
    fade.setToValue(1);
    fade.play();
  }
  public void FadeEffect3(AnchorPane node) {
    FadeTransition fade = new FadeTransition();
    fade.setNode(node);
    fade.setDuration(Duration.millis(1000));
    fade.setFromValue(0);
    fade.setToValue(1);
    fade.play();
  }
  public void RotateEffect(ImageView image){
    RotateTransition rotate = new RotateTransition();
    rotate.setNode(image);
    rotate.setDuration(Duration.millis(500));
    rotate.setByAngle(360);
    rotate.setAxis(Rotate.X_AXIS);
    rotate.play();
  }
  public void RotateEffect2(AnchorPane image){
    RotateTransition rotate = new RotateTransition();
    rotate.setNode(image);
    rotate.setDuration(Duration.millis(500));
    rotate.setByAngle(360);
    rotate.setAxis(Rotate.Y_AXIS);
    rotate.play();
  }
  public void Scale(ImageView image){
    ScaleTransition scale = new ScaleTransition();
    scale.setNode(image);
    scale.setDuration(Duration.millis(1000));
    scale.setByX(0.5);
    scale.setByY(0.5);
    scale.setAutoReverse(true);
    scale.play();
  }
  public void Scale2(AnchorPane image){
    ScaleTransition scale = new ScaleTransition();
    scale.setNode(image);
    scale.setDuration(Duration.millis(1000));
    scale.setByX(0.2);
    scale.setByY(0.2);
    scale.setAutoReverse(true);
    scale.play();
  }
  public void Scale3(ImageView image){
    ScaleTransition scale = new ScaleTransition();
    scale.setNode(image);
    scale.setDuration(Duration.millis(1000));
    scale.setCycleCount(TranslateTransition.INDEFINITE);
    scale.setByX(0.5);
    scale.setByY(0.5);
    scale.setAutoReverse(true);
    scale.play();
  }
  @Override
  public void initialize(URL url, ResourceBundle resourceBundle) {

    RotateEffect(gaming_time);
    FadeEffect(hangman);
    FadeEffect(millionaire);
    RotateEffect(vocabulary);
    FadeEffect(your_words);
    FadeEffect(flashcard);
    Scale(vocabulary);
    Scale(gaming_time);
    Scale3(look);
    Scale2(intro);
    RotateEffect2(intro);
    FadeEffect2(tag1);
    FadeEffect2(tag2);
    FadeEffect2(tag3);
    FadeEffect2(tag4);
    FadeEffect2(tag5);
    FadeEffect3(searchbar);
  }

}