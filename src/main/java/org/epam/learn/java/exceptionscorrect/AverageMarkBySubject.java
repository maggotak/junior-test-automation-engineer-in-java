package org.epam.learn.java.exceptionscorrect;

import org.epam.learn.java.exceptionscorrect.custom.exceptions.NoFacultyException;
import org.epam.learn.java.exceptionscorrect.custom.exceptions.NoGroupsException;
import org.epam.learn.java.exceptionscorrect.custom.exceptions.NoStudentException;
import org.epam.learn.java.exceptionscorrect.custom.exceptions.NoSubjectException;
import org.epam.learn.java.exceptionscorrect.enums.Subject;

public interface AverageMarkBySubject {
    double getAverageMarkBySubject(Subject subject) throws NoSubjectException, NoStudentException, NoGroupsException, NoFacultyException;
}
