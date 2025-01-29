package com.chess.piece;

import com.chess.models.Board;
import com.chess.models.Color;
import com.chess.models.Movements;
import com.chess.models.Piece;
import com.chess.util.ErrorMessage;

public class Queen extends Piece {
    public Queen(int x, int y) {
        super("Queen", x, y,
                Movements.STAR,
                (x==7)?Color.WHITE:Color.BLACK);
    }

    public Queen(int x, int y, Color color) {
        super("Queen",x,y,Movements.STAR,color);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public ErrorMessage move(Board[][] board, Piece destination) {
        return  null;

    }
}
