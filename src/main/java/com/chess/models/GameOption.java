package com.chess.models;

public enum GameOption {
    EXIT,
    START,
    DRAW,
    WIN,
    LOSE,
    CHECK,
    CHECKMATE;

    public static GameOption getGameOption(String move) {

         move = move.toUpperCase().trim();
         String[] words = move.split(" ");
         if(words.length < 3) {

             if(words.length == 0) return null;

             if(words[0].equals(GameOption.EXIT.toString())) return EXIT;
             if(words[0].equals(GameOption.DRAW.toString())) return DRAW;
             if(words[0].equals(GameOption.LOSE.toString())) return WIN;
         }

         move = words[2];
        for (GameOption gameOption : values()) {
            if (gameOption.toString().equals(move)) {
                return gameOption;
            }
        }
        return null;
    }
}
