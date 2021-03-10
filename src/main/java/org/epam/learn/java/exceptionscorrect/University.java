package org.epam.learn.java.exceptionscorrect;

import org.epam.learn.java.exceptionscorrect.custom.exceptions.NoFacultyException;
import org.epam.learn.java.exceptionscorrect.custom.exceptions.NoGroupsException;
import org.epam.learn.java.exceptionscorrect.custom.exceptions.NoSubjectException;
import org.epam.learn.java.exceptionscorrect.enums.FacultyName;
import org.epam.learn.java.exceptionscorrect.enums.Subject;

import java.util.ArrayList;
import java.util.List;

public class University implements AverageMarkInterface {
    private final String name;
    private List<Faculty> faculties;

    public University(String name) {
        this.name = name;
        faculties = new ArrayList<>();
    }

    public University(String name, List<Faculty> faculties) {
        this.name = name;
        this.faculties = faculties;
    }

    public String getName() {
        return name;
    }

    public List<Faculty> getFaculties() throws NoFacultyException {
        if (faculties.isEmpty()) {
            throw new NoFacultyException("No faculties in university");
        }
        return faculties;
    }

    public Faculty getFaculty(FacultyName facultyName) throws NoFacultyException {
        if (faculties.isEmpty()) {
            throw new NoFacultyException("No faculties in university");
        }
        for (Faculty faculty : faculties) {
            if (faculty.getFacultyName() == facultyName) {
                return faculty;
            }
        }
        throw new NoFacultyException("No faculty " + facultyName + " in university");
    }

    public void addFaculty(Faculty faculty) {
        if (faculties.isEmpty()) {
            faculties = new ArrayList<>();
        }
        faculties.add(faculty);
    }

    @Override
    public double getAverageMarkBySubject(Subject subject) throws NoSubjectException, NoFacultyException {
        if (faculties.isEmpty()) {
            throw new NoFacultyException("Thre is no faculties in university " + name);
        }

        int sum = 0;
        int count = 0;
        for (Faculty faculty : faculties) {
            try {
                sum += faculty.getAverageMarkBySubject(subject);
                count++;
            } catch (NoSubjectException | NoGroupsException e) {
                e.printStackTrace();
            }
        }
        if (count == 0) {
            throw new NoSubjectException("No subject " + subject + " found at university " + name);
        }
        return (double) sum / count;
    }

    @Override
    public String toString() {
        return "University{" +
                "name='" + name + '\'' +
                ", faculties=" + faculties +
                '}';
    }
}
