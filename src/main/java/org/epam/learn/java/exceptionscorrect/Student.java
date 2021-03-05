package org.epam.learn.java.exceptionscorrect;

import org.epam.learn.java.exceptionscorrect.custom.exceptions.IllegalMarkException;
import org.epam.learn.java.exceptionscorrect.custom.exceptions.NoSubjectException;
import org.epam.learn.java.exceptionscorrect.enums.Subject;

import java.util.Map;

public class Student {

    {
        idGenerator++;
    }
    private static int idGenerator = 0;
    private final int id;
    private final String name;
    private final Map<Subject, Integer> subjectsAndMarks;

    public Student(String name, Map<Subject, Integer> subjectsAndMarks) {
        this.id = idGenerator;
        this.name = name;
        this.subjectsAndMarks = subjectsAndMarks;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Map<Subject, Integer> getSubjectsAndMarks() {
        return subjectsAndMarks;
    }

    public double getAverageMarkByAllSubjects() throws IllegalMarkException, NoSubjectException {
        if (subjectsAndMarks.isEmpty()) {
            throw new NoSubjectException("No subjects found at student " + name);
        }
        int sum = 0;
        for (int mark : subjectsAndMarks.values()) {
            if (mark < 0 || mark > 10) {
                throw new IllegalMarkException("Marks should be more than 0 and less than 10");
            }
            sum += mark;
        }
        return (double) sum / subjectsAndMarks.size();
    }

    public int getMarkBySubject(Subject subject) throws NoSubjectException, IllegalMarkException {
        if (subjectsAndMarks.isEmpty()) {
            throw new NoSubjectException("No subjects found at student " + name);
        }

        for(Subject subjectOfStudent : subjectsAndMarks.keySet()) {
            if (subjectOfStudent == subject) {
                int mark = subjectsAndMarks.get(subject);
                if (mark < 0 || mark > 10) {
                    throw new IllegalMarkException("Marks should be more than 0 and less than 10");
                }
                return mark;
            }
        }
        throw new NoSubjectException("No subject " + subject + " found at student " + name);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", subjectsAndMarks=" + subjectsAndMarks +
                '}';
    }
}
