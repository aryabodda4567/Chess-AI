package com.chess;

import com.chess.models.Board;
import com.chess.models.Color;
import com.chess.util.*;

import java.util.Scanner;

public class Main {


    //White start from [0][0]
    static Board[][] board = new Board[8][8];
    static Color currentColor = Color.WHITE;
    static int moveCounter = 0;





    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        Utils.init(board);
        BoardUtil.printBoard(board);
        Message message;
        String move;
        while (true) {
            System.out.print("Place " + currentColor + " Move. ");
            move = scanner.nextLine();
            message = Utils.validateMove(move,board,currentColor);

//            Check exit
            if(message.isExit()){
                break;
            }

//          Check move errors
            if (message.isError()) {
                System.out.println(message.getMessage());

            } else {
                currentColor = Utils.updateMove(currentColor);
                moveCounter++;

            }
            BoardUtil.printBoard(board);


        }


    }








}
