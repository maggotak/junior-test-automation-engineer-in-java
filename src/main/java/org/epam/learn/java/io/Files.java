package org.epam.learn.java.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Files {

    public static void doIfDirectory(File file) {
        List<Boolean> hierarchy = new ArrayList<>();
        StringBuilder listOfFiles = new StringBuilder();
        String text = makeListOfFiles(file, listOfFiles, hierarchy).toString();

        try (FileWriter writer = new FileWriter("data/testIO.txt")) {
            writer.write(file.getName());
            writer.write("\n");
            writer.write(text);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void doIfFile(File file) {
        try (FileReader reader = new FileReader(file)) {
            BufferedReader buffer = new BufferedReader(reader);
            List<String> textFromFile= new ArrayList<>();
            buffer.lines().forEach(textFromFile::add);

            System.out.println("Number of directories = " + numberOfDirectories(textFromFile));
            System.out.println("Number of files = " + numberOfFiles(textFromFile));
            System.out.printf("Average number of files in directory = %.2f%n", numberOfFilesInDirectory(textFromFile));
            System.out.printf("Average length of files = %.2f", averageLengthOfFile(textFromFile));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static StringBuilder makeListOfFiles(File file, StringBuilder listOfFiles, List<Boolean> hierarchyList) {
        File[] files = file.listFiles();
        for (int i = 0; i < files.length; i++) {
            if (files[i].isDirectory()) {
                hierarchyList.add(i != files.length - 1);
                indent(file, listOfFiles, hierarchyList).append(files[i].getName()).append("\n");
                makeListOfFiles(files[i], listOfFiles, hierarchyList);
                hierarchyList.remove(hierarchyList.size() - 1);
            }
            if (files[i].isFile()) {
                hierarchyList.add(i != files.length - 1);
                indent(files[i], listOfFiles, hierarchyList).append("  ").append(files[i].getName()).append("\n");
                hierarchyList.remove(hierarchyList.size() - 1);
            }
        }

        return listOfFiles;
    }
    private static StringBuilder indent(File file, StringBuilder listOfFiles, List<Boolean> hierarchyList) {
        if (file.isDirectory()) {
            for (int j = 0; j < hierarchyList.size() - 1; j++) {
                if (hierarchyList.get(j)) {
                    listOfFiles.append("|  ");
                } else {
                    listOfFiles.append("   ");
                }
            }
            if (hierarchyList.size() > 0) {
                listOfFiles.append("|--");
            }
        }
        if (file.isFile()) {
            for (int j = 0; j < hierarchyList.size() - 1; j++) {
                if (hierarchyList.get(j)) {
                    listOfFiles.append("|  ");
                } else {
                    listOfFiles.append("   ");
                }
            }
        }
        return listOfFiles;
    }

    private static int numberOfDirectories(List<String> text) {
        int number = 0;
        for (String s : text) {
            if (s.contains("|--")) {
                number++;
            }
        }
        return number;
    }
    private static int numberOfFiles(List<String> text) {
        int number = 0;
        for (String s : text) {
            if (!s.isEmpty() && !s.contains("|--")) {
                number++;
            }
        }
        return number - 1;
    }
    private static double numberOfFilesInDirectory(List<String> text) {
        int numberOfFiles = numberOfFiles(text);
        int numberOfDirectories = numberOfDirectories(text);
        return (double) numberOfFiles / numberOfDirectories;
    }
    private static double averageLengthOfFile(List<String> text) {
        int numberOfFiles = numberOfFiles(text);
        int length = 0;
        for (String s : text) {
            if (!s.isEmpty() && !s.contains("|--")) {
                length += s.trim().length();
            }
        }
        return (double) length / numberOfFiles;
    }
}


