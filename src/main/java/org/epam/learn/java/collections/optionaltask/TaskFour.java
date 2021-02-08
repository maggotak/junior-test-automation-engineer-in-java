package org.epam.learn.java.collections.optionaltask;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TaskFour {
    public static void main(String[] args) {
        String fileNameFrom = "src/main/resources/Byron.txt";
        List<String> listFromFile = new ArrayList<>(TaskOne.readFromFile(fileNameFrom));
        listFromFile.sort(Comparator.comparing(String::length));
        System.out.println(listFromFile);
    }
}
