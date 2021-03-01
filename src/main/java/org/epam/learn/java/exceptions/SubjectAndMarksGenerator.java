package org.epam.learn.java.exceptions;

import org.epam.learn.java.exceptions.custom.exceptions.AbsentSubject;
import org.epam.learn.java.exceptions.custom.exceptions.IllegalMark;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class SubjectAndMarksGenerator {
    public static Map<Subject, Integer> generateSubjectsAndMarks() throws AbsentSubject, IllegalMark {
        Random random = new Random();
        Map<Subject, Integer> subjectsMap= new HashMap<>();

        Subject[] subjects = Subject.values();

        int numberOfSubjects = random.nextInt(6);
        if (numberOfSubjects == 0) {
            throw new AbsentSubject("No subject");
        }

        for (int i = 1; i <= numberOfSubjects; i++) {
            int mark = random.nextInt(12) - 1;
            if (mark < 0 || mark > 10) {
                throw new IllegalMark("Illegal mark (less than 0 or more than 10)");
            }
            subjectsMap.put(subjects[random.nextInt(4)], mark);
        }

        return subjectsMap;
    }
}
