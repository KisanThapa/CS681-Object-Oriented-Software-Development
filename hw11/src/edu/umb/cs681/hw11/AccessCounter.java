package edu.umb.cs681.hw11;

import java.nio.file.Path;
import java.util.HashMap;
import java.util.concurrent.locks.ReentrantLock;

public class AccessCounter {

    private static AccessCounter instance = null;
    private static final ReentrantLock staticLock = new ReentrantLock();
    private final ReentrantLock nonStaticLock = new ReentrantLock();

    private HashMap<Path, Integer> counterMap = new HashMap<>();

    private AccessCounter() {
        // private constructor
    }

    public static AccessCounter getInstance() {
        staticLock.lock();
        try {
            if (instance == null)
                instance = new AccessCounter();
            return instance;
        } finally {
            staticLock.unlock();
        }
    }

    public void increment(Path path) {
        nonStaticLock.lock();
        try {
            if (counterMap.containsKey(path))
                counterMap.put(path, counterMap.get(path) + 1);
            else
                counterMap.put(path, 1);
        } finally {
            System.out.println(Thread.currentThread().getName() + " increment " + path + " count " + counterMap.get(path));
            nonStaticLock.unlock();
        }
    }

    public int getCount(Path path) {
        nonStaticLock.lock();
        try {
            return counterMap.getOrDefault(path, 0);
        } finally {
            System.out.println(Thread.currentThread().getName() + " increment " + path + " count " + counterMap.get(path));
            nonStaticLock.unlock();
        }
    }
}
