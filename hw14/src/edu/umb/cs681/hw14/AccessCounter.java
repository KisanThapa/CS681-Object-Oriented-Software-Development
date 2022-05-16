package edu.umb.cs681.hw14;

import java.nio.file.Path;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class AccessCounter {

    private static AccessCounter instance = null;
    private static final ReentrantLock staticLock = new ReentrantLock();

    private ConcurrentHashMap<Path, AtomicInteger> counterMap = new ConcurrentHashMap<>();

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
        counterMap.compute(path, (key, value) -> {
            if (value == null) {
                System.out.println(Thread.currentThread().getName() + " increment " + path + " count " + counterMap.get(path));
                return new AtomicInteger(1);
            } else {
                System.out.println(Thread.currentThread().getName() + " increment " + path + " count " + counterMap.get(path));
                return new AtomicInteger(value.incrementAndGet());
            }
        });
    }

    public int getCount(Path path) {
        return counterMap.compute(path, (key, value) -> {
            if (value == null) {
                System.out.println(Thread.currentThread().getName() + " getCount " + path + " count " + counterMap.get(path));
                return new AtomicInteger(0);
            } else {
                System.out.println(Thread.currentThread().getName() + " getCount " + path + " count " + counterMap.get(path));
                return new AtomicInteger(value.get());
            }
        }).get();
    }
}
