package com.example.demodictionary;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class Trie {
    private static final ArrayList<String> searchedWords = new ArrayList<>();
    private static final TrieNode root = new TrieNode();

    /**
     * get SearchWords.
     */
    public static ArrayList<String> getSearchedWords() {
        return searchedWords;
    }

    /**
     *  Add target_word into Trie.
     */
    public static void addWord(String target) {
        int length = target.length();
        TrieNode cur = root;
        for (int i = 0; i < length; i++) {
            char gChar = target.charAt(i);
            if (cur.child.get(gChar) == null) {
                cur.child.put(gChar, new TrieNode());
            }
            cur = cur.child.get(gChar);
        }
        cur.endOfWord = true;
    }

    /**
     * Get all words ended in the subtree of node 'cur'.
     */
    private static void dfsGetWordsSubtree(TrieNode cur, String target) {
        if (cur.endOfWord) {
            searchedWords.add(target);
        }
        for (char gChar : cur.child.keySet()) {
            if (cur.child.get(gChar) != null) {
                dfsGetWordsSubtree(cur.child.get(gChar), target + gChar);
            }
        }
    }

    /**
     * Search all words start with `prefix` in the Trie.
     */
    public static ArrayList<String> dictionarySearched(String prefix) {
        if (prefix.isEmpty()) {
            return new ArrayList<>();
        }
        prefix = prefix.toLowerCase();
        searchedWords.clear();
        int length = prefix.length();
        TrieNode cur = root;
        for (int i = 0; i < length; i++) {
            char gChar = prefix.charAt(i);
            if (cur.child.get(gChar) == null) {
                return getSearchedWords();
            }
            cur = cur.child.get(gChar);
        }
        dfsGetWordsSubtree(cur, prefix);
        return getSearchedWords();
    }

    /**
     * Delete the word from Trie.
     */
    public static void deleteWord(String target) {
        int length = target.length();
        TrieNode cur = root;
        for (int i = 0; i < length; i++) {
            char gChar = target.charAt(i);
            if (cur.child.get(gChar) == null) {
                System.out.println("This word has not been inserted");
                return;
            }
            cur = cur.child.get(gChar);
        }
        if (!cur.endOfWord) {
            System.out.println("This word has not been inserted");
            return;
        }
        cur.endOfWord = false;
    }

    /**
     * a Node on the Trie.
     */
    public static class TrieNode {
        Map<Character, TrieNode> child = new TreeMap<>();
        /* endOfWord is true if the node represents the end of a word */
        boolean endOfWord;

        TrieNode() {
            endOfWord = false;
        }
    }
}