package com.chess.piece;

import com.chess.models.*;
import com.chess.util.BoardUtil;
import com.chess.util.ErrorMessage;
import com.chess.util.PieceUtil;
import com.chess.util.Utils;

import java.util.HashSet;
import java.util.Set;

public class King extends Piece {

    public King(int x, int y) {
        super("King", x, y,
                Movements.SQUARE,
                (x == 7) ? Color.WHITE : Color.BLACK);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public ErrorMessage move(Board[][] board, Piece destination) {
        Set<Location> validMoves;
        validMoves = getValidMoves(board);

        if (validMoves.isEmpty()) {
            return new ErrorMessage(true, "No valid moves found");
        }

        if (Utils.isValidDestinationInValidLocations(validMoves, destination.getCurrentLocation())) {
            BoardUtil.setPieces(this, destination, board);
            return new ErrorMessage(false, null);

        } else {
            return new ErrorMessage(true, "Invalid move");

        }


    }

    private Set<Location> getValidMoves(Board[][] board) {
        Set<Location> validMoves = new HashSet<>();

        int X = getX();
        int Y = getY();

        int newX, newY;


        newX = X - 1;
        newY = Y;
        if (BoardUtil.isValidCoordinates(newX, newY)) {
            if (Board.isEmpty(newX, newY, board)) {
                validMoves.add(new Location(newX, newY));
            } else if (!PieceUtil.isSameColorPiece(X, Y, newX, newY, board)) {
                validMoves.add(new Location(newX, newY));
            }
        }


        newX = X - 1;
        newY = Y - 1;
        if (BoardUtil.isValidCoordinates(newX, newY)) {
            if (Board.isEmpty(newX, newY, board)) {
                validMoves.add(new Location(newX, newY));
            } else if (!PieceUtil.isSameColorPiece(X, Y, newX, newY, board)) {
                validMoves.add(new Location(newX, newY));
            }
        }


        newX = X - 1;
        newY = Y + 1;
        if (BoardUtil.isValidCoordinates(newX, newY)) {
            if (Board.isEmpty(newX, newY, board)) {
                validMoves.add(new Location(newX, newY));
            } else if (!PieceUtil.isSameColorPiece(X, Y, newX, newY, board)) {
                validMoves.add(new Location(newX, newY));
            }
        }


        newX = X + 1;
        newY = Y;
        if (BoardUtil.isValidCoordinates(newX, newY)) {
            if (Board.isEmpty(newX, newY, board)) {
                validMoves.add(new Location(newX, newY));
            } else if (!PieceUtil.isSameColorPiece(X, Y, newX, newY, board)) {
                validMoves.add(new Location(newX, newY));
            }
        }


        newX = X + 1;
        newY = Y + 1;
        if (BoardUtil.isValidCoordinates(newX, newY)) {
            if (Board.isEmpty(newX, newY, board)) {
                validMoves.add(new Location(newX, newY));
            } else if (!PieceUtil.isSameColorPiece(X, Y, newX, newY, board)) {
                validMoves.add(new Location(newX, newY));
            }
        }


        newX = X + 1;
        newY = Y - 1;
        if (BoardUtil.isValidCoordinates(newX, newY)) {
            if (Board.isEmpty(newX, newY, board)) {
                validMoves.add(new Location(newX, newY));
            } else if (!PieceUtil.isSameColorPiece(X, Y, newX, newY, board)) {
                validMoves.add(new Location(newX, newY));
            }
        }


        newX = X;
        newY = Y + 1;
        if (BoardUtil.isValidCoordinates(newX, newY)) {
            if (Board.isEmpty(newX, newY, board)) {
                validMoves.add(new Location(newX, newY));
            } else if (!PieceUtil.isSameColorPiece(X, Y, newX, newY, board)) {
                validMoves.add(new Location(newX, newY));
            }
        }

        newX = X;
        newY = Y - 1;
        if (BoardUtil.isValidCoordinates(newX, newY)) {
            if (Board.isEmpty(newX, newY, board)) {
                validMoves.add(new Location(newX, newY));
            } else if (!PieceUtil.isSameColorPiece(X, Y, newX, newY, board)) {
                validMoves.add(new Location(newX, newY));
            }
        }

        for (Location location : validMoves) {
            System.out.println(location);
        }
        return validMoves;


    }
}
