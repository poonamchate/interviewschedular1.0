package com.interviewsystem.models.exceptions;

public class InvalidDataException extends RuntimeException {

    private String message;
    private String code;

    public InvalidDataException(String message, String code){
        super(message);
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
