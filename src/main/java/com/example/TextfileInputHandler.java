package com.example;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class TextfileInputHandler implements InputHandler {

    private File inputFile;

    public TextfileInputHandler(File inputFile) {
        this.inputFile = inputFile;
    }

    @Override
    public String getUserInput() throws GetUserInputFailedException {
        try {
            return Files.readString(inputFile.toPath()).replace("\n", " ");
        } catch (IOException e) {
            throw new GetUserInputFailedException("Could not get user input", e);
        }
    }
    
}
