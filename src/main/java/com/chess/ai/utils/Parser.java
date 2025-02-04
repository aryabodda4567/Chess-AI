package com.chess.ai.utils;

import com.chess.models.Square;
import com.chess.models.Color;
import com.chess.piece.Empty;

import java.util.HashMap;
import java.util.Map;


public class Parser {
    private static final Map<Integer, Character> colMap = new HashMap<>();
    private static final Map<Integer, Character> rowMap = new HashMap<>();

    static {
        // Original column map: A-H -> 0-7
        colMap.put(0, 'A');
        colMap.put(1, 'B');
        colMap.put(2, 'C');
        colMap.put(3, 'D');
        colMap.put(4, 'E');
        colMap.put(5, 'F');
        colMap.put(6, 'G');
        colMap.put(7, 'H');
    }

    static {
        // Original row map: 1-8 -> 7-0
        rowMap.put(7, '1');
        rowMap.put(6, '2');
        rowMap.put(5, '3');
        rowMap.put(4, '4');
        rowMap.put(3, '5');
        rowMap.put(2, '6');
        rowMap.put(1, '7');
        rowMap.put(0, '8');
    }

    public static String parseBoardToString(Square[][] board) {

//        Black names represented by uppercase letters and
//        White by lowercase letters

        StringBuilder parseString = new StringBuilder();
        parseString.append("[ ");
        for (Square[] boards : board) {
            for (Square value : boards) {
                if (!(value.getPiece() instanceof Empty)) {
                    String name;
                    String position;
                    if (value.getPiece().getColor().equals(Color.BLACK)) {
                        name = value.getPiece().getName().toUpperCase();
                    } else {
                        name = value.getPiece().getName().toLowerCase();
                    }
                    position = getPosition(value.getPiece().getX(), value.getPiece().getY());
                    parseString.append("{ ").append("piece: ").append(name).append(',')
                            .append(" position: ").append(position).append(" }").append(',');
                }
            }
        }
        parseString.append(" ]");
        parseString.replace(parseString.toString().length() - 3, parseString.toString().length() - 2, "");
        return parseString.toString();


    }

    public static String getPosition(int x, int y) {
        return colMap.get(y) + "" + rowMap.get(x);
    }
}
