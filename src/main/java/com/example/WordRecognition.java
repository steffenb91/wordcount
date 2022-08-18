package com.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class WordRecognition {

    private List<WordFilter> filters = new ArrayList<>();
    
    public Collection<String> recognizeWords(String text) {
        String sanitizedText = text.replace(".", "").replace(",", "");
        Collection<String> words = Arrays.asList(sanitizedText.split(" ")); 
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
