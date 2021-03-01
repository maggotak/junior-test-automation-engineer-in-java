package org.epam.learn.java.exceptions.custom.exceptions;

public class AbsentFaculties extends Exception {
    public AbsentFaculties() {
    }

    public AbsentFaculties(String message) {
        super(message);
    }

    public AbsentFaculties(String message, Throwable cause) {
        super(message, cause);
    }

    public AbsentFaculties(Throwable cause) {
        super(cause);
    }
}
