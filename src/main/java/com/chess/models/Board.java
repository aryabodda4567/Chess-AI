package com.chess.models;

import com.chess.piece.Empty;

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

    public static boolean isEmpty(Location location, Board[][] board) {
        return isEmpty(location.getX(), location.getY(),board);
    }

    public  static boolean isEmpty(int x, int y, Board[][] board) {
        return  board[x][y].getPiece() instanceof Empty;
    }
}
