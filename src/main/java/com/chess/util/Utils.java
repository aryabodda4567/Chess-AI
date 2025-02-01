package com.chess.util;

import com.chess.models.Board;
import com.chess.models.GameOption;
import com.chess.models.Location;

import java.util.Set;

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

    public void displayInstructions() {
        System.out.println("1: Each cell contains the name and color of the piece.");
        System.out.println("2: Empty cells do not contain any pieces.");
        System.out.println("3: To move a piece, enter the source location and the destination location.");
        System.out.println("   - Format: For example, 'c1 c5' means moving the piece from c1 to c5.");
        System.out.println("4: To declare a draw, type 'DRAW'.");
        System.out.println("5: To exit the game, type 'EXIT'.");

    }


}
