package ua.com.jujaWebApp.exceptions;

public class ConnectionFailException extends Exception {
    private String message;

    public ConnectionFailException(String message) {
        this.message = message;
    }

    public String getMessage(){
        return message;
    }
}
