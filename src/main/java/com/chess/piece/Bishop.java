package com.chess.piece;

import com.chess.models.*;
import com.chess.util.BoardUtil;
import com.chess.util.Message;
import com.chess.util.MoveUtil;
import com.chess.util.Utils;

import java.util.HashSet;
import java.util.Set;

public class Bishop extends Piece {

    public Bishop(int x, int y) {
        super("Bishop", x, y,
                Movements.DIAGONAL,
                (x == 7) ? Color.WHITE : Color.BLACK);
    }

    public Bishop(int x, int y, Color color) {
        super("Bishop", x, y, Movements.DIAGONAL, color);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public Message move(Square[][] board, Piece destination) {
        Set<Location> possibleLocations = new HashSet<>();
        int X = this.getX();
        int Y = this.getY();
        possibleLocations.addAll(MoveUtil.getDiagonalBottomRightMoves(X, Y, board, this));
        possibleLocations.addAll(MoveUtil.getDiagonalTopRightMoves(X, Y, board, this));
        possibleLocations.addAll(MoveUtil.getDiagonalBottomLeftMoves(X, Y, board, this));
        possibleLocations.addAll(MoveUtil.getDiagonalTopLeftMoves(X, Y, board, this));


        if (possibleLocations.isEmpty()) {
            return new Message(true, "No possible moves found");
        }

        if (Utils.isValidDestinationInValidLocations(possibleLocations, destination.getCurrentLocation())) {
            BoardUtil.setPieces(this, destination, board);
            return new Message(false, null);
        } else {
            return new Message(true, "Invalid move");
        }

    }

}
