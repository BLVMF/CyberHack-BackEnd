package com.cyberhack.jwt.exceptions;

public class UserAlreadyRegisteredException extends RuntimeException {
    public UserAlreadyRegisteredException(String message) {
        super(message);
    }
}