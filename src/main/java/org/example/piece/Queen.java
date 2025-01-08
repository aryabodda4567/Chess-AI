package org.example.piece;

import org.example.models.Color;
import org.example.models.Movements;
import org.example.models.PieceModel;

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
