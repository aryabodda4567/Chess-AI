package org.example.piece;

import org.example.models.Color;
import org.example.models.Movements;
import org.example.models.PieceModel;

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
