package org.example;

import java.io.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public abstract class Dictionary {

    /**
     * Initialize the dictionary when starting the application.
     */
    public void initialize() throws SQLException {};

    /**
     * Close the dictionary when exiting the application.
     */
    public void close() {};

    /**
     * Get all words in the dictionary.
     */
    public abstract ArrayList<Word> getWordList();

    /**
     * Get all English words.
     */
    public abstract ArrayList<String> getWordTargetList();

    /**
     * Lookup the target_word and return the definition.
     */
    public abstract String dictionaryLookup(String target);

    /**
     * Add a new word to dictionary.
     */
    public abstract boolean addWord(String word, String meaning);

    /**
     *Edit explaining_words for word.
     */
    public abstract boolean editWord(String word, String newMeaning);

    /** delete the word. */
    public abstract boolean deleteWord(String word);

}
