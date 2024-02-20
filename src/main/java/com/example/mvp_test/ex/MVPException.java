package com.example.mvp_test.ex;

public class MVPException extends RuntimeException {

    private MVPException(String message) {
        super(message);
    }

    public static MVPException notFound() {
        return new MVPException("The most valuable player is impossible to find!");
    }
}
