package org.epam.learn.java.exceptionscorrect;

import org.epam.learn.java.exceptionscorrect.custom.exceptions.NoStudentException;
import org.epam.learn.java.exceptionscorrect.custom.exceptions.IllegalMarkException;
import org.epam.learn.java.exceptionscorrect.custom.exceptions.NoSubjectException;
import org.epam.learn.java.exceptionscorrect.enums.GroupName;
import org.epam.learn.java.exceptionscorrect.enums.Subject;

import java.util.ArrayList;
import java.util.List;

public class Group implements AverageMarkBySubject {
    private final GroupName groupName;
    private List<Student> studentListInGroup;

    public Group(GroupName groupName) {
        this.groupName = groupName;
    }

    public Group(GroupName groupName, List<Student> studentListInGroup) {
        this.groupName = groupName;
        this.studentListInGroup = studentListInGroup;
    }

    public GroupName getGroupName() {
        return groupName;
    }

    public List<Student> getStudentListInGroup() {
        return studentListInGroup;
    }

    public List<Student> getStudents() throws NoStudentException {
        if (studentListInGroup.isEmpty()) {
            throw new NoStudentException("No students in group " + groupName);
        }
        return studentListInGroup;
    }

    public Student getStudent(int id) throws NoStudentException {
        for (Student student : studentListInGroup) {
            if (student.getId() == id) {
                return student;
            }
        }
        throw new NoStudentException("No student with id=" + id + " in group" + groupName);
    }

    public void addStudent(Student student) {
        if (studentListInGroup == null) {
            studentListInGroup = new ArrayList<>();
        }
        studentListInGroup.add(student);
    }

    @Override
    public double getAverageMarkBySubject(Subject subject) throws NoSubjectException, NoStudentException {
        if (studentListInGroup == null) {
            throw new NoStudentException("There is no students in group " + groupName);
        }

        int sum = 0;
        int count = 0;
        for (Student student : studentListInGroup) {
                try {
                    sum += student.getMarkBySubject(subject);
                    count++;
                } catch (NoSubjectException | IllegalMarkException e) {
                    e.printStackTrace();
                }
        }

        if (count == 0) {
            throw new NoSubjectException("No subject " + subject + " found at group " + groupName);
        }
        return (double) sum / count;
    }


    @Override
    public String toString() {
        return "Group{" +
                "groupName=" + groupName +
                ", studentListInGroup=" + studentListInGroup +
                '}';
    }
}
