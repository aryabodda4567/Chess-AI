package com.chess.piece;

import com.chess.models.Board;
import com.chess.models.Color;
import com.chess.models.Movements;
import com.chess.models.Piece;
import com.chess.util.ErrorMessage;

public class Bishop extends Piece {

    public Bishop(int x, int y) {
        super("Bishop", x, y,
                Movements.DIAGONAL,
                (x==7)?Color.WHITE:Color.BLACK);
    }

    public Bishop(int x, int y, Color color) {
        super("Bishop",x,y,Movements.DIAGONAL,color);
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
