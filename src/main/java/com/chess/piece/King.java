package com.chess.piece;

import com.chess.models.Color;
import com.chess.models.Movements;
import com.chess.models.PieceModel;

public class King  extends PieceModel {

     public King(int x, int y) {
        super("King", x, y,
                Movements.SQUARE,
                (x==7)?Color.WHITE:Color.BLACK);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
