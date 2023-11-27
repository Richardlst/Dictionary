package com.example.demodictionary;

import java.sql.*;
import java.util.ArrayList;

public class VocabDictionary extends Dictionary {
  private static final String MYSQL_URL =
      "jdbc:mysql://localhost:3307/vocab_dictionary";
  private static final String USER_NAME = "root";
  private static final String PASSWORD = "toan260312a1qh1";

    private static Connection connectVocab = null;

    private static int count_vocab;

    /**
     * get the number of vocabulary.
     */
    public static int getCount_vocab() {
        return count_vocab;
    }

    /**
     * Close connection to MYSQL database.
     */
    private static void close(Connection connectVocab) {
        try {
            if (connectVocab != null) {
                connectVocab.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Close the PreparedStatement ps.
     */
    private static void close(PreparedStatement ps) {
        try {
            if (ps != null) {
                ps.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Close the ResultSet rs.
     */
    private static void close(ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Connect to MYSQL database.
     */
    private void connectToDatabase() throws SQLException {
        System.out.println("Connecting to database...");
        connectVocab = DriverManager.getConnection(MYSQL_URL, USER_NAME, PASSWORD);
        System.out.println("Database connected!\n");
    }

    /**
     * Connect to MYSQL database.
     * Add all English words on the database into wordList.
     */
    @Override
    public void initialize() throws SQLException {
        connectToDatabase();
        ArrayList<String> targets = getWordTargetList();
        count_vocab = targets.size();
    }

    /**
     * Close the Database connection.
     */
    @Override
    public void close() {
        close(connectVocab);
        System.out.println("Database disconnected!");
    }

    /**
     * Lookup an English word `target` in database.
     */
    @Override
    public String dictionaryLookup(final String target) {
        final String SQL_QUERY = "SELECT definition FROM vocab_dictionary WHERE target = ?";
        try {
            PreparedStatement ps = connectVocab.prepareStatement(SQL_QUERY);
            ps.setString(1, target);
            try {
                ResultSet rs = ps.executeQuery();
                try {
                    if (rs.next()) {
                        return "This word already exists in your vocab";
                    } else {
                        return "Word not found in the your vocab.";
                    }
                } finally {
                    close(rs);
                }
            } finally {
                close(ps);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "Word not found in the your vocab.";
    }

    /**
     * Add new word to database.
     */
    public boolean addWord(final String target) {
        final String SQL_QUERY = "INSERT INTO vocab_dictionary.your_vocabulary (target) VALUES (?)";
        try {
            PreparedStatement ps = connectVocab.prepareStatement(SQL_QUERY);
            ps.setString(1, target);
            try {
                ps.executeUpdate();
            } catch (SQLIntegrityConstraintViolationException e) {
                // `word` is already in database
                return false;
            } finally {
                close(ps);
            }
            count_vocab++;
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Get all words target from the database.
     */
    public ArrayList<String> getWordTargetList() {
        final String SQL_QUERY = "SELECT target FROM your_vocabulary";
        try {
            PreparedStatement ps = connectVocab.prepareStatement(SQL_QUERY);
            try {
                ResultSet rs = ps.executeQuery();
                try {
                    ArrayList<String> targets = new ArrayList<>();
                    while (rs.next()) {
                        targets.add(rs.getString("target"));
                    }
                    return targets;

                } finally {
                    close(rs);
                }
            } finally {
                close(ps);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }
}
