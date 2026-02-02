public class Cuenta {
    private String numero;
    private double saldo;

    public Cuenta(String numero, double saldo) {
        this.numero = numero;
        this.saldo = saldo;
    }

    public String getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public void depositar(double monto) throws MontoInvalidoException {
        if (monto <= 0) {
            throw new MontoInvalidoException("El monto debe ser mayor que cero");
        }
        saldo += monto;
    }

    public void retirar(double monto) throws MontoInvalidoException, SaldoInsuficienteException {
        if (monto <= 0) {
            throw new MontoInvalidoException("El monto debe ser mayor que cero");
        }
        if (monto > saldo) {
            throw new SaldoInsuficienteException("Saldo insuficiente");
        }
        saldo -= monto;
    }
}
