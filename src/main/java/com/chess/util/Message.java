package com.chess.util;

public class Message {
    boolean status;
    String message;
    boolean exit ;

    public Message(boolean status, String message) {
        this.status = status;
        this.message = message;
    }

    public Message(boolean exit) {
        this.exit = exit;
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
    public boolean isExit() {
        return exit;
    }
}
