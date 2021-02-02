package org.epam.learn.java.classes;

public enum Faculty {
    FACULTY_ONE("First faculty"), FACULTY_TWO("Second faculty"), FACULTY_THREE("Third faculty");
    private final String faculty;
    Faculty(String faculty) {
        this.faculty = faculty;
    }

    public String getFaculty() {
        return faculty;
    }
}
