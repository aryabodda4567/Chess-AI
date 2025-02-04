package com.chess.piece;

import com.chess.models.*;
import com.chess.util.BoardUtil;
import com.chess.util.Message;
import com.chess.util.MoveUtil;
import com.chess.util.Utils;

import java.util.HashSet;
import java.util.Set;

public class Queen extends Piece {
    public Queen(int x, int y) {
        super("Queen", x, y,
                Movements.STAR,
                (x == 7) ? Color.WHITE : Color.BLACK);
    }

    public Queen(int x, int y, Color color) {
        super("Queen", x, y, Movements.STAR, color);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public Message move(Square[][] board, Piece destination) {
        Set<Location> possibleMoves = new HashSet<>();

        int X = getX();
        int Y = getY();
        possibleMoves.addAll(MoveUtil.getDiagonalBottomRightMoves(X, Y, board, this));
        possibleMoves.addAll(MoveUtil.getDiagonalTopRightMoves(X, Y, board, this));
        possibleMoves.addAll(MoveUtil.getDiagonalBottomLeftMoves(X, Y, board, this));
        possibleMoves.addAll(MoveUtil.getDiagonalTopLeftMoves(X, Y, board, this));

        possibleMoves.addAll(MoveUtil.getHorizontalRightMoves(X, Y, board, this));
        possibleMoves.addAll(MoveUtil.getHorizontalLeftMoves(X, Y, board, this));
        possibleMoves.addAll(MoveUtil.getVerticalBottomMoves(X, Y, board, this));
        possibleMoves.addAll(MoveUtil.getVerticalTopMoves(X, Y, board, this));

        if (possibleMoves.isEmpty()) {
            return new Message(true, "No possible moves found");
        }

        if (Utils.isValidDestinationInValidLocations(possibleMoves, destination.getCurrentLocation())) {
            BoardUtil.setPieces(this, destination, board);
            return new Message(false, null);
        } else {
            return new Message(true, "Invalid move");
        }


    }
}
