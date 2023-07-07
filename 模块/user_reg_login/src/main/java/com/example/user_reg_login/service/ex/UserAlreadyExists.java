package com.example.user_reg_login.service.ex;

public class UserAlreadyExists extends RuntimeException{
    public UserAlreadyExists() {
        super();
    }

    public UserAlreadyExists(String message) {
        super(message);
    }

    public UserAlreadyExists(String message, Throwable cause) {
        super(message, cause);
    }

    public UserAlreadyExists(Throwable cause) {
        super(cause);
    }

    protected UserAlreadyExists(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
