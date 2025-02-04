package com.chess.util;

import com.chess.models.Square;
import com.chess.models.Color;
import com.chess.models.Location;
import com.chess.models.Piece;
import com.chess.piece.Empty;

import javax.swing.*;
import java.util.Objects;
import java.util.Set;

import static com.chess.util.BoardUtil.setPiece;

public class Utils {


    public static void clearScreen() {
        for (int i = 0; i < 100; i++) // Default Height of cmd is 300 and Default width is 80
            System.out.print("\n");
    }

    public static void exitGame() {
        System.out.println("Game exited.");

    }

    public static void drawGame() {
        System.out.println("Draw game.");

    }

    public static void checkmate() {
        System.out.println("Check mate.");
    }

    public static void check() {
        System.out.println("Check.");
    }

    public static void printInvalidMove(String message) {
        System.out.println("Invalid move please place correct move \nMessage: " + message);
    }

    public static void printInvalidMove() {
        System.out.println("Invalid move please place correct move ");
    }

    public static boolean isValidDestinationInValidLocations(Set<Location> locationSet, Location destinationLocation) {
        for (Location location : locationSet) {
            if (location.equals(destinationLocation)) return true;
        }
        return false;
    }

    public static void init(Square[][] board) {
        // Assign white
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 8; j++) {
                board[i][j] = new Square(i, j, setPiece(i, j));

            }
        }
        // Assign Black
        for (int i = 7; i >= 6; i--) {
            for (int j = 0; j < 8; j++) {
                board[i][j] = new Square(i, j, setPiece(i, j));

            }
        }
        // Assign Empty
        for (int i = 2; i < 6; i++) {
            for (int j = 0; j < 8; j++) {
                board[i][j] = new Square(i, j, new Empty(i, j));
            }
        }
    }

    ///     Method handles all error and return error object
    public static Message validateMove(String move, Square[][] board, Color currentColor) {

//        Validate
        if (move.trim().isEmpty()) return new Message(true, "No move entered.");


//        Get locations from user moves
        Location[] locations = MoveUtil.parseMove(move);
        if (locations == null) {
            return new Message(true, "Invalid Move or wrong source or destination locations ");
        }


//            Check if the source or destination is empty
        if (Square.isEmpty(locations[0], board)) {
            return new Message(true, "Empty source or destination locations ");
        }


//           Check whether the two pieces are of same color
        Piece sourcePiece = board[locations[0].getX()][locations[0].getY()].getPiece();
        Piece destinationPiece = board[locations[1].getX()][locations[1].getY()].getPiece();
        if (PieceUtil.isSameColorPiece(sourcePiece, destinationPiece)) {
            return new Message(true, "You can't hit your piece");
        }

//            Check valid color move
        if (!sourcePiece.getColor().equals(currentColor)) {
            return new Message(true, sourcePiece.getColor() + " is not your piece");
        }

//            Check source and destination are same coordinates
        if (locations[0].equals(locations[1])) {
            return new Message(true, "You can't hit your piece");
        }


        return sourcePiece.move(board, destinationPiece);
//             return new ErrorMessage(false,null);
    }

    ///  Toggle the color
    public static Color updateMove(Color currentColor) {
//    Toggle color
        if (currentColor == Color.BLACK) {
            return Color.WHITE;
        } else {
            return Color.BLACK;
        }

    }

    public void displayInstructions() {
        System.out.println("1: Each cell contains the name and color of the piece.");
        System.out.println("2: Empty cells do not contain any pieces.");
        System.out.println("3: To move a piece, enter the source location and the destination location.");
        System.out.println("   - Format: For example, 'c1 c5' means moving the piece from c1 to c5.");
        System.out.println("4: To declare a draw, type 'DRAW'.");
        System.out.println("5: To exit the game, type 'EXIT'.");

    }
}
