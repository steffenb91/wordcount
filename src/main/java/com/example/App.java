package com.example;

public class App {

    public static void main(String[] args) {
        InputHandler inputHandler = new CommandlineInputHandler();
        Messenger messenger = new ConsoleMessenger();
        WordCounter wordCounter = new WordCounter();;
        WordCounterApp wordCounterApp = new WordCounterApp(inputHandler, messenger, wordCounter);
        wordCounterApp.run();
    }
}
