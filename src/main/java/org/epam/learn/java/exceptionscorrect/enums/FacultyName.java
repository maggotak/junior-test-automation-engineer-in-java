package org.epam.learn.java.exceptionscorrect.enums;

public enum FacultyName {
    FACULTY_ONE("First-faculty"), FACULTY_TWO("Second-faculty"), FACULTY_THREE("Third-faculty");
    private final String facultyName;

    FacultyName(String name) {
        facultyName = name;
    }

    @Override
    public String toString() {
        return facultyName;
    }
}
