package org.example;

public class Word {
    private String word_target;
    private String word_explain;

    /**
     * Constructor new word.
     */
    public Word(String target, String explain) {
        word_target = target;
        word_explain = explain;
    }

    /**
     * Get the English word.
     */
    public String getWord_target() {
        return word_target;
    }

    /**
     * Set the English word.
     */
    public void setWord_target(String word_target) {
        this.word_target = word_target;
    }

    /**
     * Get the Vietnamese word.
     */
    public String getWord_explain() {
        return word_explain;
    }

    /**
     * Set the Vietnamese word.
     */
    public void setWord_explain(String word_explain) {
        this.word_explain = word_explain;
    }
}
