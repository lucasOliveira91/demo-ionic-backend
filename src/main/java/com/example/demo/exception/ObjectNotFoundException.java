package com.example.demo.exception;

/**
 * Created by loliveira on 16/11/18.
 */
public class ObjectNotFoundException extends RuntimeException {
    public ObjectNotFoundException(String msg) {
        super(msg);
    }
}
