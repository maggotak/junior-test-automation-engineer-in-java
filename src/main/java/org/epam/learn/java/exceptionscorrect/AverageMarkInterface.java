package org.epam.learn.java.exceptionscorrect;

import org.epam.learn.java.exceptionscorrect.custom.exceptions.*;
import org.epam.learn.java.exceptionscorrect.enums.Subject;

public interface AverageMarkInterface {
    double getAverageMarkBySubject(Subject subject) throws NoSubjectException, NoStudentException, NoGroupsException, NoFacultyException, IllegalMarkException;
}
