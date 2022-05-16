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
        lock.lock();
        try {
            return this.children;
        } finally {
            lock.unlock();
        }
    }

    public void appendChild(FSElement file) {
        lock.lock();
        try {
            this.children.add(file);
        } finally {
            lock.unlock();
        }
    }

    public int countChildren() {
        lock.lock();
        try {
            int countChild = 0;
            for (FSElement f : this.children)
                countChild += 1;
            return countChild;
        } finally {
            lock.unlock();
        }
    }

    public LinkedList<Directory> getSubDirectories() {
        lock.lock();
        try {
            LinkedList<Directory> directories = new LinkedList<>();
            for (FSElement fsElement : children) {
                if (fsElement instanceof Directory)
                    directories.add((Directory) fsElement);
            }
            return directories;
        } finally {
            lock.unlock();
        }
    }

    public LinkedList<File> getFiles() {
        lock.lock();
        try {
            LinkedList<File> files = new LinkedList<>();
            for (FSElement fsElement : children) {
                if (fsElement instanceof File)
                    files.add((File) fsElement);
            }
            return files;
        } finally {
            lock.unlock();
        }
    }

    public int getTotalSize() {
        lock.lock();
        try {
            int totalSize = 0;
            for (FSElement f : getChildren())
                if (f instanceof Directory)
                    totalSize += ((Directory) f).getTotalSize();
                else
                    totalSize += f.getSize();
            return totalSize;
        } finally {
            lock.unlock();
        }
    }
}
