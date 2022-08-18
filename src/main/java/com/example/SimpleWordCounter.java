package com.example;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class SimpleWordCounter implements WordCounter {

    private WordRecognition wordRecognition;

    public SimpleWordCounter(WordRecognition wordRecognition) {
        this.wordRecognition = wordRecognition;
    }

    public Collection<WordCountResult> count(String text) {
        Collection<String> recognizedWords = wordRecognition.recognizeWords(text);
        return Collections.singletonList(new WordCountResult("Number of words", recognizedWords.size()));
    }
}
