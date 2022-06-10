package com.revature.foundations.Util.exceptions;

public class UsernameNotAvailable extends RuntimeException {

    public UsernameNotAvailable() {super(); }

    public UsernameNotAvailable (String message, Throwable cause, boolean enableSuppression,
                                 boolean writeableStackTrace) {
        super(message, cause, enableSuppression, writeableStackTrace);
    }

    public UsernameNotAvailable (String message, Throwable cause) { super(message, cause); }

    public UsernameNotAvailable (String message) { super(message); }

    public UsernameNotAvailable (Throwable cause) { super(cause); }


}
