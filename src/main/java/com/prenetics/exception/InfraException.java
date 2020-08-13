package com.prenetics.exception;


@SuppressWarnings("serial")
public class InfraException extends Exception {
    public InfraException(String errorMessage) {
        super(errorMessage);
    }
}
