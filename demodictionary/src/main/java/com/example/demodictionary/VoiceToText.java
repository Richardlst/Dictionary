package com.example.demodictionary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class VoiceToText {
  /**
   * Voice to text.
   */
  public static String Voice_Text() {
    String voiceText = "";
    try {
      String pythonInterpreter = "C:\\Users\\thinh\\AppData\\Local\\Programs\\Python\\Python311\\python.exe";
      String pythonScriptPath = "C:\\Users\\thinh\\Downloads\\Speech.py";
      String[] cmd = {pythonInterpreter, pythonScriptPath};

      System.out.println("Ready to speech");
      Process process = Runtime.getRuntime().exec(cmd);

      // Xử lý đầu ra chuẩn
      InputStreamReader standardInput = new InputStreamReader(process.getInputStream());
      BufferedReader inputReader = new BufferedReader(standardInput);

      // Xử lý đầu ra lỗi
      InputStreamReader errorInput = new InputStreamReader(process.getErrorStream());
      BufferedReader errorReader = new BufferedReader(errorInput);

      // Chờ quá trình kết thúc
      int exitCode = process.waitFor();

      // Đọc đầu ra chuẩn
      String line;
      StringBuilder output = new StringBuilder("Output:\n");
      while ((line = inputReader.readLine()) != null) {
        output.append(line).append("\n");
      }

      // Đọc đầu ra lỗi
      StringBuilder errorOutput = new StringBuilder("Error:\n");
      while ((line = errorReader.readLine()) != null) {
        errorOutput.append(line).append("\n");
      }

      if (exitCode == 0 && errorOutput.length() == 0) {
        voiceText = output.toString();
      } else {
        System.out.println("Error:\n" + errorOutput.toString());
      }

      // Đóng luồng đọc
      inputReader.close();
      errorReader.close();

    } catch (IOException | InterruptedException e) {
      e.printStackTrace();
    }
    return voiceText;
  }
}
