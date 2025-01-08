package com.chess.piece;

import com.chess.models.Color;
import com.chess.models.Movements;
import com.chess.models.PieceModel;

public class Bishop extends PieceModel {

    public Bishop(int x, int y) {
        super("Bishop", x, y,
                Movements.DIAGONAL,
                (x==7)?Color.WHITE:Color.BLACK);
    }

    @Override
    public String toString() {
        return super.toString();
    }

}
