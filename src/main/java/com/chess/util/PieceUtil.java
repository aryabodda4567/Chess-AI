package com.chess.util;

import com.chess.models.Board;
import com.chess.models.Location;
import com.chess.models.Piece;

public class PieceUtil {

    public static boolean isSameColorPiece(Piece piece1, Piece piece2) {
        return piece1.getColor().equals(piece2.getColor());
    }

    public  static boolean isSameColorPiece(Location sourcePiece, Location destinationPiece, Board[][] board){
            return isSameColorPiece(sourcePiece.getX(), sourcePiece.getY(), destinationPiece.getX(), destinationPiece.getY(), board);
    }

    public  static boolean isSameColorPiece(int sourceX,int sourceY, int destX, int destY, Board[][] board){

        return board[sourceX][sourceY].getPiece().getColor().equals(
                board[destX][destY].getPiece().getColor()
        );
    }
    public  static boolean isAtVerticalEnd(Piece piece){
        return piece.getCurrentLocation().getX() == 0 || piece.getCurrentLocation().getX() == 7;
    }
    public  static boolean isAtHorizontalEnd(Piece piece){
        return piece.getCurrentLocation().getY() == 0 || piece.getCurrentLocation().getY() == 7;
    }
}

