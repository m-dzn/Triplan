package com.triplan.exception;

public class AccessNotAllowedException extends RuntimeException {

    public AccessNotAllowedException() { }

    public AccessNotAllowedException(String msg) {
        super(msg);
    }

}
