package com.chess.models;

import com.chess.piece.Empty;
import com.chess.util.ErrorMessage;

public abstract class Piece {
    protected String name;
    protected Location currentLocation;
    protected Movements movement;
    protected Color color;
    protected boolean isInitialMovement;


    protected Piece(String name, int x, int y,
                    Movements movement,
                    Color color) {
        this.name = name;
        this.currentLocation = new Location(x, y);
        this.movement = movement;
        this.color = color;
        this.isInitialMovement = true;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPosition(int x, int y) {
        this.currentLocation.setX(x);
        this.currentLocation.setY(y);
    }

    public Movements getMovement() {
        return movement;
    }

    public void setMovement(Movements movement) {
        this.movement = movement;
    }

    public int getX() {
        return currentLocation.getX();
    }

    public void setX(int x) {
        this.currentLocation.setX(x);
    }

    public int getY() {
        return currentLocation.getY();
    }

    public void setY(int y) {
        this.currentLocation.setY(y);
    }

    public String toString() {
        return "PieceModel{" +
                "name='" + name + '\'' +
                ", currentLocation=" + currentLocation +
                ", movement=" + movement +
                ", color=" + color +
                '}';
    }

    public String display() {
        if (this instanceof Empty) return "";

        return this.name + " " + this.color.toString() + " ";
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public boolean isInitialMove() {
        return false;
    }

    public Location getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(Location currentLocation) {
        this.currentLocation = currentLocation;
    }

    public boolean isInitialMovement() {
        return isInitialMovement;
    }

    public abstract ErrorMessage move(Board[][] board, Piece destination);

}
