package com.example;

import java.util.Collection;

public class AverageWordLengthCalculator implements WordCountObserver {

    @Override
    public WordCountResult notify(Collection<String> words) {
        int wordCount = words.size();
        int totalCharacters = words.stream().mapToInt(c -> c.length()).sum();
        return new WordCountResult("average word length", totalCharacters / (double) wordCount);
    }

}
