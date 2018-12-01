package com.example.demo.exception;

/**
 * Created by loliveira on 16/11/18.
 */
public class AuthorizationException extends RuntimeException {
    public AuthorizationException(String msg) {
        super(msg);
    }
}
