package org.epam.learn.java.io;

import java.io.*;

public class Files {
    public static void doIfFile(File file) {
        try (FileReader reader = new FileReader(file)) {
            int numberOfFiles = 0;
            int numberOfDirectories = 0;
            int lengthOfFile = 0;

            BufferedReader buffer = new BufferedReader(reader);
            String line = buffer.readLine();
            while (line != null) {
                if (line.contains("|--")) {
                    numberOfDirectories++;
                }
                if (!line.isEmpty() && !line.contains("|--")) {
                    numberOfFiles++;
                    lengthOfFile += line.trim().length();
                }
                line = buffer.readLine();
            }

            System.out.println("Number of directories = " + numberOfDirectories);
            System.out.println("Number of files = " + numberOfFiles);
            System.out.printf("Average number of files in directory = %.2f%n", (double) numberOfFiles / numberOfDirectories);
            System.out.printf("Average length of files = %.2f", (double) lengthOfFile / numberOfFiles);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static void doIfDirectory(File file) {
        StringBuilder listOfFiles = new StringBuilder();
        String text = makeListOfFiles(file, listOfFiles, 1).toString();

        try (FileWriter writer = new FileWriter("data/testIO.txt")) {
            writer.write(file.getName());
            writer.write("\n");
            writer.write(text);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static StringBuilder makeListOfFiles(File file, StringBuilder listOfFiles, int level) {
        File[] files = file.listFiles(File::isDirectory);
        makeIndent(listOfFiles, files, level);
        files = file.listFiles(File::isFile);
        makeIndent(listOfFiles, files, level);
        return listOfFiles;
    }
    private static void makeIndent(StringBuilder listOfFiles, File[] files, int level) {
        for (File f : files) {
            if (f.isDirectory()) {
                for (int i = 0; i < level; i++) {
                    if (i < level - 1) {
                        listOfFiles.append("|  ");
                    } else {
                        listOfFiles.append("|--");
                    }
                }
                listOfFiles.append(f.getName()).append("\n");
                makeListOfFiles(f, listOfFiles, level + 1);
            }
            if (f.isFile()) {
                for (int i = 0; i < level; i++) {
                    listOfFiles.append("|  ");
                }
                listOfFiles.append("  ").append(f.getName()).append("\n");
            }
        }
    }
}


