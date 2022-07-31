package com.example;

import java.util.Collection;

public class TotalWordsCounter implements WordCounter {

    @Override
    public int count(String text) {
        Collection<String> recognizedWords = new WordRecognition().recognizeWords(text);
        return recognizedWords.size();
    }
}
