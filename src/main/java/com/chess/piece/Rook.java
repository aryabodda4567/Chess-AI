package com.chess.piece;

import com.chess.models.Board;
import com.chess.models.Color;
import com.chess.models.Movements;
import com.chess.models.Piece;
import com.chess.util.ErrorMessage;

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
    return  null;
    }
}


