public class EmpresaPOOApp {
    public static void main(String[] args) throws Exception {
        Gerente miGerente = new Gerente("Ana Gerente", "G001", 5000.0, 1000.0);
        Desarrollador miDesarrollador = new Desarrollador("Juan Dev", "D001", 4000.0, "Java");
        Empleado empleadoBase = new Empleado("Pedro Base", "E001", 3000.0);

        miGerente.mostrarDetalles();
        System.out.println("Salario Total Gerente: " + miGerente.calcularSalario());

        miDesarrollador.mostrarDetalles();
        System.out.println(
                "Salario Total Desarrollador (con bonus de proyecto 500): " + miDesarrollador.calcularSalario(500.0));

        empleadoBase.mostrarDetalles();
        System.out.println("Salario Total Empleado Base: " + empleadoBase.calcularSalario());

        empleadoBase.mostrarDetalles(); // Llama a mostrarDetalles() sin parámetro
        empleadoBase.mostrarDetalles("Detalles de Empleado Base:"); // Llama a mostrarDetalles(String)

        System.out.println("\n--- Demostración de Polimorfismo por Sobrescritura (Herencia) ---");
        Empleado ref1 = miGerente; // Referencia Empleado apunta a objeto Gerente
        Empleado ref2 = miDesarrollador; // Referencia Empleado apunta a objeto Desarrollador

        ref1.mostrarDetalles(); // Llama a la versión de Gerente en tiempo de ejecución
        System.out.println("Salario calculado para ref1: " + ref1.calcularSalario()); // Llama a la versión de Gerente
        ref2.mostrarDetalles(); // Llama a la versión de Desarrollador en tiempo de ejecución
        System.out.println("Salario calculado para ref2: " + ref2.calcularSalario()); // Llama a la versión de
                                                                                      // Desarrollador

        System.out.println("\n--- Demostración de Polimorfismo con Interfaces ---");
        Trabajable t1 = miGerente; // Referencia Trabajable apunta a objeto Gerente
        Trabajable t2 = miDesarrollador; // Referencia Trabajable apunta a objeto Desarrollador

        t1.trabajar(); // Llama a la implementación de Gerente
        t2.trabajar(); // Llama a la implementación de Desarrollador
    }
}
