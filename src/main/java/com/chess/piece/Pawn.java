package com.chess.piece;

import com.chess.models.*;
import com.chess.util.ErrorMessage;

import java.util.ArrayList;
import java.util.List;


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
        List<Location> possibleMoves ;
        int moves;

        if(isInitialMovement) moves=2;
        else moves=1;

        if(this.getColor().equals(Color.BLACK))  possibleMoves = getBlackValidMoves(board, destination,moves);
        else possibleMoves = getWhiteValidMoves(board,destination,moves);

        if(possibleMoves.contains(destLocation)){
             isInitialMovement=false;
            setCurrentLocation(destLocation);
            return new ErrorMessage(false,null);
        }else {
            return new ErrorMessage(true,"Invalid move");
        }
    }


    private List<Location> getWhiteValidMoves(Board[][] board, Piece destination, int moves) {

        List<Location> possibleMoves = new ArrayList<>();
        for (int i = getX(); i >= getX() + moves; i--) {
            if (Board.isEmpty(i, getY(), board)) {
                possibleMoves.add(new Location(i, this.getY()));
            } else break;
        }
        return possibleMoves;
    }


    private  List<Location> getBlackValidMoves(Board[][] board, Piece destination, int moves) {
        List<Location> possibleMoves = new ArrayList<>();
        for(int i= getX();i<=getX()+moves;i++ ){
            if(Board.isEmpty(i,destination.getY(),board)){
                possibleMoves.add(new Location(i,this.getY()));
            }else break;
        }
        return possibleMoves;
    }
}


