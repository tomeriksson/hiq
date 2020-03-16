package com.wordApp.App;

public class InvalidTextException extends RuntimeException {
    InvalidTextException() {
            super("Could not parse text");
        }
    }

