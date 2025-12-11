public class Empleado {
    private String nombre;
    private String id;
    private double salarioBase;

    public Empleado(String nombre, String id, double salarioBase) {
        this.nombre = nombre;
        this.id = id;
        this.salarioBase = salarioBase;
    }

    public String getNombre() {
        return nombre;
    }

    public String getId() {
        return id;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public double calcularSalario() {
        return salarioBase;
    }

    public void mostrarDetalles() {
        System.out.println("Empleado: " + nombre + ", ID: " + id + ", Salario Base: " + salarioBase);
    }

    public void mostrarDetalles(String prefijo){
        System.out.println(prefijo + " Empleado: " + nombre + ", ID: " + id + ", Salario Base: " + salarioBase);
    }
}
