package com.example.demodictionary;

import java.io.FileNotFoundException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.scene.transform.Rotate;
import javafx.scene.web.WebView;
import javafx.util.Duration;
import javafx.scene.image.ImageView;
import java.io.IOException;
import org.controlsfx.glyphfont.FontAwesome;
import org.apache.commons.text.StringEscapeUtils;
public class AfterLogin implements Initializable{

  @FXML
  private Button logout;

  public AfterLogin() throws FileNotFoundException {
  }


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
  public void hangman(ActionEvent actionEvent) throws IOException {
    HelloApplication m = new HelloApplication();
    m.changeScene("hangman.fxml");
  }
  public void millionaire(ActionEvent actionEvent) throws IOException {
    HelloApplication m = new HelloApplication();
    m.changeScene("millionaire.fxml");
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
  @FXML
  private Button analyze;
  @FXML
  private Button time;
  @FXML
  private Button info;
  @FXML
  private Button amount;
  @FXML
  private Button show_all;
  @FXML
  private AnchorPane hello_tag;
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
  public void translate1(Button image) {
    TranslateTransition translate = new TranslateTransition();
    translate.setNode(image);
    translate.setDuration(Duration.millis(700));
    translate.setByY(83);
    translate.play();
  }
  public void translate2(TextArea image) {
    TranslateTransition translate = new TranslateTransition();
    translate.setNode(image);
    translate.setDuration(Duration.millis(700));
    translate.setByY(75);
    translate.play();
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
    FadeEffect3(hello_tag);
    translate1(analyze);
    translate1(amount);
    translate1(time);
    translate1(info);
    translate1(show_all);
    translate1(speakEL);
    translate1(speakVN);
    translate2(translate_text);
    translate2(translated);
  }
  @FXML
  private TextArea translate_text;
  @FXML
  private TextArea translated;
  @FXML
  private Button search_btn;
  @FXML
  private void translateAndSet(javafx.event.ActionEvent event) throws IOException {
    String inputText = translate_text.getText();
    String translatedText = TranslatorApi.translateViToEn(inputText);
    translated.setText(translatedText);
  }
  @FXML
  private void showAll(javafx.event.ActionEvent event) throws IOException {

  }
  @FXML
  private WebView definitionView = new WebView();

  @FXML
  private Button find;
  @FXML
  private TextField search_term;
  @FXML
  private ImageView intro_image;
  @FXML
  private ListView<String> listView;
 @FXML
  private void lookup(javafx.event.ActionEvent event) throws IOException, SQLException {
    intro_image.setVisible(false);
    String inputText = search_term.getText();
    List<String> suggestedWords = Trie.dictionarySearched(inputText);
    ObservableList<String> items = FXCollections.observableArrayList(suggestedWords);
    listView.setItems(items);
    DatabaseDictionary databaseDictionary = new DatabaseDictionary();
    databaseDictionary.initialize();
    String translatedText = databaseDictionary.dictionaryLookup(inputText);
    definitionView.getEngine().loadContent(translatedText, "text/html");
  }
  @FXML
  private Button speakEL;
  @FXML
  private Button speakVN;
  @FXML
  private void speakVN(javafx.event.ActionEvent event) throws IOException {
    String inputText = translate_text.getText();
    TextToSpeech.playSoundVietnamese(inputText);
  }
  @FXML
  private void speakEL(javafx.event.ActionEvent event) throws IOException {
    String inputText = translated.getText();
    TextToSpeech.playSoundEnglish(inputText);
  }

}