package com.example;

public class WordCounterApp {

    private InputHandler inputHandler;
    private Messenger messenger;
    private WordCounter wordCounter;

    public WordCounterApp(InputHandler inputHandler, Messenger messenger, WordCounter wordCounter) {
        this.inputHandler = inputHandler;
        this.messenger = messenger;
        this.wordCounter = wordCounter;
    }

    public void run() {
        messenger.print("Enter text: ");
        int wordCount = wordCounter.count(inputHandler.getUserInput());
        messenger.print(String.format("Number of words: %s", wordCount));
    }

}
