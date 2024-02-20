package com.example.mvp_test.ex;

public class ParsingException extends RuntimeException {

    private ParsingException(String message) {
        super(message);
    }

    public static ParsingException unableToReadException() {
        return new ParsingException("Unable to read the file. MVP won’t be calculated. Please check file format and content correctness!");
    }
}
