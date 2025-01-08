package org.example.piece;

import org.example.models.Color;
import org.example.models.Movements;
import org.example.models.PieceModel;

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
