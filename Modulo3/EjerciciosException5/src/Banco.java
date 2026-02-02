class Banco {
    private Cuenta cuenta1;
    private Cuenta cuenta2;

    public Banco(Cuenta c1, Cuenta c2) {
        this.cuenta1 = c1;
        this.cuenta2 = c2;
    }

    private Cuenta buscarCuenta(String numero) throws CuentaNoEncontradaException {
        if (cuenta1.getNumero().equals(numero)) {
            return cuenta1;
        }
        if (cuenta2.getNumero().equals(numero)) {
            return cuenta2;
        }
        throw new CuentaNoEncontradaException("Cuenta no encontrada");
    }

    public void transferir(String origen, String destino, double monto) {
        try {
            Cuenta cOrigen = buscarCuenta(origen);
            Cuenta cDestino = buscarCuenta(destino);

            cOrigen.retirar(monto);
            cDestino.depositar(monto);

            System.out.println("Transferencia realizada con éxito");

        } catch (CuentaNoEncontradaException | SaldoInsuficienteException | MontoInvalidoException e) {

            System.out.println("Error: " + e.getMessage());

        } finally {
            System.out.println("Transacción terminada\n");
        }
    }
}
