package com.chess.models;

import com.chess.piece.Empty;

public class PieceModel implements Piece {
    protected String name;
    protected Location currentLocation;
    protected Movements movement;
    protected Color color;


    protected PieceModel(String name, int x, int y,
                         Movements movement,
                         Color color) {
        this.name = name;
        this.currentLocation = new Location(x, y);
        this.movement = movement;
        this.color = color;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setPosition(int x, int y) {
        this.currentLocation.setX(x);
        this.currentLocation.setY(y);
    }

    @Override
    public Movements getMovement() {
        return movement;
    }

    @Override
    public int getX() {
        return currentLocation.getX();
    }

    @Override
    public void setX(int x) {
        this.currentLocation.setX(x);
    }

    @Override
    public int getY() {
        return currentLocation.getY();
    }

    @Override
    public void setY(int y) {
        this.currentLocation.setY(y);
    }

    @Override
    public String toString() {
        return "PieceModel{" +
                "name='" + name + '\'' +
                ", currentLocation=" + currentLocation +
                ", movement=" + movement +
                '}';
    }


    @Override
    public String display() {
        if(this instanceof Empty) return "";

        return this.name + " " + this.color.toString() + " ";
    }


}
