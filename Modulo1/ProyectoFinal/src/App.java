import java.util.Scanner;

public class App {

    static String nombreProducto;
    static Double precioUnitario;
    static int cantidadEnInventario;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;
        do {
            mostrarMenu();
            opcion = LeerEntero(sc, "Seleccione una opción: ");
            System.out.println();
            sc.nextLine(); // Limpiar el buffer
            switch (opcion) {
                case 1:
                    registrarNuevoProducto(sc);
                    break;
                case 2:
                    mostrarInformacionProducto();
                    break;
                case 3:
                    double valorTotal = calcularValorTotalInventario();
                    System.out.printf("El valor total del inventario es: %.2f\n", valorTotal);
                    break;
                case 4:
                    mostrarResumenCompleto();
                    break;
                case 5:
                    nombreProducto = null;
                    precioUnitario = 0.0;
                    cantidadEnInventario = 0;
                    System.out.println("Los datos del producto actual han sido borrados exitosamente.");
                    break;
                default:
                    break;
            }
        } while (opcion != 0);
        sc.close();
    }

    private static void mostrarResumenCompleto() {
        System.out.println("--- Resumen Completo del Producto ---");
        System.out.println("Nombre del producto: " + (nombreProducto != null ? nombreProducto : "No registrado"));
        System.out.println("Precio unitario: " + (precioUnitario != null ? precioUnitario : "No registrado"));
        System.out.println(
                "Cantidad en inventario: " + (cantidadEnInventario != 0 ? cantidadEnInventario : "No registrado"));
        double valorTotal = calcularValorTotalInventario();
        System.out.printf("Valor total del inventario: %.2f\n", valorTotal);
        String estodoStock = estadoStock();
        System.out.println("Estado del stock: " + estodoStock);
    }

    private static String estadoStock() {
        if (nombreProducto == null) {
            return "No hay ningún producto registrado.";
        } else if (cantidadEnInventario < 5) {
            return "Bajo";
        } else if (cantidadEnInventario <= 20) {
            return "Medio";
        } else {
            return "Alto";
        }
    }

    // Calcular valor total del inventario del producto actual
    static double calcularValorTotalInventario() {
        double valorTotal = 0;
        if (nombreProducto == null) {
            System.out.println("No hay ningún producto registrado.");
        } else {
            valorTotal = precioUnitario * cantidadEnInventario;
        }
        return valorTotal;
    }

    // Mostrar información del producto actual
    private static void mostrarInformacionProducto() {
        if (nombreProducto == null) {
            System.out.println("No hay datos de producto registrados actualmente..");
        } else {
            System.out.println("--- Información del Producto Actual ---");
            System.out.println("Nombre del producto: " + nombreProducto);
            System.out.println("Precio unitario: " + precioUnitario);
            System.out.println("Cantidad en inventario: " + cantidadEnInventario);
        }
    }

    // Registrar nuevo producto con validación de datos
    static void registrarNuevoProducto(Scanner sc) {
        if (validacionDatosRegistrados(sc)) {
            return;
        }
        nombreProducto = leerNombre(sc, "Ingrese el nombre del producto: ");
        precioUnitario = leerPrecio(sc, "Ingrese el precio unitario del producto: ");
        cantidadEnInventario = leerCantidad(sc, "Ingrese la cantidad en inventario del producto: ");
    }

    // Leer cantidad en inventario: entero mayor a 0
    static int leerCantidad(Scanner sc, String mensaje) {
        while (true) {
            System.out.print(mensaje);
            int cantidad = sc.nextInt();
            try {
                if (cantidad >= 0) {
                    return cantidad;
                }
                System.out.println("Error: la cantidad debe ser un entero mayor a 0.");
            } catch (NumberFormatException e) {
                System.out.println("Error: debe ingresar un número entero válido.");
            }
        }
    }

    // Leer precio unitario: número decimal mayor a 0
    static double leerPrecio(Scanner sc, String mensaje) {
        while (true) {
            System.out.print(mensaje);
            double precio = sc.nextDouble();
            try {
                if (precio > 0) {
                    return precio;
                }
                System.out.println("Error: el precio debe ser un número mayor a 0.");
            } catch (NumberFormatException e) {
                System.out.println("Error: debe ingresar un número válido.");
            }
        }
    }

    // Leer campo obligatorio para que no queden espacios vacíos
    static String leerNombre(Scanner sc, String mensaje) {
        String entrada;
        while (true) {
            System.out.print(mensaje);
            entrada = sc.nextLine().trim();
            if (!entrada.isEmpty()) {
                return entrada;
            }
            System.out.println("Error: este campo no puede quedar vacío. Intente nuevamente.");
        }
    }

    // Validación de datos registrados antes de sobreescribir
    static boolean validacionDatosRegistrados(Scanner sc) {
        if (nombreProducto != null) {
            System.out.println("Ya existe un producto registrado.\n¿Desea sobreescribir los datos?. (S/N)");
            String confirmacionSobreEscritura = sc.nextLine();
            if (confirmacionSobreEscritura.equalsIgnoreCase("S")) {
                return false;
            } else {
                return true;
            }
        }
        return false;
    }

    // Leer entero con mensaje personalizado
    static int LeerEntero(Scanner sc, String string) {
        int numero;
        System.out.print(string);
        numero = sc.nextInt();
        return numero;
    }

    // Mostrar menú de opciones
    static void mostrarMenu() {
        System.out.println("\n=== Sistema de Gestión de Productos ===\n");
        System.out.println("1. Registrar nuevo producto");
        System.out.println("2. Mostrar información del producto actual");
        System.out.println("3. Calcular valor total del inventario");
        System.out.println("4. Mostrar resumen completo del producto");
        System.out.println("5. Limpiar datos del producto actual");
        System.out.println("0. Salir");
    }
}
