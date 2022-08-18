package com.example;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class UniqueWordCounter implements WordCountObserver {

    @Override
    public WordCountResult notify(Collection<String> words) {
        Set<String> uniqueWords = new HashSet<>(words);
        return new WordCountResult("Unique words", uniqueWords.size());
    }

}
