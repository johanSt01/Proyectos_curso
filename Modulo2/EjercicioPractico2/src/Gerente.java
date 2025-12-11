public class Gerente extends Empleado implements Trabajable {
    private double bonoAnual;

    public Gerente(String nombre, String id, double salarioBase, double bonoAnual) {
        super(nombre, id, salarioBase);
        this.bonoAnual = bonoAnual;
    }

    public double getBonoAnual() {
        return bonoAnual;
    }

    @Override
    public double calcularSalario() {
        return getSalarioBase() + bonoAnual;
    }

    @Override
    public void mostrarDetalles() {
        super.mostrarDetalles();
        System.out.println("Bono: " + bonoAnual);
    }

    @Override
    public void mostrarDetalles(String prefijo) {
        super.mostrarDetalles(prefijo);
        System.out.println(prefijo + " Bono: " + bonoAnual);
    }

    @Override
    public void trabajar() {
        System.out.println(getNombre() + " está gestionando el equipo y supervisando proyectos.");
    }

}
