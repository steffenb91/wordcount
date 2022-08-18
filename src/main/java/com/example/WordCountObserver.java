package com.example;

import java.util.Collection;

public interface WordCountObserver {

    WordCountResult notify(Collection<String> words);
}
