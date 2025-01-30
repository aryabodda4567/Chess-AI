package com.chess.util;

import com.chess.models.Board;
import com.chess.models.Location;
import com.chess.models.Piece;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class MoveUtil {

    static HashMap<Character, Integer> colMap = new HashMap<>();
    static HashMap<Character, Integer> rowMap = new HashMap<>();

    static {
        colMap.put('A', 0);
        colMap.put('B', 1);
        colMap.put('C', 2);
        colMap.put('D', 3);
        colMap.put('E', 4);
        colMap.put('F', 5);
        colMap.put('G', 6);
        colMap.put('H', 7);
    }

    static {
        rowMap.put('1', 7);
        rowMap.put('2', 6);
        rowMap.put('3', 5);
        rowMap.put('4', 4);
        rowMap.put('5', 3);
        rowMap.put('6', 2);
        rowMap.put('7', 1);
        rowMap.put('8', 0);
    }

    ///      Parses move and validates move coordinates implicitly
    ///      null represents invalid move including invalid coordinates
    public static Location[] parseMove(String moves) {

        moves = moves.toUpperCase();
        String[] move = moves.split(" ");

        if (!isValidMoveString(move)) return null;

        String source = move[0];
        String destination = move[1];

        //Get source location
        int sourceY = colMap.get(source.charAt(0));
        int sourceX = rowMap.get(source.charAt(1));
        Location sorceLocation = new Location(sourceX, sourceY);

        //Get destination location
        int destinationY = colMap.get(destination.charAt(0));
        int destinationX = rowMap.get(destination.charAt(1));
        Location destinationLocation = new Location(destinationX, destinationY);


        //Return location
        return new Location[]{sorceLocation, destinationLocation};

    }

    private static boolean isValidMoveString(String[] move) {

        if (move.length != 2) return false;

        String source = move[0];
        String destination = move[1];

        if (source.length() != 2) return false;
        if (destination.length() != 2) return false;

        if (!colMap.containsKey(source.charAt(0))) return false;
        if (!rowMap.containsKey(source.charAt(1))) return false;

        if (!colMap.containsKey(destination.charAt(0))) return false;
        if (!rowMap.containsKey(destination.charAt(1))) return false;

        return true;


    }

    public static Set<Location> getHorizontalLeftMoves(int X, int Y, Board[][] board, Piece source) {
        Set<Location> moves = new HashSet<>();
        for (int i = Y - 1; i >= 0; i--) {
            if (Board.isEmpty(X, i, board)) {
                moves.add(new Location(X, i));
                continue;
            }
            if (source.getColor().equals(board[X][i].getPiece().getColor())) {
                break;
            } else {
                moves.add(new Location(X, i));
            }
            break;
        }
        return moves;
    }

    public static Set<Location> getHorizontalRightMoves(int X, int Y, Board[][] board, Piece source) {
        Set<Location> moves = new HashSet<>();
        for (int i = Y + 1; i <= 7; i++) {
            if (Board.isEmpty(X, i, board)) {
                moves.add(new Location(X, i));
                continue;
            }
            if (source.getColor().equals(board[X][i].getPiece().getColor())) {
                break;
            } else {
                moves.add(new Location(X, i));
            }
            break;
        }
        return moves;
    }

    public static Set<Location> getVerticalTopMoves(int X, int Y, Board[][] board, Piece source) {
        Set<Location> moves = new HashSet<>();
        for (int i = X - 1; i >= 0; i--) {
            if (Board.isEmpty(i, Y, board)) {
                moves.add(new Location(i, Y));
                continue;
            }
            if (source.getColor().equals(board[i][Y].getPiece().getColor())) {
                break;
            } else {
                moves.add(new Location(i, Y));
            }
        }
        return moves;
    }

    public static Set<Location> getVerticalBottomMoves(int X, int Y, Board[][] board, Piece source) {
        Set<Location> moves = new HashSet<>();
        for (int i = X + 1; i <= 7; i++) {
            if (Board.isEmpty(i, Y, board)) {
                moves.add(new Location(i, Y));
                continue;
            }
            if (source.getColor().equals(board[i][Y].getPiece().getColor())) {
                break;
            } else {
                moves.add(new Location(i, Y));
            }
            break;
        }
        return moves;
    }



    public static  Set<Location> getDiagonalTopLeftMoves(int X, int Y, Board[][] board, Piece source) {
//        i-1,j-1
        Set<Location> moves = new HashSet<>();

        X= X-1;
        Y = Y-1;
        while (!PieceUtil.isDiagonalEnd(X, Y)) {
            if(Board.isEmpty(X,Y,board)) {
                moves.add(new Location(X,Y));
                X--;
                Y--;
                continue;
            }

            if(source.getColor().equals(board[X][Y].getPiece().getColor())) {
                break;
            }
            else{
                moves.add(new Location(X,Y));
            }
            break;
        }

        for (Location location : moves) {
            System.out.println(location);
        }


        return moves;
    }




    public static  Set<Location> getDiagonalTopRightMoves(int X, int Y, Board[][] board, Piece source) {
//        i-1,j+1
        Set<Location> moves = new HashSet<>();

        X= X-1;
        Y=Y+1;
        while (!PieceUtil.isDiagonalEnd(X, Y)){
            if(Board.isEmpty(X, Y, board)) {
                moves.add(new Location(X, Y));
                X--;
                Y++;
                continue;
            }

            if(source.getColor().equals(board[X][Y].getPiece().getColor())) {
                break;
            }
            else
                moves.add(new Location(X, Y));
            break;

        }



        return moves;
    }

    public static Set<Location> getDiagonalBottomLeftMoves(int X, int Y, Board[][] board, Piece source) {
//i+1,j-1
        Set<Location> moves = new HashSet<>();

        X = X+1;
        Y = Y-1;
        while (!PieceUtil.isDiagonalEnd(X, Y)){
            if(Board.isEmpty(X, Y, board)) {
                moves.add(new Location(X, Y));
                X++;
                Y--;
                continue;
            }
            if(source.getColor().equals(board[X][Y].getPiece().getColor())) {
                break;
            }
            else{
                moves.add(new Location(X, Y));
            }
            break;
        }

        return moves;
    }
    public static Set<Location> getDiagonalBottomRightMoves(int X, int Y, Board[][] board, Piece source) {
//i+1,j+1
        Set<Location> moves = new HashSet<>();
        X= X+1;
        Y=Y+1;
        while (!PieceUtil.isDiagonalEnd(X, Y)){
            if(Board.isEmpty(X, Y, board)) {
                moves.add(new Location(X, Y));
                X++;
                Y++;
                continue;
            }
            if(source.getColor().equals(board[X][Y].getPiece().getColor())) {
                break;
            }
            else{
                moves.add(new Location(X, Y));
            }
            break;
        }

        return moves;
    }




}
