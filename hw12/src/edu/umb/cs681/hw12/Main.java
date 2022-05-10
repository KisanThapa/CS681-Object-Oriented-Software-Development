package edu.umb.cs681.hw12;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        LocalDateTime date = LocalDateTime.now();

        Directory dr1 = new Directory(null, "Root", 12, date);
        Directory dr2 = new Directory(dr1, "Home", 8, date);

        File f1 = new File(dr2, "Main.java", 5, date);

        System.out.println(f1.getName());
        System.out.println(dr1.getTotalSize());
        System.out.println(f1.getParent().getParent().countChildren());

    }
}
