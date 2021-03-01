package org.epam.learn.java.exceptions.custom.exceptions;

public class AbsentGroups extends Exception {
    public AbsentGroups() {
    }

    public AbsentGroups(String message) {
        super(message);
    }

    public AbsentGroups(String message, Throwable cause) {
        super(message, cause);
    }

    public AbsentGroups(Throwable cause) {
        super(cause);
    }
}
