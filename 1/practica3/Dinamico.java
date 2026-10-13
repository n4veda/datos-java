package practica3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Dinamico {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        List<Datos> listaUsuarios = new ArrayList<>();

        System.out.print("Cuantos usuarios deseas capturar?: ");
        int cantidad = teclado.nextInt();
        teclado.nextLine(); 

      
        for (int i = 0; i < cantidad; i++) {
            System.out.println("\n--- Captura de usuario " + (i + 1) + " de " + cantidad + " ---");

            System.out.print("nombre: ");
            String nombre = teclado.nextLine();

            System.out.print("edad: ");
            int edad = teclado.nextInt();
            teclado.nextLine(); 

            System.out.print("correo: ");
            String correo = teclado.nextLine();

            listaUsuarios.add(new Datos(nombre, edad, correo));
        }

        System.out.println("\n==================================");
        System.out.println("  LISTA DE USUARIOS REGISTRADOSSSS  ");
        System.out.println("==================================");

        for (Datos u : listaUsuarios) {
            System.out.println("Nombre: " + u.getNombre());
            System.out.println("Edad:   " + u.getEdad());
            System.out.println("Correo: " + u.getCorreo());
            System.out.println("----------------------------------");
        }

        teclado.close();
    }
}