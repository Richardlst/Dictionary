package com.example.demodictionary;

import javafx.animation.FadeTransition;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.awt.event.ActionListener;
import java.io.IOException;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import javax.swing.Timer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

public class Millionaire {
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
  String[] questions = 	{
      "Which company created Java?",
      "Which year was Java created?",
      "What was Java originally called?",
      "Who is credited with creating Java?"
  };
  String[][] options = 	{
      {"Sun Microsystems","Starbucks","Microsoft","Alphabet"},
      {"1989","1996","1972","1492"},
      {"Apple","Latte","Oak","Koffing"},
      {"Steve Jobs","Bill Gates","James Gosling","Mark Zuckerburg"}
  };
  char[] answers = 		{
      'A',
      'B',
      'C',
      'C'
  };
  char answer;
  int index;
  int correct_guesses =0;
  int total_questions = questions.length;
  int seconds=10;
  @FXML
  TextArea question = new TextArea();
  @FXML
  Button buttonA = new Button();
  @FXML
  Button buttonB = new Button();
  @FXML
  Button buttonC = new Button();
  @FXML
  Button buttonD = new Button();
  @FXML
  Label labelA = new Label();
  @FXML
  Label labelB = new Label();
  @FXML
  Label labelC = new Label();
  @FXML
  Label labelD = new Label();
  @FXML
  Label time_count = new Label();
  @FXML
  TextField score = new TextField();
  @FXML
  TextField ques_num = new TextField();
  @FXML
  private AnchorPane millionaire_bg;

  Timer timer = new Timer(1000, new ActionListener() {
    @Override
    public void actionPerformed(java.awt.event.ActionEvent e) {
      seconds--;
      time_count.setText(String.valueOf(seconds));
      if(seconds<=0) {
        displayAnswer();
      }
    }
  });

  public void Quiz() {
    time_count.setText(String.valueOf(seconds));
    score.setEditable(false);
    nextQuestion();
  }
  public void nextQuestion() {

    if(index>=total_questions) {
      results();
    }
    else {
      ques_num.setText("Question "+(index+1));
      question.setText(questions[index]);
      labelA.setText(options[index][0]);
      labelB.setText(options[index][1]);
      labelC.setText(options[index][2]);
      labelD.setText(options[index][3]);
      timer.start();
    }
  }
  public void actionPerformed(ActionEvent e) {

    buttonA.setDisable(true);
    buttonB.setDisable(true);
    buttonC.setDisable(true);
    buttonD.setDisable(true);

    if(e.getSource()==buttonA) {
      answer= 'A';
      if(answer == answers[index]) {
        correct_guesses++;
      }
    }
    if(e.getSource()==buttonB) {
      answer= 'B';
      if(answer == answers[index]) {
        correct_guesses++;
      }
    }
    if(e.getSource()==buttonC) {
      answer= 'C';
      if(answer == answers[index]) {
        correct_guesses++;
      }
    }
    if(e.getSource()==buttonD) {
      answer= 'D';
      if(answer == answers[index]) {
        correct_guesses++;
      }
    }
    displayAnswer();
  }
  public void displayAnswer() {

    timer.stop();

    buttonA.setDisable(true);
    buttonB.setDisable(true);
    buttonC.setDisable(true);
    buttonD.setDisable(true);

    if(answers[index] != 'A')
      labelA.setTextFill(javafx.scene.paint.Color.web("#ff1313"));
    if(answers[index] != 'B')
      labelB.setTextFill(javafx.scene.paint.Color.web("#ff1313"));
    if(answers[index] != 'C')
      labelC.setTextFill(javafx.scene.paint.Color.web("#ff1313"));
    if(answers[index] != 'D')
      labelD.setTextFill(javafx.scene.paint.Color.web("#ff1313"));

    Timer pause = new Timer(2000, new ActionListener() {

      @Override
      public void actionPerformed(java.awt.event.ActionEvent e) {
        labelA.setTextFill(javafx.scene.paint.Color.web("#36bc3d"));
        labelB.setTextFill(javafx.scene.paint.Color.web("#36bc3d"));
        labelC.setTextFill(javafx.scene.paint.Color.web("#36bc3d"));
        labelD.setTextFill(javafx.scene.paint.Color.web("#36bc3d"));

        answer = ' ';
        seconds=10;
        time_count.setText(String.valueOf(seconds));
        buttonA.setDisable(false);
        buttonB.setDisable(false);
        buttonC.setDisable(false);
        buttonD.setDisable(false);
        index++;
        nextQuestion();
      }
    });
    pause.setRepeats(false);
    pause.start();
  }
  public void results(){

    buttonA.setDisable(true);
    buttonB.setDisable(true);
    buttonC.setDisable(true);
    buttonD.setDisable(true);

    ques_num.setText("COMPLETE!");
    question.setText("");
    labelA.setText("");
    labelB.setText("");
    labelC.setText("");
    labelD.setText("");

    score.setText("("+correct_guesses+"/"+total_questions+")");
  }
  @FXML
  public void initialize() {
    score.setText("0");
    ques_num.setText("Question 1");
    FadeEffect3(millionaire_bg);
    Quiz();
  }
  public void FadeEffect3(AnchorPane node) {
    FadeTransition fade = new FadeTransition();
    fade.setNode(node);
    fade.setDuration(Duration.millis(1000.0));
    fade.setFromValue(0.0);
    fade.setToValue(1.0);
    fade.play();
  }
}
