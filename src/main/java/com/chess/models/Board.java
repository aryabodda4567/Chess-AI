package com.chess.models;
///
/// Board acts as chess board with 8X8 matrix
///
public class Board {
    Location location;
    Piece piece;

    public Board(int x, int y, Piece piece) {
        location = new Location(x, y);
        this.piece = piece;
    }
    public Location getLocation() {
        return location;
    }
    public void setLocation(Location location) {
        this.location = location;
    }
    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }
}
