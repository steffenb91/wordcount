package com.example;

import java.util.Arrays;
import java.util.Collection;

public class WordRecognition {
    
    public Collection<String> recognizeWords(String text) {
        return Arrays.asList(text.split(" "));
    }
}
