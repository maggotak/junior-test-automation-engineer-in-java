package org.epam.learn.java.classes;


import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        StudentsList studentsList = new StudentsList();
        studentsList.addStudent(new Student("Ivanov", "Ivan", "Ivanovich",
                                        LocalDate.parse("1995-08-19"), "Moscow",
                        785695414, Faculty.FACULTY_ONE, Course.FIRST, Group.GROUP_ONE));
        studentsList.addStudent(new Student("Petrov", "Petr", "Petrovich",
                LocalDate.parse("1994-09-25"), "Kazan",
                736995452, Faculty.FACULTY_TWO, Course.SECOND, Group.GROUP_TWO));
        studentsList.addStudent(new Student("Ivanova", "Maria", "Ivanovna",
                LocalDate.parse("1998-09-13"), "Moscow",
                785695694, Faculty.FACULTY_THREE, Course.FIRST, Group.GROUP_THREE));
        studentsList.addStudent(new Student("Petrov", "Ivan", "Ivanovich",
                LocalDate.parse("1996-12-19"), "Moscow",
                785695416, Faculty.FACULTY_TWO, Course.FIRST, Group.GROUP_ONE));
        studentsList.addStudent(new Student("Soboleva", "Ekaterina", "Vasilevna",
                LocalDate.parse("1995-02-19"), "Sizran",
                785696415, Faculty.FACULTY_TWO, Course.THIRD, Group.GROUP_THREE));

        System.out.println(studentsList.getStudentsByFaculty(Faculty.FACULTY_TWO));
        System.out.println(studentsList.getStudentsByFacultyAndCourse(Faculty.FACULTY_ONE, Course.FIRST));
        System.out.println(studentsList.getStudentsBornAfterYear(LocalDate.parse("1995-01-01")));
        System.out.println(studentsList.getStudentsGroup(Faculty.FACULTY_ONE, Course.FIRST, Group.GROUP_ONE));

    }
}
