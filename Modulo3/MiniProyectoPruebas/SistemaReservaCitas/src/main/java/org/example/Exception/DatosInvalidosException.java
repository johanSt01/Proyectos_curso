package org.example.Exception;

public class DatosInvalidosException extends RuntimeException{
    public DatosInvalidosException(String mensaje){
        super(mensaje);
    }
}
