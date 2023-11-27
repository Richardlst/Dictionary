package com.example.demodictionary;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class UsedTime {
  private long usedTime;

  public final static String filePath = "E:\\OOP (thuc hanh)\\untitled4\\src\\UsedTime.txt";

  private long startTime;

  /**
   * get start time using app.
   * get before time using the app.
   */
  public void startApp() {
    startTime = System.currentTimeMillis();
    usedTime = getUsedTime();
  }

  /**
   *  Count app usage time and save to file.
   */
  public void stopApp() {
    long endTime = System.currentTimeMillis();
    long nowUsedTime = endTime - startTime;
    usedTime += nowUsedTime;
    saveUsedTime(usedTime);
  }

  /**
   * get before time using the app from file.
   */
  public long getUsedTime() {
    try {
      File file = new File(filePath);
      Scanner scanner = new Scanner(file);
      while (scanner.hasNextLong()) {
        long beforeTime = scanner.nextLong();
        return beforeTime;
      }
      scanner.close();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    return 0;
  }

  /**
   * save time using the app to file.
   */
  public void saveUsedTime(long m) {
    try (FileWriter writer = new FileWriter(filePath, false)) {
      writer.write(String.valueOf(m));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
