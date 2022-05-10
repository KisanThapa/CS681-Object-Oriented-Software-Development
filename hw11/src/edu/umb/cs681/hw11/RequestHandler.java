package edu.umb.cs681.hw11;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;

public class RequestHandler implements Runnable {

    private static ArrayList<Path> filePaths = new ArrayList<>();
    private ReentrantLock lock;
    private AtomicBoolean done = new AtomicBoolean(false);

    public RequestHandler() {
        lock = new ReentrantLock();
    }

    public void setDone() {
        lock.lock();
        try {
            done.set(true);
        } finally {
            lock.unlock();
        }
    }

    @Override
    public void run() {

        AccessCounter accessCounter = AccessCounter.getInstance();

        while (true) {
            lock.lock();
            try {
                if (done.get()) break;

                int randInt = new Random().nextInt(filePaths.size());

                Path path = filePaths.get(randInt);
                accessCounter.increment(path);
                accessCounter.getCount(path);
            } finally {
                lock.unlock();
            }

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                continue;
            }
        }
    }

    public static void main(String[] args) {
        filePaths.add(Paths.get("file1.html"));
        filePaths.add(Paths.get("file2.html"));
        filePaths.add(Paths.get("file3.html"));
        filePaths.add(Paths.get("file4.html"));

        ArrayList<Thread> threads = new ArrayList<>();
        RequestHandler requestHandler = new RequestHandler();

        for (int i = 0; i < 15; i++) {
            Thread thread = new Thread(requestHandler);
            threads.add(thread);
            thread.start();
        }

        threads.forEach(t -> {
            try {
                t.interrupt();
                requestHandler.setDone();
                t.join();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
