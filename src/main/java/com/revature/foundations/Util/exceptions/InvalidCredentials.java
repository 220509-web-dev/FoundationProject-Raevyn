package com.revature.foundations.Util.exceptions;

public class InvalidCredentials extends RuntimeException{

    public InvalidCredentials() {super(); }

    public InvalidCredentials (String message, Throwable cause, boolean enableSuppression,
                                 boolean writeableStackTrace) {
        super(message, cause, enableSuppression, writeableStackTrace);
    }

    public InvalidCredentials (String message, Throwable cause) { super(message, cause); }

    public InvalidCredentials (String message) { super(message); }

    public InvalidCredentials (Throwable cause) { super(cause); }

}
