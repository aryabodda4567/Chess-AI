package com.chess;

import com.chess.models.Color;
import com.chess.models.GameOption;
import com.chess.models.Location;
import com.chess.models.Square;
import com.chess.util.MoveParser;
import com.chess.util.Utils;

import java.util.Scanner;

public class Game {

    Square[][] board ;
    Color currentColor;
    String move;
    int status;
    boolean isWrongMove = false;
    Location sourceLocation;
    Location targetLocation;
    Scanner scanner ;



    Game(Square[][] board){
        currentColor= Color.WHITE;
        this.board = board;
        scanner = new Scanner(System.in);
    }


    public void startGame(){
        menu();
    }


    public void menu(){


        Board.printBoard(board);

        //Check any wrong move in previous
        if(isWrongMove){
            Utils.printInvalidMove(currentColor+" is not a valid move");
            isWrongMove = false;
        }


        System.out.println("Move "+ currentColor);
        move = scanner.nextLine();


        //check EXIT Conditions
        if(validate(move)!=GameOption.MOVE)  System.exit(0);

        //Extract source and destination location from move
        if(!extractLocation(move))  {
             isWrongMove = true;
             menu();
        }




        //Next run
        toggleColor();
        Utils.clearScreen();
        menu();
    }



      GameOption validate(String move){
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

    boolean validateMove(){
        return false;
    }

    boolean extractLocation(String move){
        Location[]  locations =MoveParser.parseMove(move);
        if(locations==null){
            return false;
        }

        sourceLocation = locations[0];
        targetLocation = locations[1];
        return true;
    }














    public  void toggleColor(){
        if(getCurrentColor().equals(Color.BLACK)) currentColor = Color.WHITE;
        else currentColor = Color.BLACK;
    }


    public   void setMove(String move) {
        this.move = move;
    }

    public  void setCurrentColor(Color currentColor) {
        this.currentColor = currentColor;
    }

    public  Color getCurrentColor() {
        return currentColor;
    }

    public  String getMove() {
        return move;
    }
}
