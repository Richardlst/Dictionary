package org.example;

import java.sql.*;
import java.util.ArrayList;

public class DatabaseDictionary extends org.example.Dictionary {
    private static final String HOST_NAME = "127.0.0.1";
    private static final String DB_NAME = "en_vi_dictionary";
    private static final String USER_NAME = "root";
    private static final String PASSWORD = "damkien404003";
    private static final String PORT = "3307";
    private static final String MYSQL_URL =
            "jdbc:mysql://" + HOST_NAME + ":" + PORT + "/" + DB_NAME;

    private static Connection connection = null;

    /**
     * Close connection to MYSQL database.
     */
    private static void close(Connection connection) {
        try {
            if (connection != null) {
                connection.close();
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
        connection = DriverManager.getConnection(MYSQL_URL, USER_NAME, PASSWORD);
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
        for (String word : targets) {
            //Trie.insert(word);
        }
    }

    /**
     * Close the Database connection.
     */
    @Override
    public void close() {
        close(connection);
        System.out.println("Database disconnected!");
    }

    /**
     * Lookup an English word `target` in database (look for the exact word `target`).
     */
    @Override
    public String dictionaryLookup(final String target) {
        final String SQL_QUERY = "SELECT definition FROM dictionary WHERE target = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(SQL_QUERY);
            ps.setString(1, target);
            try {
                ResultSet rs = ps.executeQuery();
                try {
                    if (rs.next()) {
                        return rs.getString("definition");
                    } else {
                        return "Word not found in the dictionary.";
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
        return "Word not found in the dictionary.";
    }

    /**
     * Get all words from result set of the given SQL query.
     */
    private ArrayList<Word> getWordsFromResultSet(PreparedStatement ps) throws SQLException {
        try {
            ResultSet rs = ps.executeQuery();
            try {
                ArrayList<Word> words = new ArrayList<>();
                while (rs.next()) {
                    words.add(new Word(rs.getString(2), rs.getString(3)));
                }
                return words;

            } finally {
                close(rs);
            }
        } finally {
            close(ps);
        }
    }

    /**
     * Get all words into an `ArrayList(Word)>`.
     */
    @Override
    public ArrayList<Word> getWordList() {
        final String SQL_QUERY = "SELECT * FROM dictionary";
        try {
            PreparedStatement ps = connection.prepareStatement(SQL_QUERY);
            return getWordsFromResultSet(ps);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    /**
     * Get all words target from the database (only target, non include the definition).
     */
    public ArrayList<String> getWordTargetList() {
        final String SQL_QUERY = "SELECT * FROM dictionary";
        try {
            PreparedStatement ps = connection.prepareStatement(SQL_QUERY);
            try {
                ResultSet rs = ps.executeQuery();
                try {
                    ArrayList<String> targets = new ArrayList<>();
                    while (rs.next()) {
                        targets.add(rs.getString(2));
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



    /**
     * Add new word to database.
     */
    public boolean addWord(final String target, final String definition) {
        final String SQL_QUERY = "INSERT INTO en_vi_dictionary.dictionary (target, definition) VALUES (?, ?)";
        try {
            PreparedStatement ps = connection.prepareStatement(SQL_QUERY);
            ps.setString(1, target);
            ps.setString(2, definition);
            try {
                ps.executeUpdate();
            } catch (SQLIntegrityConstraintViolationException e) {
                // `word` is already in database
                return false;
            } finally {
                close(ps);
            }
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Delete the word `target` from the database.
     */
    public boolean deleteWord(final String target) {
        final String SQL_QUERY = "DELETE FROM dictionary WHERE target = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(SQL_QUERY);
            ps.setString(1, target);
            try {
                int deletedRows = ps.executeUpdate();
                if (deletedRows == 0) {
                    return false;
                }
            } finally {
                close(ps);
            }
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Edit the word `target` to the according definition.
     */
    public boolean editWord(final String target, final String definition) {
        final String SQL_QUERY = "UPDATE dictionary SET definition = ? WHERE target = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(SQL_QUERY);
            ps.setString(1, definition);
            ps.setString(2, target);
            try {
                int updatedRows = ps.executeUpdate();
                if (updatedRows == 0) {
                    return false;
                }
            } finally {
                close(ps);
            }
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}