package org.epam.learn.java.exceptions;


import org.epam.learn.java.exceptions.custom.exceptions.AbsentFaculties;
import org.epam.learn.java.exceptions.custom.exceptions.AbsentGroups;
import org.epam.learn.java.exceptions.custom.exceptions.AbsentSubject;
import org.epam.learn.java.exceptions.custom.exceptions.IllegalMark;

public class Main {
    public static void main(String[] args) {
        try {
             StudentsList.addStudent(new Student("Ivanov Ivan", Faculty.FACULTY_ONE, Group.GROUP_TWO, SubjectAndMarksGenerator.generateSubjectsAndMarks()));
        } catch (AbsentSubject | IllegalMark e) {
            e.printStackTrace();
        }
        try {
            StudentsList.addStudent(new Student("Petrov Petr", Faculty.FACULTY_TWO, Group.GROUP_TWO, SubjectAndMarksGenerator.generateSubjectsAndMarks()));
        } catch (AbsentSubject | IllegalMark e) {
            e.printStackTrace();
        }
        try {
            StudentsList.addStudent(new Student("Ivanova Maria", Faculty.FACULTY_ONE, Group.GROUP_THREE, SubjectAndMarksGenerator.generateSubjectsAndMarks()));
        } catch (AbsentSubject | IllegalMark e) {
            e.printStackTrace();
        }
        try {
            StudentsList.addStudent(new Student("Petrov Ivan", Faculty.FACULTY_TWO, Group.GROUP_ONE, SubjectAndMarksGenerator.generateSubjectsAndMarks()));
        } catch (AbsentSubject | IllegalMark e) {
            e.printStackTrace();
        }
        try {
            StudentsList.addStudent(new Student("Soboleva Ekaterina", Faculty.FACULTY_TWO, Group.GROUP_THREE, SubjectAndMarksGenerator.generateSubjectsAndMarks()));
        } catch (AbsentSubject | IllegalMark e) {
            e.printStackTrace();
        }

        for (Student student : StudentsList.getStudents()) {
            System.out.println(student);
        }

        Student student = StudentsList.getRandomStudent();

        System.out.print("Count average mark by all subjects " + student.getName() + " = ");
        System.out.printf("%.1f\n", StudentsList.countAverageMarkByAllSubjects(student));

        try {
            System.out.printf("Count average mark by " + Subject.SUBJECT_ONE.getSubjectName() +
                    " " + Faculty.FACULTY_ONE.getFaculty() + " " + Group.GROUP_TWO.getGroup() + " = %.1f\n",
                    StudentsList.countAverageMarkBySubjectFacultyGroup(Subject.SUBJECT_ONE, Faculty.FACULTY_ONE, Group.GROUP_TWO));
        } catch (AbsentFaculties | AbsentGroups e) {
            e.printStackTrace();
        }

        try {
            System.out.printf("Count average mark by " + Subject.SUBJECT_ONE.getSubjectName() +
                    " " + Faculty.FACULTY_THREE.getFaculty() + " " + Group.GROUP_ONE.getGroup() + " = %.1f\n",
                    StudentsList.countAverageMarkBySubjectFacultyGroup(Subject.SUBJECT_ONE, Faculty.FACULTY_THREE, Group.GROUP_ONE));
        } catch (AbsentFaculties | AbsentGroups e) {
            e.printStackTrace();
        }


        try {
            System.out.printf("Count average mark by " + Subject.SUBJECT_ONE.getSubjectName() +
                    " " + Faculty.FACULTY_ONE.getFaculty() + " " + Group.GROUP_ONE.getGroup() + " = %.1f\n",
                    StudentsList.countAverageMarkBySubjectFacultyGroup(Subject.SUBJECT_ONE, Faculty.FACULTY_ONE, Group.GROUP_ONE));
        } catch (AbsentFaculties | AbsentGroups e) {
            e.printStackTrace();
        }

        System.out.print("Count average mark by subject " + Subject.SUBJECT_ONE.getSubjectName() + " = ");
        System.out.printf("%.1f\n", StudentsList.countAverageMarkBySubject(Subject.SUBJECT_ONE));

    }
}
