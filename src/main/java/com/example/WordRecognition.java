package com.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class WordRecognition {

    private List<WordFilter> filters = new ArrayList<>();
    
    public Collection<String> recognizeWords(String text) {
        Collection<String> words = Arrays.asList(text.split(" ")); 
        for (WordFilter filter : filters) {
            words = filter.filter(words);
        }
        return words;
    }

    public WordRecognition withFilter(WordFilter filter) {
        if(filter != null){
            this.filters.add(filter);
        }
        return this;
    }
}
