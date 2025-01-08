package com.chess;

import com.chess.models.Color;
import com.chess.models.GameOption;
import com.chess.models.Square;

import java.util.Scanner;

public class Game {

    static  Square[][] board ;
    static Color currentColor;
    static String move;
    static int status;



    Game(Square[][] board){
        currentColor= Color.WHITE;
        Game.board = board;
    }


    public void startGame(){
        menu();
    }


    public  static  void menu(){
        Scanner scanner = new Scanner(System.in);
        Utils.clearScreen();
        Board.printBoard(board);
        System.out.println("Move "+ currentColor);
        move = scanner.nextLine();
        if(Game.validate()!=GameOption.MOVE) return;
        toggleColor();
        menu();
    }



     static GameOption validate(){
        switch (move) {
            case "EXIT" -> {
                System.out.println("Game exited by "+ currentColor);
                return GameOption.EXIT;
            }
            case "DRAW" -> {
                System.out.println("Game draw by "+ currentColor);
                return GameOption.DRAW;
            }
            case "START" -> {
                System.out.println("Game start by "+ currentColor);
                return GameOption.START;
            }
            default -> {
                return GameOption.MOVE;
            }
        }
    }









    public  static  void toggleColor(){
        if(getCurrentColor().equals(Color.BLACK)) currentColor = Color.WHITE;
        else currentColor = Color.BLACK;
    }


    public  static void setMove(String move) {
        Game.move = move;
    }

    public static void setCurrentColor(Color currentColor) {
        Game.currentColor = currentColor;
    }

    public  static Color getCurrentColor() {
        return currentColor;
    }

    public static String getMove() {
        return move;
    }
}
