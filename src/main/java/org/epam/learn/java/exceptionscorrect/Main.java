package org.epam.learn.java.exceptionscorrect;

import org.epam.learn.java.exceptionscorrect.custom.exceptions.*;
import org.epam.learn.java.exceptionscorrect.enums.FacultyName;
import org.epam.learn.java.exceptionscorrect.enums.GroupName;
import org.epam.learn.java.exceptionscorrect.enums.Subject;


public class Main {
    public static void main(String[] args) {
        Faculty facultyOne = new Faculty(FacultyName.FACULTY_ONE);
        Faculty facultyTwo = new Faculty(FacultyName.FACULTY_TWO);

        University university = new University("Our University");
        university.addFaculty(facultyOne);
        university.addFaculty(facultyTwo);

        Group groupOne = new Group(GroupName.GROUP_ONE);
        Group groupTwo = new Group(GroupName.GROUP_TWO);


        try {
            Student student1 = new Student("Ivanov Ivan", SubjectAndMarksGenerator.generateSubjectsAndMarks());
            groupOne.addStudent(student1);
        } catch (IllegalMarkException e) {
            e.printStackTrace();
        }

        try {
            Student student2 = new Student("Petrov Petr", SubjectAndMarksGenerator.generateSubjectsAndMarks());
            groupOne.addStudent(student2);
        } catch (IllegalMarkException e) {
            e.printStackTrace();
        }
        Student student3 =  new Student("Sokolov Vasiliy");
        Student student4 =  new Student("Petrov Dmitriy");
        Student student5 =  new Student("Ivanov Ivan");

        groupOne.addStudent(student3);
        groupTwo.addStudent(student4);
        groupTwo.addStudent(student5);

        facultyOne.addGroup(groupOne);
        facultyOne.addGroup(groupTwo);


        try {
            student3.addMark(Subject.SUBJECT_ONE, 5);
        } catch (IllegalMarkException e) {
            e.printStackTrace();
        }
        try {
            student3.addMark(Subject.SUBJECT_TWO, -1);
        } catch (IllegalMarkException e) {
            e.printStackTrace();
        }
        try {
            student4.addMark(Subject.SUBJECT_ONE, 5);
        } catch (IllegalMarkException illegalMark) {
            illegalMark.printStackTrace();
        }
        try {
            student4.addMark(Subject.SUBJECT_TWO, 6);
        } catch (IllegalMarkException e) {
            e.printStackTrace();
        }
        try {
            student4.addMark(Subject.SUBJECT_THREE, 9);
        } catch (IllegalMarkException e) {
            e.printStackTrace();
        }
        try {
            student5.addMark(Subject.SUBJECT_ONE, 10);
        } catch (IllegalMarkException e) {
            e.printStackTrace();
        }

        System.out.println(university);

        try {
            double averageMark = student3.getAverageMarkByAllSubjects();
            System.out.printf("Average mark by all subjects by student %s is: %.1f%n",student3.getName(), averageMark);
        } catch (IllegalMarkException | NoSubjectException e) {
            e.printStackTrace();
        }


        try {
            double averageMark = university.getFaculty(FacultyName.FACULTY_ONE)
                    .getGroup(GroupName.GROUP_ONE)
                    .getAverageMarkBySubject(Subject.SUBJECT_ONE);
            System.out.printf("Average mark by faculty=%s, group=%s, subject=%s is: %.1f%n",
                    FacultyName.FACULTY_ONE, GroupName.GROUP_ONE, Subject.SUBJECT_ONE, averageMark);

        } catch (NoGroupsException | NoFacultyException | NoSubjectException | NoStudentException e) {
            e.printStackTrace();
        }


        try {
            double averageMark = university.getAverageMarkBySubject(Subject.SUBJECT_ONE);
            System.out.printf("Average mark by subject %s in all university is: %.1f%n", Subject.SUBJECT_ONE, averageMark);
        } catch (NoSubjectException | NoFacultyException e) {
            e.printStackTrace();
        }

    }
}
