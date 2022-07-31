package com.example;

import java.io.File;

public class App {

    public static void main(String[] args) {
        InputHandler inputHandler = new CommandlineInputHandler();
        Messenger messenger = new ConsoleMessenger();

        WordCounter wordCounter = null;
        try {
            wordCounter = getWordCounterWithStopwordFilter();
        } catch (StopWordListReadFailedException e) {
            System.out.println("Failed to read stopword list, continuing without stopword list...");
            wordCounter = new TotalWordsCounter();
        }
        WordCounterApp wordCounterApp = new WordCounterApp(inputHandler, messenger, wordCounter);
        wordCounterApp.run();
    }

    private static WordCounter getWordCounterWithStopwordFilter()
            throws StopWordListReadFailedException {
        File stopwordList = new File("src/main/resources/stopwords.txt");
        StopWordReader stopWordReader = new TextfileStopWordReader(stopwordList);
        WordFilter stopWordFilter = new StopwordFilter(stopWordReader.getStopwords());
        return new FilteringWordCounter(stopWordFilter);
    }
}
