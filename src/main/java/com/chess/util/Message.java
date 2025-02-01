package com.chess.util;

import com.chess.models.GameOption;

public class Message {
    boolean status;
    String message;

    GameOption gameOption;

    public Message(boolean status, String message) {
        this.status = status;
        this.message = message;
    }

    public Message(GameOption gameOption) {
        this.gameOption = gameOption;
    }


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isError() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public GameOption getGameOption() {
        return gameOption;
    }
}
