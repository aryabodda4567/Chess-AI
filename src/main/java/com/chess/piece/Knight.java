package com.chess.piece;

import com.chess.models.Board;
import com.chess.models.Color;
import com.chess.models.Movements;
import com.chess.models.Piece;
import com.chess.util.ErrorMessage;

public class Knight extends Piece {

      public Knight(int x, int y) {
        super("Knight", x, y, Movements.L,
                (x==7)?Color.WHITE:Color.BLACK);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public ErrorMessage move(Board[][] board, Piece destination) {
        return  null;

    }
}
