package com.example.demo.exception;

/**
 * Created by loliveira on 16/11/18.
 */
public class DataIntegrityException extends RuntimeException {
    public DataIntegrityException(String msg) {
        super(msg);
    }
}
