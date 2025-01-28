package com.chess;

import com.chess.models.Board;
import com.chess.models.Location;
import com.chess.models.Piece;
import com.chess.piece.Empty;
import com.chess.util.BoardUtil;
import com.chess.util.ErrorMessage;
import com.chess.util.MoveUtil;
import com.chess.util.PieceUtil;

import java.util.Scanner;

import static com.chess.util.BoardUtil.*;

public class Main {


    //White start from [0][0]
  static   Board[][]  board = new Board[8][8];






    public static   void init(){
        // Assign white
        for(int i=0;i<2;i++){
            for(int j=0;j<8;j++){
                 board[i][j] = new Board(i,j,setPiece(i,j));
            }
        }
        // Assign Black
        for(int i=7;i>=6;i--){
            for(int j=0;j<8;j++){
                board[i][j] = new Board(i,j,setPiece(i,j));
            }
        }
        // Assign Empty
        for (int i=2;i<6;i++){
            for (int j=0;j<8;j++){
                board[i][j] = new Board(i,j,new Empty(i,j));
            }
        }
     }






    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
         init();
         BoardUtil.printBoard(board);
         ErrorMessage errorMessage;
         String move;
         while (true){
             move = scanner.nextLine();
             errorMessage =validateMove(move);
             if (errorMessage.isError()){
                System.out.println(errorMessage.getMessage());
                continue;
             }
             System.out.println(move);


         }









        }

        private static ErrorMessage validateMove(String move){

//        Get locations from user moves
            Location[] locations = MoveUtil.parseMove(move);
            if(locations==null){
                return  new ErrorMessage(true,"Invalid Move or wrong source or destination locations ");
            }

//           Check whether the two pieces are of same color
            Piece sourcePiece = board[locations[0].getX()][locations[0].getY()].getPiece();
            Piece destinationPiece = board[locations[1].getX()][locations[1].getY()].getPiece();
            if(PieceUtil.isSamePiece(sourcePiece,destinationPiece)){
                return  new ErrorMessage(true,"You can't hit your piece");
            }


//
            sourcePiece.move(board,destinationPiece);





        }

    }
