package com.chess.util;

import com.chess.models.Board;
import com.chess.models.Piece;
import com.chess.piece.*;


public  class BoardUtil {



    public  static Piece setPiece(int i, int j) {
        Piece piece = null;
        if (i == 7 ||  i== 0) {
            piece = switch (j) {
                case 0, 7 -> new Rook(i, j);
                case 1, 6 -> new Knight(i, j);
                case 2, 5 -> new Bishop(i, j);
                case 4 -> new King(i, j);
                case 3 -> new Queen(i, j);
                default -> piece;
            };
        }else {
            piece = new Pawn(i, j);
        }
        return piece;
    }




    public static void printBoard(Board[][] board) {
        int size = 15;
        int rows =8;
        char[] cols = {'A','B','C','D','E','F','G','H'};
        for (int i = 0; i < 8; i++, rows--) {
            if(i==0) System.out.println("-".repeat((size + 5) * 8));
            for (int j = 0; j < 8; j++) {
                String data = board[i][j].getPiece().display();
                int sizeDifference = size - data.length();
                //Vertical 123
                if(j==0) System.out.print(rows);
                System.out.print(" ".repeat(3) + "|");
                System.out.print(" ".repeat(sizeDifference) + data);
                if (j == 7) System.out.print(" ".repeat(3) + "|");
            }
            System.out.println(" ");
            System.out.println("-".repeat((size + 5) * 8));
        }

        //Horizontal ABC
        for (int j = 0; j < 8; j++) {
            String data = cols[j]+"";
            int sizeDifference = size - data.length();
            System.out.print(" ".repeat(3)  );
            System.out.print(" ".repeat(sizeDifference) + data);
        }
        System.out.println();

    }
}