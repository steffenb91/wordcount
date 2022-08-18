package com.example;

import java.util.Collection;

public interface WordCounter {

    Collection<WordCountResult> count(String text);
}
