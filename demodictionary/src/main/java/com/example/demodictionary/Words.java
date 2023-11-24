package com.example.demodictionary;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Words{

  private final ArrayList<String> words;
  private String[] letters;


  public Words() throws FileNotFoundException {
    words = new ArrayList<>();
    String filePath = "C:\\Users\\thinh\\.m2\\repository\\eu\\hansolo\\toolbox\\demodictionary\\src\\main\\resources\\Words.txt";
    Scanner sc = new Scanner(new File(filePath));
    while(sc.hasNextLine()) words.add(sc.nextLine());
  }

  public String getRandomWord(){
    return words.get(new Random().nextInt(words.size())).toUpperCase();
  }



}
