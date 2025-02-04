package com.chess.piece;

import com.chess.models.*;
import com.chess.ui.UiUtil;
import com.chess.util.BoardUtil;
import com.chess.util.Message;
import com.chess.util.PieceUtil;
import com.chess.util.Utils;

import java.util.*;


public class Pawn extends Piece {


    public Pawn(int x, int y) {
        super("Pawn", x, y,
                Movements.PAWN,
                (x == 6) ? Color.WHITE : Color.BLACK);
    }


    @Override
    public String toString() {
        return super.toString();
    }


    @Override
    public Message move(Square[][] board, Piece destination) {
        Location destLocation = destination.getCurrentLocation();


        Set<Location> possibleMoves;
        int maxMoves = 1;

        if (isInitialMovement) maxMoves = 2;

        possibleMoves = getValidMoves(board, maxMoves);


//        No moves found
        if (possibleMoves.isEmpty()) {
            return new Message(true, "No possible moves found");
        }

//        Valid move
        if (Utils.isValidDestinationInValidLocations(possibleMoves, destLocation)) {
//            Set initial  move to false
            this.isInitialMovement = false;
//            Update pieces on board
            BoardUtil.setPieces(this, destination, board);


//        Check if the pawn has to be promoted
            if (PieceUtil.isAtVerticalEnd(this)) {
                promote(board);
            }

            return new Message(false, null);
        } else {
            return new Message(true, "Not a valid move");
        }


    }

    private void promote(Square[][] board) {
        Piece piece = getPromotedPiece();
        assert piece != null;
//        BoardUtil.setPieces(piece, this, board);
        BoardUtil.setPiece(piece,board,getX(),getY());
    }

    private Piece getPromotedPiece() {
        Map<String,Integer> options = new HashMap<>();

        options.put("Queen", 1);
        options.put("Knight", 2);
        options.put("Bishop", 3);
        options.put("Rook", 4);



        Scanner scanner = new Scanner(System.in);
        System.out.println("Pawn promotion");
        System.out.println("1: Queen\n2: Knight\n3: Bishop\n4: Rook");
        String input = UiUtil.showPromotionDialog(getColor());
        System.out.println(input);
        int option = options.get( input);
        System.out.println(option);
        return switch (option) {
            case 1 -> new Queen(this.getX(), this.getY(), this.getColor());
            case 2 -> new Knight(this.getX(), this.getY(), this.getColor());
            case 3 -> new Bishop(this.getX(), this.getY(), this.getColor());
            case 4 -> new Rook(this.getX(), this.getY(), this.getColor());
            default -> null;
        };
    }

    private Set<Location> getValidMoves(Square[][] board, int maxMoves) {
        Set<Location> possibleMoves = new HashSet<>();

        int change = (this.getColor().equals(Color.BLACK) ? 1 : -1);

        int X = this.getX() + change;
        int Y = this.getY();

//        Straight
        if (BoardUtil.isValidCoordinates(X, Y) && Square.isEmpty(X, Y, board)) {
            possibleMoves.add(new Location(X, Y));
        }


//        Left kill
        if (BoardUtil.isValidCoordinates(X, Y - 1) && !Square.isEmpty(X, Y - 1, board)
                && !PieceUtil.isSameColorPiece(getX(), getY(), X, Y - 1, board)) {
            possibleMoves.add(new Location(X, Y - 1));
        }

//        Right kill
        if (BoardUtil.isValidCoordinates(X, Y + 1) && !Square.isEmpty(X, Y + 1, board)
                && !PieceUtil.isSameColorPiece(getX(), getY(), X, Y + 1, board)) {
            possibleMoves.add(new Location(X, Y + 1));
        }


//        Two steps
        if (maxMoves == 2) {
            change = (this.getColor().equals(Color.BLACK) ? 2 : -2);
            X = this.getX() + change;
            Y = this.getY();

            if (BoardUtil.isValidCoordinates(X, Y) && Square.isEmpty(X, Y, board)) {
                possibleMoves.add(new Location(X, Y));
            }
        }
        return possibleMoves;
    }


}


