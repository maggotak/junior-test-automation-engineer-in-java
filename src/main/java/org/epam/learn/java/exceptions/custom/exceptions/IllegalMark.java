package org.epam.learn.java.exceptions.custom.exceptions;

public class IllegalMark extends Exception {
    public IllegalMark() {
    }

    public IllegalMark(String message) {
        super(message);
    }

    public IllegalMark(String message, Throwable cause) {
        super(message, cause);
    }

    public IllegalMark(Throwable cause) {
        super(cause);
    }
}
