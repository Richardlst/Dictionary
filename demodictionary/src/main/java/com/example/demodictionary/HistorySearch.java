package com.example.demodictionary;

import java.util.ArrayList;
import java.util.List;

public class HistorySearch {
  private static List<String> searchHistory;

  public HistorySearch() {
    searchHistory = new ArrayList<>();
  }

  /**
   * add to history.
   */
  public static void addToHistory(String searchTerm) {
    searchHistory.add(searchTerm);
  }

  public static List<String> getSearchHistory() {
    return searchHistory;
  }

  /**
   * clear History.
   */
  public static void clearHistory() {
    searchHistory.clear();
  }

  /**
   * show HistorySearch.
   */
  public static void showHistory() {
    int m = searchHistory.size();
    for (int i = m - 1 ; i >= 0; i++) {
      System.out.println(searchHistory.get(i));
    }
  }
}
