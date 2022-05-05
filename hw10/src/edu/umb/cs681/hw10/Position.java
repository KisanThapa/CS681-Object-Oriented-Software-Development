package edu.umb.cs681.hw10;

import java.util.ArrayList;

final public class Position {
    private final double latitude, longitude, altitude;

    public Position(double latitude, double longitude, double altitude) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.altitude = altitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public double getAltitude() {
        return altitude;
    }

    public ArrayList<Double> getCoordinate() {
        ArrayList<Double> coordinates = new ArrayList<>();
        coordinates.add(latitude);
        coordinates.add(longitude);
        coordinates.add(altitude);
        return coordinates;
    }

    public Position changeLat(double newLat) {
        return new Position(newLat, this.longitude, this.altitude);
    }

    public Position changeLong(double newLong) {
        return new Position(this.latitude, newLong, this.altitude);
    }

    public Position changeAlt(double newAlt) {
        return new Position(this.latitude, this.longitude, newAlt);
    }

    public double distanceTo(Position anotherPosition) {
        double lat1 = Math.toRadians(this.latitude);
        double lat2 = Math.toRadians(anotherPosition.latitude);
        double lon1 = Math.toRadians(this.longitude);
        double lon2 = Math.toRadians(anotherPosition.longitude);
        double dLat = lat2 - lat1;
        double dLon = lon2 - lon1;
        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) + Math.cos(lat1) * Math.cos(lat2) * Math.sin(dLon / 2) * Math.sin(dLon / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        return 6371 * c;
    }

    public boolean equals(Position p) {
        return (latitude == p.latitude && longitude == p.longitude && altitude == p.altitude);
    }

    public String toString() {
        return "(" + latitude + ", " + longitude + ", " + altitude + ")";
    }
}
