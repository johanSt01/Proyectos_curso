public class Desarrollador extends Empleado implements Trabajable {
    private String lenguajePrincipal;

    public Desarrollador(String nombre, String id, double salarioBase, String lenguajePrincipal) {
        super(nombre, id, salarioBase);
        this.lenguajePrincipal = lenguajePrincipal;
    }

    public String getLenguajePrincipal() {
        return lenguajePrincipal;
    }

    public double calcularSalario(double bonusPorProyecto) {
        return getSalarioBase() + bonusPorProyecto;
    }

    @Override
    public double calcularSalario() {
        return getSalarioBase();
    }

    @Override
    public void mostrarDetalles() {
        super.mostrarDetalles();
        System.out.println("Lenguaje Principal: " + lenguajePrincipal);
    }

    @Override
    public void mostrarDetalles(String prefijo) {
        super.mostrarDetalles(prefijo);
        System.out.println(prefijo + " Lenguaje Principal: " + lenguajePrincipal);
    }

    @Override
    public void trabajar() {
        System.out.println(getNombre() + " está escribiendo código en " + lenguajePrincipal + ".");
    }

}
