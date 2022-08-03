package com.example;

public class GetUserInputFailedException extends Exception {

    public GetUserInputFailedException(String message, Throwable reason) {
        super(String.format("%s, because: %s", message, reason.getMessage()), reason);
    }
}
