package org.example;

import java.sql.SQLException;
import java.util.ArrayList;

public class Account {
    private String fullName;
    private String passWord;

    public Account(String fullName, String passWord) {
        this.fullName = fullName;
        this.passWord = passWord;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    static VocabDictionary my_dictionary = new VocabDictionary();

  /**
   * number of the words in the your vocab.
   */
  public static int count_vocab()  {
      return VocabDictionary.getCount_vocab();
    }

  /**
   * show all words in your vocab.
   */
  public static void show_vocab() throws SQLException {
      my_dictionary.initialize();
      ArrayList<Word> m = my_dictionary.getWordList();
      for (int i = 0 ; i < m.size(); i++) {
        System.out.println(m.get(i).getWord_target() + ": " + m.get(i).getWord_explain());
      }
    }

}
