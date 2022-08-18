package com.example;

import java.util.Objects;

public class WordCountResult {

    private String message;
    private int wordCount;

    public WordCountResult(String message, int wordCount) {
        this.message = message;
        this.wordCount = wordCount;
    }

    String getResult() {
        return String.format("%s: %s", message, wordCount);
    }


    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof WordCountResult)) {
            return false;
        }
        WordCountResult wordCountResult = (WordCountResult) o;
        return Objects.equals(message, wordCountResult.message) && wordCount == wordCountResult.wordCount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(message, wordCount);
    }

}
