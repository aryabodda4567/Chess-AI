package com.chess.piece;

import com.chess.models.Color;
import com.chess.models.Movements;
import com.chess.models.PieceModel;

public class Rook  extends PieceModel {
    public Rook(int x, int y) {
        super("Rook", x, y,
                Movements.PLUS,
                (x==7)?Color.WHITE:Color.BLACK);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}


