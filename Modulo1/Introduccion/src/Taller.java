import java.util.Scanner;

public class Taller {
    public static void main(String[] args) {
        ejercicio();
    }

    public static void ejercicio() {
        var sc = new Scanner(System.in);
        int option;

        do {
            System.out.println("\n--- Analizador de números y secuencias ---\n");
            System.out.println("1. Analizar un número");
            System.out.println("2. Generar una secuencia de números");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            option = sc.nextInt();

            switch (option) {
                case 1:
                    System.out.println("Analizando un número...");
                    System.out.println("Ingrese un número entero: ");
                    int numero = sc.nextInt();

                    // Uso del operador ternario
                    String resultado1 = (numero < 0) ? "Negativo" : "Positivo";
                    System.out.printf("El número %d es %s.%n", numero, resultado1);
                    String resultado2 = (numero % 2 == 0) ? "Par" : "Impar";
                    System.out.printf("El número %d es %s.%n", numero, resultado2);
                    String resultado3 = (numero >= 100) ? "Mayor o igual a 100" : "Menor que 100";
                    System.out.printf("El número %d es %s.%n", numero, resultado3);
                    break;
                case 2:
                    System.out.println("Generando una secuencia de números...");
                    System.out.print("Ingrese el número inicial: ");

                    int inicio = sc.nextInt();
                    System.out.print("Ingrese el número final: ");

                    int fin = sc.nextInt();
                    System.out.print("Mostrar solo pares? (s/n): ");
                    char opcionPar = sc.next().charAt(0);
                    if (opcionPar == 's' || opcionPar == 'S') {
                        System.out.printf("Secuencia de números pares de %d a %d:%n", inicio, fin);
                        for (int i = inicio; i <= fin; i++) {
                            if (i % 2 == 0) {
                                System.out.print(i + " ");
                            }
                        }
                    } else {
                        System.out.printf("Secuencia de números impares de %d a %d:%n", inicio, fin);
                        for (int i = inicio; i <= fin; i++) {
                            if (i % 2 != 0) {
                                System.out.print(i + " ");
                            }
                        }
                    }
                    System.out.println("\nterminado.");
                    break;
                case 0:
                    System.out.println("Saliendo del programa. ¡Hasta luego!");
                default:
                    break;
            }
        } while (option != 0);

        sc.close();
    }
}
