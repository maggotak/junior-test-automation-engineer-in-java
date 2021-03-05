package org.epam.learn.java.exceptionscorrect;

import org.epam.learn.java.exceptionscorrect.enums.Subject;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class SubjectAndMarksGenerator {
    public static Map<Subject, Integer> generateSubjectsAndMarks() {
        Random random = new Random();
        Map<Subject, Integer> subjectsMap= new HashMap<>();

        Subject[] subjects = Subject.values();

        int numberOfSubjects = random.nextInt(6);

        for (int i = 1; i <= numberOfSubjects; i++) {
            int mark = random.nextInt(12) - 1;
            subjectsMap.put(subjects[random.nextInt(4)], mark);
        }

        return subjectsMap;
    }
}
