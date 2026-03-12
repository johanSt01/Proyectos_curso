package org.example.Service;

import org.example.Exception.DatosInvalidosException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ValidacionService {


    private static final Logger log = LoggerFactory.getLogger(ValidacionService.class);

    public void validarNombre(String nombre){
        if (nombre == null || nombre.isEmpty()){
            log.error("El nombre es obligatorio");
            throw new DatosInvalidosException("El nombre es obligatorio");
        }
    }

    public void validarTelefono(String telefono){
        if (telefono == null || telefono.isEmpty()){
            log.error("El telefono es obligatorio");
        }

        String soloDigitos = telefono.replaceAll("[\\s\\-]", "");
        boolean siTieneSoloDigitos = soloDigitos.matches("\\d+");

        if (!siTieneSoloDigitos){
            log.error("El telefono no tiene el formato esperado");
        }

        if (soloDigitos.length() < 8) {
            log.error("El telefono no tiene la cantidad de digitos esperada");
            throw new DatosInvalidosException("El telefono no tiene la cantidad de digitos esperada");
        }
    }
}
