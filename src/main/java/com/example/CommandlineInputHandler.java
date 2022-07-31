package com.example;

import java.util.Scanner;

public class CommandlineInputHandler implements InputHandler {

    @Override
    public String getUserInput() {
        Scanner scanner = new Scanner(System.in);
        String nextLine = scanner.nextLine();
        scanner.close();
        return nextLine;
    }

}
