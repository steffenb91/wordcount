package com.example;

import java.util.Collection;
import java.util.stream.Collectors;

public class StopwordFilter implements WordFilter {

    private Collection<String> stopWords;

    public StopwordFilter(Collection<String> stopWords) {
        this.stopWords = stopWords;
    }

    public Collection<String> filter(Collection<String> input) {
        return input.stream().filter(word -> !stopWords.contains(word)).collect(Collectors.toList());
    }

}
