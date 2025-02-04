package com.chess;

import com.chess.ai.bridge.Chat;
import com.chess.ai.utils.Parser;
import com.chess.models.Square;
import com.chess.models.Color;
import com.chess.models.GameOption;
import com.chess.ui.BoardUI;
import com.chess.util.BoardUtil;
import com.chess.util.Message;
import com.chess.util.MoveUtil;
import com.chess.util.Utils;

import java.util.Scanner;

public class Main {


    //White start from [0][0]
    static Square[][] board = new Square[8][8];
    static Color currentColor = Color.WHITE;
    static int moveCounter = 0;


    public static void main(String[] args) {

        try {
            Scanner scanner = new Scanner(System.in);
            Utils.init(board);
            BoardUI boardUI = new BoardUI(board);
            boardUI.addToUI();
            boardUI.displayBoard();



//        System.out.println(Chat.getMove(Parser.parseBoardToString(board),currentColor.toString()));
            BoardUtil.printBoard(board);
//
//
//            while (true) {
//                System.out.print("Place " + currentColor + " Move. ");
//
//                String move = Chat.getMove(Parser.parseBoardToString(board),
//                        currentColor.toString());
//
//                System.out.println(move);
////            String move = scanner.nextLine();
//
//
////            Check move contains game option;
//                assert move != null;
//                if (MoveUtil.isGameOptions(move)) {
////                Get the game options
//                    GameOption gameOption = GameOption.getGameOption(move);
//
//                    if (gameOption != null) {
//                        if (gameOption.equals(GameOption.EXIT)) {
//                            System.out.println("Exiting...");
//                            break;
//                        } else if (gameOption.equals(GameOption.DRAW)) {
//                            System.out.println("Draw...");
//                            break;
//                        } else if (gameOption.equals(GameOption.LOSE)) {
//                            System.out.println("Lose...");
//                            break;
//                        } else if (gameOption.equals(GameOption.CHECKMATE)) {
//                            System.out.println("Checkmate...");
//                            break;
//                        } else if (gameOption.equals(GameOption.CHECK)) {
//                            System.out.println("Check...");
//                            move = move.toUpperCase();
//                            move = move.replace(GameOption.CHECK.toString(), "");
//                        }
//                    }
//                }
//                Message message = Utils.validateMove(move, board, currentColor);
////          Check move errors
//                if (message.isError()) {
//                    System.out.println(message.getMessage());
//                } else {
//                    currentColor = Utils.updateMove(currentColor);
//                    moveCounter++;
//
//                }
//                BoardUtil.printBoard(board);
//

//            }


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
