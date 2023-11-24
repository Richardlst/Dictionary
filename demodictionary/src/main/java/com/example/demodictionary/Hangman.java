package com.example.demodictionary;

import java.io.IOException;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;
import javafx.util.Duration;

public class Hangman {
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
  public void backToGame(ActionEvent event) throws IOException {
    HelloApplication m = new HelloApplication();
    m.changeScene("game.fxml");
  }
  @FXML
  private ImageView base1;
  @FXML
  private ImageView base2;
  @FXML
  private ImageView base3;
  @FXML
  private ImageView base4;
  @FXML
  private ImageView base5;
  @FXML
  private ImageView base6;
  @FXML
  private ImageView base7;
  @FXML
  private Text text;
  @FXML
  private Pane buttons;
  @FXML
  private Text winStatus;
  @FXML
  private Text realWord;

  private int mistakes;
  private int correct;
  private final Words word = new Words();
  private String myWord;
  private List<String> myLetters;
  private List<String> answer;

  public Hangman() throws FileNotFoundException {
  }

  @FXML
  public void initialize() {
    FadeEffect3(hangman_bg);
    base1.setVisible(true);
    base2.setVisible(false);
    base3.setVisible(false);
    base4.setVisible(false);
    base5.setVisible(false);
    base6.setVisible(false);
    base7.setVisible(false);
    mistakes=0;
    correct=0;
    myWord = word.getRandomWord();
    myLetters = Arrays.asList(myWord.split(""));
    answer = Arrays.asList(new String[myLetters.size()*2]);
    for(int i=0; i<myLetters.size()*2; i++){
      if(i%2==0){
        answer.set(i, "_");
      }else{
        answer.set(i, " ");
      }
    }
    String res = String.join("", answer);
    text.setText(res);
    winStatus.setText("");
    realWord.setText("");
    buttons.setDisable(false);
  }

  @FXML
  public void onClick(ActionEvent event){
    String letter = ((Button)event.getSource()).getText();
    ((Button) event.getSource()).setDisable(true);
    if(myLetters.contains(letter)){
      correct++;
      int letterIndex = myLetters.indexOf(letter);
      answer.set(letterIndex*2, letter);
      String res = String.join("", answer);
      text.setText(res);
      if(correct==myWord.length()){
        winStatus.setText("You Win!");
        buttons.setDisable(true);
      }
    }else{
      mistakes++;
      if(mistakes ==1) base2.setVisible(true);
      else if (mistakes ==2) base3.setVisible(true);
      else if (mistakes ==3) base4.setVisible(true);
      else if (mistakes ==4) base5.setVisible(true);
      else if (mistakes ==5) base6.setVisible(true);
      else if (mistakes ==6)
      {
        base7.setVisible(true);
        winStatus.setText("You Lose!");
        realWord.setText("The actual word was " + myWord);
        buttons.setDisable(true);
      }
    }
  }
  @FXML
  public void newGame(){
    for(int i=0; i<26; i++){
      buttons.getChildrenUnmodifiable().get(i).setDisable(false);
    }
    initialize();
  }
  @FXML
  private AnchorPane hangman_bg;
  public void FadeEffect3(AnchorPane node) {
    FadeTransition fade = new FadeTransition();
    fade.setNode(node);
    fade.setDuration(Duration.millis(1000));
    fade.setFromValue(0);
    fade.setToValue(1);
    fade.play();
  }

}