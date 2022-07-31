package com.example;

public class ConsoleMessenger implements Messenger {

    @Override
    public void print(String message) {
        System.out.println(message);
    }

}
