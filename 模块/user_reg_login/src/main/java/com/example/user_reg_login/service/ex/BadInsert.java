package com.example.user_reg_login.service.ex;

public class BadInsert extends RuntimeException{
    public BadInsert() {
        super();
    }

    public BadInsert(String message) {
        super(message);
    }

    public BadInsert(String message, Throwable cause) {
        super(message, cause);
    }

    public BadInsert(Throwable cause) {
        super(cause);
    }

    protected BadInsert(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
