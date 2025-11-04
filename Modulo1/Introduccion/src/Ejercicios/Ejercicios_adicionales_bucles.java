package Ejercicios;

import java.util.Scanner;

public class Ejercicios_adicionales_bucles {
    public static void main(String[] args) {
        //numero_mayor();
        letraMayuscula();
    }

    /*
     * Escriba un programa que le permita ingresar tres números e imprima en la
     * consola el más grande de ellos.
     */
    public static void numero_mayor(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el número a analizar mayor a 1 cifra: ");
        int numero = sc.nextInt();
        int numero_mayor = 0;
        do{
            if(numero % 10 > numero_mayor){
                numero_mayor = numero % 10;
            }
            numero /= 10;
        }while(numero>0);
        System.out.println("El número mayor del número ingresado es: "+numero_mayor);
        sc.close();
    }

    public static void letraMayuscula(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese una letra: ");
        char letra = sc.next().charAt(0);
        if(letra >= 'A' && letra <= 'Z'){
            System.out.println("La letra ingresada es mayúscula.");
        }else{
            System.out.println("La letra ingresada no es mayúscula.");
        }
        sc.close();
    }
}
