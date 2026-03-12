import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestPrincipal {

    @Test
    public void nombreDelTest() {
        // 1. ARRANGE (Preparar): Configura los datos necesarios
        int numero1 = 5;
        int numero2 = 3;

        // 2. ACT (Actuar): Ejecuta el metodo que quieres probar
        int resultado = sumar(numero1, numero2);

        // 3. ASSERT (Verificar): Comprueba que el resultado es el esperado
        assertEquals(8, resultado);
    }

    private int sumar(int numero1, int numero2) {
        return numero1 + numero2;
    }
}
