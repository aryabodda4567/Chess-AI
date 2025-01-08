package com.chess.util;

import com.chess.Game;
import com.chess.models.GameOption;
import com.chess.models.Location;
import com.chess.models.Piece;
import com.chess.models.Square;
import com.chess.piece.Empty;

public class MoveValidator {

    static final int MAX =8;
    static final int MIN =0;



    public static  GameOption isPieceExist(Location sourceLocation,  Square[][] board){

        Piece sourcePiece  = board[sourceLocation.getX()][sourceLocation.getX()].getPiece();
        if(sourcePiece instanceof Empty) return GameOption.INVALID_MOVE;
        else return GameOption.VALID_MOVE;

    }


    public  static  GameOption validateCoordinates(Location sourceLocation, Location targetLocation){


        //Check the target and source are not same
        if(sourceLocation.equals(targetLocation)){
            return GameOption.INVALID_MOVE;
        }

        //Check coordinates
        if(sourceLocation.getX()<MAX && sourceLocation.getX()>=MIN &&
                sourceLocation.getY()<MAX && sourceLocation.getY()>=MIN &&
        targetLocation.getX()<MAX && targetLocation.getX()>=MIN
                && targetLocation.getY()<MAX && targetLocation.getY()>=MIN){
            return GameOption.VALID_MOVE;
        }
        else {
            return GameOption.INVALID_MOVE;
        }

    }
    public static  GameOption isSamePieceHit(Location sourceLocation, Location targetLocation, Square[][] board){


        //Check piece exists at the given location
        if(isPieceExist(sourceLocation,board).equals(GameOption.INVALID_MOVE)){
            return GameOption.INVALID_MOVE;
        }

        //Check coordinates
        if(validateCoordinates(sourceLocation, targetLocation)==GameOption.INVALID_MOVE){
            return GameOption.INVALID_MOVE;
        }

        //Check  source and target are same color
        if(board[sourceLocation.getX()][sourceLocation.getY()].getPiece().getColor().equals(
                board[targetLocation.getX()][targetLocation.getY()].getPiece().getColor()
        )){
            return GameOption.INVALID_MOVE;
        }
        return GameOption.VALID_MOVE;

    }

    public static Piece[] getPieces(Location sourceLocation, Location targetLocation,Square[][] board ){

        Piece[] pieces = new Piece[2];
        pieces[0] = board[sourceLocation.getX()][sourceLocation.getX()].getPiece();
        pieces[1] = board[targetLocation.getX()][targetLocation.getX()].getPiece();
        return pieces;
    }



}
