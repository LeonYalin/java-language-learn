package com.leony.home;

public class StudentException extends Exception {
    public StudentException(String reason) {
        super(reason);
    }

    public StudentException(String reason, Throwable throwable) {
        super(reason, throwable);
    }
}
