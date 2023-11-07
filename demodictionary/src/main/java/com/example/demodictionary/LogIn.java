package com.example.demodictionary;

import java.awt.event.ActionEvent;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
public class LogIn {

  @FXML
  private Button login;

  @FXML
  private PasswordField password;

  @FXML
  private TextField username;

  @FXML
  private Label wrongLogin;
  public void userLogIn(javafx.event.ActionEvent event) throws IOException {
    checkLogin();

  }

  private void checkLogin() throws IOException {
    HelloApplication m = new HelloApplication();
    if(username.getText().toString().equals("a") && password.getText().toString().equals("a")) {
      wrongLogin.setText("Success login!");

      m.changeScene("afterLogin.fxml");
    }

    else if(username.getText().isEmpty() && password.getText().isEmpty()) {
      wrongLogin.setText("Please enter your data.");
    }


    else {
      wrongLogin.setText("Wrong username or password!");
    }
  }
}

