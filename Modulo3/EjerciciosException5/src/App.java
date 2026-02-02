public class App {
    public static void main(String[] args) {

        Cuenta c1 = new Cuenta("001", 500);
        Cuenta c2 = new Cuenta("002", 300);

        Banco banco = new Banco(c1, c2);

        banco.transferir("001", "002", 200);
        banco.transferir("001", "002", 300);
        banco.transferir("001", "002", 100);
        banco.transferir("001", "002", -10);

        System.out.println("Saldo final cuenta 001: " + c1.getSaldo());
        System.out.println("Saldo final cuenta 002: " + c2.getSaldo());
    }
}
