package org.epam.learn.java.exceptions;

import org.epam.learn.java.exceptions.custom.exceptions.AbsentFaculties;
import org.epam.learn.java.exceptions.custom.exceptions.AbsentGroups;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class StudentsList {
    private static final List<Student> students;
    static {
        students = new ArrayList<>();
    }

    public static void addStudent(Student student) {
        students.add(student);
    }

    public static List<Student> getStudents() {
        return students;
    }

    public static double countAverageMarkByAllSubjects(Student student) {
        int sum = 0;
        Map<Subject, Integer> subjectsAndMarks = student.getSubjectsAndMarks();
        for (Integer mark : subjectsAndMarks.values()) {
            sum += mark;
        }
        return (double) sum / subjectsAndMarks.size();
    }

    public static double countAverageMarkBySubjectFacultyGroup(Subject subject, Faculty faculty, Group group) throws AbsentFaculties, AbsentGroups {
        List<Student> studentList = new ArrayList<>();
        boolean noFaculty = true;
        boolean noGroup = true;

        for (Student student : students) {
            if (student.getSubjectsAndMarks().containsKey(subject)) {
                if (student.getFaculty() == faculty) {
                    noFaculty = false;
                    if (student.getGroup() == group) {
                        noGroup = false;
                        studentList.add(student);
                    }
                }
            }
        }

        if (noFaculty) {
            throw new AbsentFaculties("No faculty");
        }
        if (noGroup) {
            throw new AbsentGroups("No group");
        }

        int sum = 0;
        for (Student student : studentList) {
            sum += student.getSubjectsAndMarks().get(subject);
        }

        return (double) sum / studentList.size();
    }

    public static double countAverageMarkBySubject(Subject subject) {
        List<Student> studentList = new ArrayList<>();
        for (Student student : students) {
            if (student.getSubjectsAndMarks().containsKey(subject)) {
                studentList.add(student);
            }
        }

        int sum = 0;
        for (Student student : studentList) {
            sum += student.getSubjectsAndMarks().get(subject);
        }

        return (double) sum / studentList.size();
    }

    public static Student getRandomStudent() {
        Random random = new Random();
        return students.get(random.nextInt(students.size()));
    }
}
