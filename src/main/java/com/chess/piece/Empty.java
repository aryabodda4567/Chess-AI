package com.chess.piece;

 import com.chess.models.Board;
 import com.chess.models.Color;
 import com.chess.models.Movements;
 import com.chess.models.Piece;

public class Empty extends Piece {
    public Empty(int x, int y) {
        super("Empty", x, y, Movements.NONE, Color.NONE);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public void move(Board[][] board, Piece destination) {

    }
}
