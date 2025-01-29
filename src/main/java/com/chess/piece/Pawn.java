package com.chess.piece;

import com.chess.models.*;
import com.chess.util.BoardUtil;
import com.chess.util.ErrorMessage;
import com.chess.util.PieceUtil;
import com.chess.util.Utils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class Pawn extends Piece {



    public Pawn(int x, int y ) {
        super("Pawn", x, y,
                Movements.PAWN,
                (x==6)? Color.WHITE : Color.BLACK);
    }



    @Override
    public String toString() {
        return super.toString();
    }


    @Override
    public ErrorMessage move(Board[][] board, Piece destination) {
        Location destLocation = destination.getCurrentLocation();


        Set<Location> possibleMoves ;
        int maxMoves=1;

        if(isInitialMovement) maxMoves=2;

        possibleMoves  = getValidMoves(destination,board,maxMoves);
        

//        No moves found
        if(possibleMoves.isEmpty()){
            return new ErrorMessage(true,"Now move for the selected piece");
        }

//        Valid move
        if(Utils.isValidDestinationInValidLocations(possibleMoves, destLocation)){
//            Set initial  move to false
            this.isInitialMovement=false;
//            Update pieces on board
        BoardUtil.setPieces(this,destination,board);

            return new ErrorMessage(false,null);
        }else{
            return new ErrorMessage(true,"Not a valid move");
        }










    }

    private  Set<Location> getValidMoves(Piece destination,Board[][] board,int maxMoves) {
        Set<Location> possibleMoves = new HashSet<>();

        int change = (this.getColor().equals(Color.BLACK)?1:-1);

        int X = this.getX()+change;
        int Y = this.getY();

//        Straight
        if(BoardUtil.isValidCoordinates(X,Y) && Board.isEmpty(X,Y,board)){
            possibleMoves.add(new Location(X,Y));
        }


//        Left kill
        if(BoardUtil.isValidCoordinates(X,Y-1) && !Board.isEmpty(X,Y-1,board)
                && !PieceUtil.isSameColorPiece(getX(),getY(),X,Y-1,board)){
        possibleMoves.add(new Location(X,Y-1));}

//        Right kill
        if(BoardUtil.isValidCoordinates(X,Y+1) && !Board.isEmpty(X,Y+1,board)
                && !PieceUtil.isSameColorPiece(getX(),getY(),X,Y+1,board)){
            possibleMoves.add(new Location(X,Y+1));}


//        Two steps
        if(maxMoves==2){
            change = (this.getColor().equals(Color.BLACK)?2:-2);
            X = this.getX()+change;
            Y = this.getY();

            if(BoardUtil.isValidCoordinates(X,Y) && Board.isEmpty(X,Y,board)){
                possibleMoves.add(new Location(X,Y));
            }
        }
        return possibleMoves;
    }








}


