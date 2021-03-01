package org.epam.learn.java.exceptions.custom.exceptions;

public class AbsentSubject extends Exception {
    public AbsentSubject() {
    }

    public AbsentSubject(String message) {
        super(message);
    }

    public AbsentSubject(String message, Throwable cause) {
        super(message, cause);
    }

    public AbsentSubject(Throwable cause) {
        super(cause);
    }
}
