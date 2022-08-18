package com.example;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class IndexPrinter {

    private WordRecognition wordRecognition;
    private Messenger messenger;

    public IndexPrinter(WordRecognition wordRecognition, Messenger messenger) {
        this.wordRecognition = wordRecognition;
        this.messenger = messenger;
    }

    public void printIndex(String text) {
        Collection<String> input = wordRecognition.recognizeWords(text);
        List<String> copy = new ArrayList<>(input);
        copy.sort((p1, p2) -> p1.compareToIgnoreCase(p2));
        StringBuilder sb = new StringBuilder().append("Index:\n");
        copy.stream().distinct().forEach(word -> sb.append(word + "\n"));
        messenger.print(sb.toString());
    }
    
}
