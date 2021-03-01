package org.epam.learn.java.exceptions;

public enum Subject {
    SUBJECT_ONE("Subject one"), SUBJECT_TWO("Subject two"), SUBJECT_THREE("Subject three"),
    SUBJECT_FOUR("Subject four"), SUBJECT_FIVE("Subject five");

    private final String subjectName;
    Subject(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getSubjectName() {
        return subjectName;
    }

    @Override
    public String toString() {
        return subjectName;
    }
}
