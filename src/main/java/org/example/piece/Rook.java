package org.example.piece;

import org.example.models.Color;
import org.example.models.Movements;
import org.example.models.PieceModel;

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


