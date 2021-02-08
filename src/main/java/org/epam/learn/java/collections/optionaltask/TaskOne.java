package org.epam.learn.java.collections.optionaltask;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayDeque;

public class TaskOne {
    public static void main(String[] args) {
        String fileNameFrom = "src/main/resources/Byron.txt";
        String fileNameTo = "src/main/resources/ByronInReverse.txt";
        ArrayDeque<String> listFromFile = readFromFile(fileNameFrom);
        writeToFileInReverse(listFromFile, fileNameTo);
    }

    public static ArrayDeque<String> readFromFile(String fileName) {
        ArrayDeque<String> linesFromFile = new ArrayDeque<>();
        try (FileReader fileReader = new FileReader(fileName);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String line = bufferedReader.readLine();
            while (line != null) {
                linesFromFile.push(line);
                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return linesFromFile;
    }
    public static void writeToFileInReverse(ArrayDeque<String> stack, String fileName) {

        try (FileWriter fileWriter = new FileWriter(fileName, true)) {
            while (!stack.isEmpty()) {
                fileWriter.write(stack.pop());
                fileWriter.append('\n');
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
