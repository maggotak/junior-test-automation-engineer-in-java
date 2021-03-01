package org.epam.learn.java.exceptions;


import java.util.Map;

public class Student {
    {
        idGenerator++;
    }
    private static int idGenerator = 0;
    private final int id;
    private final String name;
    private final Faculty faculty;
    private Group group;
    private Map<Subject, Integer> subjectsAndMarks;

    public Student(String name, Faculty faculty, Group group, Map<Subject, Integer> subjectsAndMarks) {
        this.id = idGenerator;
        this.name = name;
        this.faculty = faculty;
        this.group = group;
        this.subjectsAndMarks = subjectsAndMarks;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public Group getGroup() {
        return group;
    }

    public Map<Subject, Integer> getSubjectsAndMarks() {
        return subjectsAndMarks;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public void setSubjectsAndMarks(Map<Subject, Integer> subjectsAndMarks) {
        this.subjectsAndMarks = subjectsAndMarks;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", faculty=" + faculty.getFaculty() +
                ", group=" + group.getGroup() +
                ", subjectsAndMarks=" + subjectsAndMarks +
                '}';
    }
}
