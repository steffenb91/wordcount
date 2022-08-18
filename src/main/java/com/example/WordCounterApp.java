package com.example;

import java.util.Collection;

public class WordCounterApp {

    private InputHandler inputHandler;
    private Messenger messenger;
    private WordCounter wordCounter;

    public WordCounterApp(InputHandler inputHandler, Messenger messenger, WordCounter wordCounter) {
        this.inputHandler = inputHandler;
        this.messenger = messenger;
        this.wordCounter = wordCounter;
    }

    public void run() throws GetUserInputFailedException {
        messenger.print("Enter text: ");
        Collection<WordCountResult> wordCount = wordCounter.count(inputHandler.getUserInput());
        for (WordCountResult wordCountResult : wordCount) {
            messenger.print(wordCountResult.getResult());    
        }
        
    }

}
