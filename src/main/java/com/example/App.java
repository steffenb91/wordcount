package com.example;

import java.io.File;
import java.util.List;

public class App {

    public static void main(String[] args) throws GetUserInputFailedException {
        InputHandler inputHandler = args.length == 0 ? new CommandlineInputHandler()
                : new TextfileInputHandler(new File(args[0]));
        Messenger messenger = new ConsoleMessenger();

        WordCounter wordCounter = null;
        WordFilter stopWordFilter = null;
        WordRecognition wordRecognition = null;
        try {
            stopWordFilter = getStopwordFilter();
            wordRecognition = new WordRecognition().withFilter(stopWordFilter);
            wordCounter = new ObservableWordCounter(wordRecognition, new UniqueWordCounter(),
                    new AverageWordLengthCalculator());
        } catch (StopWordListReadFailedException e) {
            System.out.println("Failed to read stopword list, continuing without stopword list...");
            wordRecognition = new WordRecognition();
            wordCounter = new ObservableWordCounter(wordRecognition, new UniqueWordCounter(),
                    new AverageWordLengthCalculator());
        }
        WordCounterApp wordCounterApp = new WordCounterApp(inputHandler, messenger, wordCounter);
        wordCounterApp.run();
        List<String> inputArguments = List.of(args);
        if(inputArguments.contains("-index")){
            new IndexPrinter(wordRecognition, messenger).printIndex(inputHandler.getUserInput());
        }
        
    }

    private static WordFilter getStopwordFilter()
            throws StopWordListReadFailedException {
        File stopwordList = new File("src/main/resources/stopwords.txt");
        StopWordReader stopWordReader = new TextfileStopWordReader(stopwordList);
        return new StopwordFilter(stopWordReader.getStopwords());
    }
}
