package org.example.models;

public class Location {
    int x;
    int y;

    public Location(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean equals(Location location) {
        return location.getX() == this.getX() && location.getY() == this.getY();
    }

    public String toString() {
        return "(" + this.getX() + ", " + this.getY() + ")";
    }
}
