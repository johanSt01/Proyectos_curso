import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese su nombre de usuario de Instagram:");
        String userName = sc.nextLine();

        System.out.println("Ingrese su biografía:");
        String bio = sc.nextLine();

        PerfilInstagram miPerfil = new PerfilInstagram(userName, bio);
        miPerfil.follow();
        System.out.println(miPerfil.toString());

        sc.close();
    }
}
