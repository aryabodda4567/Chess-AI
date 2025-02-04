package com.chess.models;

import com.chess.piece.Empty;

import javax.swing.*;

/// Board acts as chess board with 8X8 matrix
public class Square {


    JButton squareButton;
    Location location;
    Piece piece;
    Icon icon = new ImageIcon("/WHITE_KING.png");


    public Color currentColor = Color.WHITE;

    public Square(int x, int y, Piece piece) {
        location = new Location(x, y);
        this.piece = piece;
    }

    public static boolean isEmpty(Location location, Square[][] board) {
        return isEmpty(location.getX(), location.getY(), board);
    }

    public static boolean isEmpty(int x, int y, Square[][] board) {
        return board[x][y].getPiece() instanceof Empty;
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

    public JButton getSquareButton() {
        return squareButton;
    }

    public void setSquareButton(JButton squareButton) {
        this.squareButton = squareButton;
    }
    public Icon getIcon() {
        return icon;
    }
    public void setIcon(Icon icon) {
        this.icon = icon;
    }
}
