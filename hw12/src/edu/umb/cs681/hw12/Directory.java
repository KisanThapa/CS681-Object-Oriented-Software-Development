package edu.umb.cs681.hw12;

import java.time.LocalDateTime;
import java.util.LinkedList;

public class Directory extends FSElement {

    private FileSystem fileSystem;
    LinkedList<FSElement> children;

    public Directory(Directory parent, String name, int size, LocalDateTime creationTime) {
        super(parent, name, size, creationTime);

        children = new LinkedList<>();

        if (parent != null) {
            parent.appendChild(this);
        }
    }

    @Override
    public boolean isDirectory() {
        return true;
    }

    public LinkedList<FSElement> getChildren() {
        return this.children;
    }

    public void appendChild(FSElement file) {
        children.add(file);
    }

    public int countChildren() {
        int countChild = 0;
        for (FSElement f : this.children)
            countChild += 1;
        return countChild;
    }

    public LinkedList<Directory> getSubDirectories() {
        LinkedList<Directory> directories = new LinkedList<>();
        for (FSElement fsElement : children) {
            if (fsElement instanceof Directory)
                directories.add((Directory) fsElement);
        }
        return directories;
    }

    public LinkedList<File> getFiles() {
        LinkedList<File> files = new LinkedList<>();
        for (FSElement fsElement : children) {
            if (fsElement instanceof File)
                files.add((File) fsElement);
        }
        return files;
    }

    public int getTotalSize() {
        int totalSize = 0;
        for (FSElement f : getChildren())
            if (f instanceof Directory)
                totalSize += ((Directory) f).getTotalSize();
            else
                totalSize += f.getSize();
        return totalSize;
    }

}
