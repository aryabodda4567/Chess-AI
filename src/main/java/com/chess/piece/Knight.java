package com.chess.piece;

import com.chess.models.Color;
import com.chess.models.Movements;
import com.chess.models.PieceModel;

public class Knight extends PieceModel {

      public Knight(int x, int y) {
        super("Knight", x, y, Movements.L,
                (x==7)?Color.WHITE:Color.BLACK);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
