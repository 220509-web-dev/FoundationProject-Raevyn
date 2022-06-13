package com.revature.foundations.Util.exceptions;

public class InvalidRequestException extends RuntimeException {

    public InvalidRequestException(String message) {
        super(message);
    }
public InvalidRequestException(String message, Throwable cause) {
        super(message, cause);
}
}
