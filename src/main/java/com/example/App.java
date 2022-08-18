package com.example;

import java.io.File;

public class App {

    public static void main(String[] args) throws GetUserInputFailedException {
        InputHandler inputHandler = args.length == 0 ? new CommandlineInputHandler()
                : new TextfileInputHandler(new File(args[0]));
        Messenger messenger = new ConsoleMessenger();

        WordCounter wordCounter = null;
        WordFilter stopWordFilter = null;
        try {
            stopWordFilter = getStopwordFilter();
            WordRecognition wordRecognition = new WordRecognition().withFilter(stopWordFilter);
            wordCounter = new ObservableWordCounter(wordRecognition, new UniqueWordCounter(),
                    new AverageWordLengthCalculator());
        } catch (StopWordListReadFailedException e) {
            System.out.println("Failed to read stopword list, continuing without stopword list...");
            wordCounter = new ObservableWordCounter(new WordRecognition(), new UniqueWordCounter(),
                    new AverageWordLengthCalculator());
        }
        WordCounterApp wordCounterApp = new WordCounterApp(inputHandler, messenger, wordCounter);
        wordCounterApp.run();
    }

    private static WordFilter getStopwordFilter()
            throws StopWordListReadFailedException {
        File stopwordList = new File("src/main/resources/stopwords.txt");
        StopWordReader stopWordReader = new TextfileStopWordReader(stopwordList);
        return new StopwordFilter(stopWordReader.getStopwords());
    }
}
