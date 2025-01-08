package org.example.piece;

import org.example.models.*;

public class Pawn extends PieceModel  {

    public Pawn(int x, int y ) {
        super("Pawn", x, y,
                Movements.PAWN,
                (x==6)? Color.WHITE : Color.BLACK);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}


