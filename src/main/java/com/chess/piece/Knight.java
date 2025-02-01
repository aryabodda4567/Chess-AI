package com.chess.piece;

import com.chess.models.*;
import com.chess.util.BoardUtil;
import com.chess.util.Message;
import com.chess.util.Utils;

import java.util.HashSet;
import java.util.Set;

public class Knight extends Piece {

    public Knight(int x, int y) {
        super("Knight", x, y, Movements.L,
                (x == 7) ? Color.WHITE : Color.BLACK);
    }

    public Knight(int x, int y, Color color) {
        super("Knight", x, y, Movements.L, color);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public Message move(Board[][] board, Piece destination) {
        Set<Location> possibleLocations;

        possibleLocations = getValidMoves(board, destination);
        if (possibleLocations.isEmpty()) {
            return new Message(true, "No valid moves found");
        }

        if (Utils.isValidDestinationInValidLocations(possibleLocations, destination.getCurrentLocation())) {
            BoardUtil.setPieces(this, destination, board);
            return new Message(false, null);
        } else {
            return new Message(true, "Invalid move");
        }

    }


    /// ALERT: This method only check valid positions and add all locations which can be accessed from the knight location
    /// irrespective of the piece present at square
    /// Use 'PieceUtil.isSameColorPiece()' method before calling this method
    public Set<Location> getValidMoves(Board[][] board, Piece destination) {
        Set<Location> validMoves = new HashSet<>();
//        validMoves.add(new Location(X+i, Y+j));
//        validMoves.add(new Location(X-i, Y-j));
//        validMoves.add(new Location(X+i, Y-j));
//        validMoves.add(new Location(X-i, Y+j));

        int X = this.getX();
        int Y = this.getY();


        for (int i = 1, j = 2; i <= 2 && j >= 1; i++, j--) {

            if (BoardUtil.isValidCoordinates(X + i, Y + j)) {
                validMoves.add(new Location(X + i, Y + j));
            }

            if (BoardUtil.isValidCoordinates(X - i, Y - j)) {
                validMoves.add(new Location(X - i, Y - j));
            }

            if (BoardUtil.isValidCoordinates(X + i, Y - j)) {
                validMoves.add(new Location(X + i, Y - j));
            }

            if (BoardUtil.isValidCoordinates(X - i, Y + j)) {
                validMoves.add(new Location(X - i, Y + j));
            }

        }

        return validMoves;


    }
}
