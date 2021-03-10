package org.epam.learn.java.exceptionscorrect;

import org.epam.learn.java.exceptionscorrect.custom.exceptions.IllegalMarkException;
import org.epam.learn.java.exceptionscorrect.enums.Subject;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class SubjectAndMarksGenerator {
    public static Map<Subject, Integer> generateSubjectsAndMarks() throws IllegalMarkException {
        Random random = new Random();
        Map<Subject, Integer> subjectsMap= new HashMap<>();

        Subject[] subjects = Subject.values();

        int numberOfSubjects = random.nextInt(6);

        for (int i = 1; i <= numberOfSubjects; i++) {
            int mark = random.nextInt(12) - 1;
            if (mark < 0 || mark > 10) {
                throw new IllegalMarkException("Illegal mark (less than 0 or more than 10)");
            }
            subjectsMap.put(subjects[random.nextInt(4)], mark);
        }

        return subjectsMap;
    }
}
