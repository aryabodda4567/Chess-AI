package org.example.piece;

 import org.example.models.Color;
 import org.example.models.Movements;
 import org.example.models.PieceModel;

public class Empty extends PieceModel {
    public Empty(int x, int y) {
        super("Empty", x, y, Movements.NONE, Color.NONE);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
