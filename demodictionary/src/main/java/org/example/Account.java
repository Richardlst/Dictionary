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

    static LocalDictionary my_dictionary = new LocalDictionary();

    public static int count_vocab() throws SQLException {
        my_dictionary.initialize();
        ArrayList<String> m = my_dictionary.getWordTargetList();
        return m.size();
    }

    public static void show_vocab() throws SQLException {
        my_dictionary.initialize();
        ArrayList<Word> m = my_dictionary.getWordList();
        for (int i = 0 ; i < m.size(); i++) {
            System.out.println(m.get(i).getWord_target() + ": " + m.get(i).getWord_explain());
        }
    }


}
