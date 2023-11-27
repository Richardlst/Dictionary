package com.example.demodictionary;

import java.sql.SQLException;
import java.util.ArrayList;

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
     * Get all English words.
     */
    public abstract ArrayList<String> getWordTargetList();

    /**
     * Lookup the target_word and return the definition.
     */
    public abstract String dictionaryLookup(String target);
}
