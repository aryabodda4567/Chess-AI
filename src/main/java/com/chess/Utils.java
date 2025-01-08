package com.chess;

import com.chess.models.GameOption;

public class Utils {

    public  static GameOption validateString(String gameOption){

        if(gameOption==null || gameOption.isEmpty()){
            return null;
        }
        return switch (gameOption) {
            case "START" -> GameOption.START;
            case "EXIT" -> GameOption.EXIT;
            case "DRAW" -> GameOption.DRAW;
            default -> GameOption.MOVE;
        };
    }
    public void  displayInstructions(){
        System.out.println("1: Each cell contains the name and color of the piece.");
        System.out.println("2: Empty cells do not contain any pieces.");
        System.out.println("3: To move a piece, enter the source location and the destination location.");
        System.out.println("   - Format: For example, 'c1 c5' means moving the piece from c1 to c5.");
        System.out.println("4: To declare a draw, type 'DRAW'.");
        System.out.println("5: To exit the game, type 'EXIT'.");

    }


    public static void clearScreen() {
        for(int i = 0; i < 100; i++) // Default Height of cmd is 300 and Default width is 80
            System.out.print("\n");
    }

    public  static  void  exitGame(){
        System.out.println("Game over.");

    }

    public static void   drawGame(){
        System.out.println("Draw game.");

    }

}
