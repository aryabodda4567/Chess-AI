package com.chess.util;

import com.chess.models.Piece;

public class PieceUtil {

    public static boolean isSamePiece(Piece piece1, Piece piece2) {
        return piece1.getColor().equals(piece2.getColor());
    }
}
