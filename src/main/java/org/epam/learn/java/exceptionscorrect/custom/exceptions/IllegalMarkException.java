package org.epam.learn.java.exceptionscorrect.custom.exceptions;

public class IllegalMarkException extends Exception{
    public IllegalMarkException() {
    }

    public IllegalMarkException(String message) {
        super(message);
    }

    public IllegalMarkException(String message, Throwable cause) {
        super(message, cause);
    }

    public IllegalMarkException(Throwable cause) {
        super(cause);
    }
}
