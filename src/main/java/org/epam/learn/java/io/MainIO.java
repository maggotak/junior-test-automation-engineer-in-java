package org.epam.learn.java.io;

import java.io.File;

public class MainIO {
    public static void main(String[] args) {
        File file = new File(args[0]);
        if (file.exists() && file.isDirectory()) {
            Files.doIfDirectory(file);
        }
        if (file.exists() && file.isFile()) {
            Files.doIfFile(file);
        }
    }
}
