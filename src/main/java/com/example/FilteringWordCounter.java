package com.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class FilteringWordCounter implements WordCounter {

    private List<WordFilter> filters = new ArrayList<>();

    public FilteringWordCounter(WordFilter... filter) {
        filters = Arrays.asList(filter);
    }

    @Override
    public int count(String text) {
        Collection<String> recognizedWords = new WordRecognition().recognizeWords(text);
        for (WordFilter filter : filters) {
            recognizedWords = filter.filter(recognizedWords);
        }
        return recognizedWords.size();
    }
    
}
