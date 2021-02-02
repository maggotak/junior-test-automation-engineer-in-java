package org.epam.learn.java.classes;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class StudentsList {
    private List<Student> students;

    public StudentsList() {
        students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public List<Student> getStudents() {
        return students;
    }

    public List<Student> getStudentsByFaculty(Faculty faculty) {
        List<Student> list = new ArrayList<>();
        for (Student st : students) {
            if (st.getFaculty() == faculty) {
                list.add(st);
            }
        }
        return list;
    }

    public List<Student> getStudentsByFacultyAndCourse(Faculty faculty, Course course) {
        List<Student> list = new ArrayList<>();
        for (Student st : students) {
            if (st.getFaculty() == faculty && st.getCourse() == course) {
                list.add(st);
            }
        }
        return list;
    }

    public List<Student> getStudentsBornAfterYear(LocalDate date) {
        List<Student> list = new ArrayList<>();
        for (Student st : students) {
            if (st.getBirthDate().isAfter(date)) {
                list.add(st);
            }
        }
        return list;
    }

    public List<Student> getStudentsGroup(Faculty faculty, Course course, Group group) {
        List<Student> list = new ArrayList<>();
        for (Student st : students) {
            if (st.getFaculty() == faculty && st.getCourse() == course
            && st.getGroup() == group) {
                list.add(st);
            }
        }
        return list;
    }
}
