package org.epam.learn.java.classes;

public enum Course {
    FIRST("First course"), SECOND("Second course"), THIRD("Third course");
    private final String course;
    Course(String course) {
        this.course = course;
    }

    public String getCourse() {
        return course;
    }
}
