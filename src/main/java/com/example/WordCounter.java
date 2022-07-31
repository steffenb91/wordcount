package com.example;

public class WordCounter {

    public int count(String text) {
        String[] words = text.split(" ");
        return words.length;
    }
 
}
