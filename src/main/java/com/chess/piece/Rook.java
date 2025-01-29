package com.chess.piece;

import com.chess.models.*;
import com.chess.util.BoardUtil;
import com.chess.util.ErrorMessage;
import com.chess.util.PieceUtil;
import com.chess.util.Utils;

import java.lang.reflect.UndeclaredThrowableException;
import java.util.HashSet;
import java.util.Set;

public class Rook  extends Piece {
    public Rook(int x, int y) {
        super("Rook", x, y,
                Movements.PLUS,
                (x==7)?Color.WHITE:Color.BLACK);
    }

    public Rook(int x, int y, Color color) {
        super("Rook",x,y,Movements.PLUS,color);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public ErrorMessage move(Board[][] board, Piece destination) {
        Set<Location> possibleMoves;
        possibleMoves = getPossibleMoves(board, destination);

        if (possibleMoves.isEmpty()) {
            return new ErrorMessage(true,"No possible moves found");
        }

        if(Utils.isValidDestinationInValidLocations(possibleMoves,destination.getCurrentLocation())){
            BoardUtil.setPieces(this,destination,board);
            return new ErrorMessage(false,null);
        }
        else {
            return new ErrorMessage(true,"Invalid move");
        }


    }
    private Set<Location> getPossibleMoves(Board[][] board, Piece destination) {

        Set<Location> possibleMoves = new HashSet<>();
        int X ,Y;



        X = this.getX();
        Y = this.getY();

//        Horizontal left
        for(int i=Y-1;i>=0 ;i--){
//           Check if way  is empty
            if(Board.isEmpty(X,i,board)){
                possibleMoves.add(new Location(X,i));
                continue;
            }
//            Check if the way contains same color piece
            if(this.getColor().equals(board[X][i].getPiece().getColor())){
//                Don't add this location and exit from loop
                break;
            }else{
//              Encountered opposite color piece
                possibleMoves.add(new Location(X,i));
            }
            break;
        }

//        Horizontal right
        for(int i=Y+1;i<=7 ;i++){
             if(Board.isEmpty(X,i,board)){
                possibleMoves.add(new Location(X,i));
                continue;
            }
             if(this.getColor().equals(board[X][i].getPiece().getColor())){
                 break;
            }else{
                 possibleMoves.add(new Location(X,i));
            }
            break;

        }

//        Vertical top
        for (int i=X-1;i>=0;i--){
             if(Board.isEmpty(i,Y,board)){
                    possibleMoves.add(new Location(i,Y));
                    continue;
            }
             if(this.getColor().equals(board[i][Y].getPiece().getColor())){
                 break;
            }else{
                 possibleMoves.add(new Location(i,Y));
            }
        }

//        Vertical bottom
        for(int i=X+1;i<=7 ;i++){
            if(Board.isEmpty(i,Y,board)){
                possibleMoves.add(new Location(i,Y));
                continue;
            }
            if(this.getColor().equals(board[i][Y].getPiece().getColor())){
                break;
            }else{
                possibleMoves.add(new Location(i,Y));

            }
            break;
        }



        return possibleMoves;

    }


}


