package com.example;

import java.util.ArrayList;
import java.util.Collection;

public class ObservableWordCounter implements WordCounter {

    private WordCountObserver[] observers;
    private WordRecognition wordRecognition;

    public ObservableWordCounter(WordRecognition wordRecognition, WordCountObserver... observers) {
        this.wordRecognition = wordRecognition;
        this.observers = observers;
    }

    @Override
    public Collection<WordCountResult> count(String text) {
        Collection<String> words = wordRecognition.recognizeWords(text);
        Collection<WordCountResult> results = new ArrayList<>();
        results.add(new WordCountResult("Number of words", words.size()));
        notifyObservers(words, results);
        return results;
    }

    private void notifyObservers(Collection<String> words, Collection<WordCountResult> results) {
        for (WordCountObserver observer : observers) {
            results.add(observer.notify(words));
        }
    }

}
