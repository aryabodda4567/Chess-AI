package com.chess.util;

public class ErrorMessage {
    boolean status ;
    String message;

    public ErrorMessage(boolean status, String message) {
        this.status = status;
        this.message = message;
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
}
