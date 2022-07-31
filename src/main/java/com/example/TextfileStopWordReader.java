package com.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class TextfileStopWordReader implements StopWordReader {

    private File textfileWithStopwords;

    public TextfileStopWordReader(File textfileWithStopwords) {
        this.textfileWithStopwords = textfileWithStopwords;
    }

    @Override
    public Collection<String> getStopwords() throws StopWordListReadFailedException {
        Collection<String> stopWords = new HashSet<>();
        try {
            stopWords = read();
        } catch (IOException e) {
            throw new StopWordListReadFailedException("Could not read stopword list", e);
        }
        return stopWords;
    }

    private Set<String> read() throws IOException {
        Set<String> words = new HashSet<>();

        try (BufferedReader br = new BufferedReader(new FileReader(textfileWithStopwords))) {
            String line = br.readLine();
            while (line != null) {
                words.add(line);
                line = br.readLine();
            }
        }
        return words;
    }

}
