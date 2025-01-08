package com.chess.piece;

import com.chess.models.Color;
import com.chess.models.Movements;
import com.chess.models.PieceModel;

public class Queen extends PieceModel {
    public Queen(int x, int y) {
        super("Queen", x, y,
                Movements.STAR,
                (x==7)?Color.WHITE:Color.BLACK);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
