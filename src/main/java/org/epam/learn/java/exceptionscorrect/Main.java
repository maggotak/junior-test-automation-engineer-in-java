package org.epam.learn.java.exceptionscorrect;

import org.epam.learn.java.exceptionscorrect.custom.exceptions.*;
import org.epam.learn.java.exceptionscorrect.enums.FacultyName;
import org.epam.learn.java.exceptionscorrect.enums.GroupName;
import org.epam.learn.java.exceptionscorrect.enums.Subject;


public class Main {
    public static void main(String[] args) {
        Student student1 =  new Student("Ivanov Ivan", SubjectAndMarksGenerator.generateSubjectsAndMarks());
        Student student2 =  new Student("Petrov Petr", SubjectAndMarksGenerator.generateSubjectsAndMarks());
        Student student3 =  new Student("Sokolov Vasiliy", SubjectAndMarksGenerator.generateSubjectsAndMarks());
        Student student4 =  new Student("Petrov Dmitriy", SubjectAndMarksGenerator.generateSubjectsAndMarks());
        Student student5 =  new Student("Ivanov Ivan", SubjectAndMarksGenerator.generateSubjectsAndMarks());

        Faculty facultyOne = new Faculty(FacultyName.FACULTY_ONE);
        Faculty facultyTwo = new Faculty(FacultyName.FACULTY_TWO);

        University university = new University("Our University");
        university.addFaculty(facultyOne);
        university.addFaculty(facultyTwo);

        Group groupOne = new Group(GroupName.GROUP_ONE);
        Group groupTwo = new Group(GroupName.GROUP_TWO);
        groupOne.addStudent(student1);
        groupOne.addStudent(student2);
        groupOne.addStudent(student3);
        groupTwo.addStudent(student4);
        groupTwo.addStudent(student5);

        facultyOne.addGroup(groupOne);
        facultyOne.addGroup(groupTwo);

        System.out.println(university);


        try {
            double averageMark = student1.getAverageMarkByAllSubjects();
            System.out.println("Average mark by all subjects by student " + student1 + " is: " + averageMark);
        } catch (IllegalMarkException | NoSubjectException e) {
            e.printStackTrace();
        }


        try {
            double averageMark = university.getFaculty(FacultyName.FACULTY_ONE)
                    .getGroup(GroupName.GROUP_ONE)
                    .getAverageMarkBySubject(Subject.SUBJECT_ONE);
            System.out.println("Average mark by faculty=" + FacultyName.FACULTY_ONE
                    + " , group=" + GroupName.GROUP_ONE
                    + ", subject=" + Subject.SUBJECT_ONE
                    + " is " + averageMark);

        } catch (NoGroupsException | NoFacultyException | NoSubjectException | NoStudentException e) {
            e.printStackTrace();
        }


        try {
            double averageMark = university.getAverageMarkBySubject(Subject.SUBJECT_ONE);
            System.out.println("Average mark by subject " + Subject.SUBJECT_ONE + " in all university is: " + averageMark);
        } catch (NoSubjectException | NoFacultyException e) {
            e.printStackTrace();
        }

    }
}
