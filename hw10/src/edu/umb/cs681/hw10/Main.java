package edu.umb.cs681.hw10;

public class Main {
    public static void main(String[] args) {
        Position p1 = new Position(40.818746, -74.1796875, 50);
        Position p2 = new Position(45.81875, -78.1796875, 50);
        Position p3 = new Position(45.81875, -78.1796875, 50);

        System.out.println(p1.distanceTo(p2));
        System.out.println(p2.equals(p3));

        System.out.println(p1.changeLat(50.38942));
        System.out.println(p1.changeLong(-90.35522));
        System.out.println(p1.changeAlt(100));
    }
}
