package edu.umb.cs681.hw12;

import java.util.LinkedList;

public class FileSystem {
    private static FileSystem instance;
    LinkedList<Directory> directory = new LinkedList<>();

    private FileSystem() {
    }

    public static FileSystem getFileSystem() {
        if (instance == null)
            instance = new FileSystem();
        return instance;
    }

    public LinkedList<Directory> getRootDir() {
        return this.directory;
    }

    public void addRootDir(Directory root) {
        directory.add(root);
    }

}
