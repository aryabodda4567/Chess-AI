package com.chess.piece;

import com.chess.models.*;
import com.chess.util.BoardUtil;
import com.chess.util.ErrorMessage;
import com.chess.util.MoveUtil;
import com.chess.util.Utils;

import java.util.HashSet;
import java.util.Set;

public class Rook extends Piece {
    public Rook(int x, int y) {
        super("Rook", x, y,
                Movements.PLUS,
                (x == 7) ? Color.WHITE : Color.BLACK);
    }

    public Rook(int x, int y, Color color) {
        super("Rook", x, y, Movements.PLUS, color);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public ErrorMessage move(Board[][] board, Piece destination) {
        Set<Location> possibleMoves = new HashSet<>();
        int X, Y;
        X = this.getX();
        Y = this.getY();

        possibleMoves.addAll(MoveUtil.getHorizontalLeftMoves(X, Y, board, this));
        possibleMoves.addAll(MoveUtil.getHorizontalRightMoves(X, Y, board, this));
        possibleMoves.addAll(MoveUtil.getVerticalBottomMoves(X, Y, board, this));
        possibleMoves.addAll(MoveUtil.getVerticalTopMoves(X, Y, board, this));


        if (possibleMoves.isEmpty()) {
            return new ErrorMessage(true, "No possible moves found");
        }

        if (Utils.isValidDestinationInValidLocations(possibleMoves, destination.getCurrentLocation())) {
            BoardUtil.setPieces(this, destination, board);
            return new ErrorMessage(false, null);
        } else {
            return new ErrorMessage(true, "Invalid move");
        }
    }

}


