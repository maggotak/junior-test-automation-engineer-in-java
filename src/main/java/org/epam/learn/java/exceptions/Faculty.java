package org.epam.learn.java.exceptions;

public enum Faculty {
    FACULTY_ONE("First faculty"), FACULTY_TWO("Second faculty"), FACULTY_THREE("Third faculty");
    private final String facultyName;

    Faculty(String name) {
        facultyName = name;
    }

    public String getFaculty() {
        return facultyName;
    }
}
