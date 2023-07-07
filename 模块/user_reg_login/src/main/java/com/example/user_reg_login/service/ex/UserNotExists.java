package com.example.user_reg_login.service.ex;

public class UserNotExists extends RuntimeException{
    public UserNotExists() {
        super();
    }

    public UserNotExists(String message) {
        super(message);
    }

    public UserNotExists(String message, Throwable cause) {
        super(message, cause);
    }

    public UserNotExists(Throwable cause) {
        super(cause);
    }

    protected UserNotExists(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
