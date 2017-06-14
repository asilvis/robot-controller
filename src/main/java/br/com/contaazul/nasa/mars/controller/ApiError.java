package br.com.contaazul.nasa.mars.controller;

/**
 * Created by maveco on 14/06/17.
 */
public class ApiError {

    private String message;

    public ApiError(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
