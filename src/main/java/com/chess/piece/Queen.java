package com.chess.piece;

import com.chess.models.Board;
import com.chess.models.Color;
import com.chess.models.Movements;
import com.chess.models.Piece;

public class Queen extends Piece {
    public Queen(int x, int y) {
        super("Queen", x, y,
                Movements.STAR,
                (x==7)?Color.WHITE:Color.BLACK);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public void move(Board[][] board, Piece destination) {

    }
}
