package org.example.Service;

import org.example.Exception.DatosInvalidosException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ValidacionServiceTest {

    ValidacionService vs;

    @BeforeEach
    void setUp() {
        vs = new ValidacionService();
    }

    @Test
    void testvalidarNombrePaciente_incorrecto_null() {
        assertThrows(DatosInvalidosException.class, () -> vs.validarNombre(null));
    }

    @Test
    void testvalidarNombrePaciente_incorrecto_vacio() {
        assertThrows(DatosInvalidosException.class, () -> vs.validarNombre(""));
    }

    @Test
    void testvalidarNombrePaciente_correcto_nombre() {
        String nombrePaciente = "Paciente";
        assertDoesNotThrow(() -> vs.validarNombre(nombrePaciente));
    }
}
