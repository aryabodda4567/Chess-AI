package com.chess.piece;

import com.chess.models.Board;
import com.chess.models.Color;
import com.chess.models.Movements;
import com.chess.models.Piece;


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
    public void move(Board[][] board, Piece destination) {

    }
}


