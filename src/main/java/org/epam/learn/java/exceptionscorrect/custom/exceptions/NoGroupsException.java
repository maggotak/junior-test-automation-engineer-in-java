package org.epam.learn.java.exceptionscorrect.custom.exceptions;

public class NoGroupsException extends Exception{
    public NoGroupsException() {
    }

    public NoGroupsException(String message) {
        super(message);
    }

    public NoGroupsException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoGroupsException(Throwable cause) {
        super(cause);
    }
}
