package org.example.piece;

import org.example.models.Color;
import org.example.models.Movements;
import org.example.models.PieceModel;

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
