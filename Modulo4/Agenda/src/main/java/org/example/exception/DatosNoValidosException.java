package org.example.exception;

public class DatosNoValidosException extends RuntimeException {
    public DatosNoValidosException(String message) {
        super(message);
    }
}
