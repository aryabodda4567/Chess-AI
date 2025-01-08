package com.chess.piece;

 import com.chess.models.Color;
 import com.chess.models.Movements;
 import com.chess.models.PieceModel;

public class Empty extends PieceModel {
    public Empty(int x, int y) {
        super("Empty", x, y, Movements.NONE, Color.NONE);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
