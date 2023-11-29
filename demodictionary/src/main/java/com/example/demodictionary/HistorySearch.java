package com.example.demodictionary;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class HistorySearch {
  private final String filePath = "E:\\OOP (BTL)\\BTL\\src\\main\\java\\org\\example\\history.txt";
  private static List<String> searchHistory;

  public HistorySearch() {
    searchHistory = new ArrayList<>();
  }

  /**
   * import from File.
   */
  public void importFromFile() {
    try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
      String line;
      while ((line = reader.readLine()) != null) {
        searchHistory.add(line);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * add to history.
   */
  public void addToHistory(String search) {
    if (searchHistory.contains(search)) {
      searchHistory.remove(search);
    }
    searchHistory.add(search);
  }

  public List<String> getSearchHistory() {
    return searchHistory;
  }

  /**
   * show HistorySearch.
   */
  public void showHistory() {
    int m = searchHistory.size();
    for (int i = m - 1 ; i >= 0; i--) {
      System.out.println(searchHistory.get(i));
    }
  }

  /**
   * Export search history to file.
   */
  public void exportToFile() {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
      for (String search : searchHistory) {
        writer.write(search);
        writer.newLine();
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}

