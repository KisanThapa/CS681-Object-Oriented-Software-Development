package edu.umb.cs681.hw15;

import java.time.LocalDateTime;

public abstract class FSElement {
    private final Directory parent;
    private final String name;
    private final int size;
    private final LocalDateTime creationTime;

    public FSElement(Directory parent, String name, int size, LocalDateTime creationTime) {
        this.parent = parent;
        this.name = name;
        this.size = size;
        this.creationTime = creationTime;
    }

    public Directory getParent() {
        return this.parent;
    }

    public int getSize() {
        return this.size;
    }

    public LocalDateTime getCreationTime() {
        return this.creationTime;
    }

    public String getName() {
        return this.name;
    }

    public abstract boolean isDirectory();
}
