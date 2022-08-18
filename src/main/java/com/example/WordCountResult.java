package com.example;

import java.util.Objects;

public class WordCountResult {

    private String message;
    private double result;

    public WordCountResult(String message, double result) {
        this.message = message;
        this.result = result;
    }

    String getResult() {
        return String.format("%s: %s", message, result);
    }


    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof WordCountResult)) {
            return false;
        }
        WordCountResult wordCountResult = (WordCountResult) o;
        return Objects.equals(message, wordCountResult.message) && result == wordCountResult.result;
    }

    @Override
    public int hashCode() {
        return Objects.hash(message, result);
    }

}
