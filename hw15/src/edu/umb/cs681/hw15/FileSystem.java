package edu.umb.cs681.hw15;

import java.util.concurrent.ConcurrentLinkedQueue;

public class FileSystem {
    private static FileSystem instance;
    ConcurrentLinkedQueue<Directory> directory = new ConcurrentLinkedQueue<>();

    private FileSystem() {
    }

    public static FileSystem getFileSystem() {
        if (instance == null)
            instance = new FileSystem();
        return instance;
    }

    public ConcurrentLinkedQueue<Directory> getRootDir() {
        return this.directory;
    }

    public void addRootDir(Directory root) {
        directory.add(root);
    }

}
