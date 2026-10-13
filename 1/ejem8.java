import java.util.Scanner;

public class ejem8 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int[] arreglo = new int[5];
        int valor;
        int i;

        for (i = 0; i < arreglo.length; i++) {
            System.out.print("Número " + (i + 1) + ": ");
            valor = teclado.nextInt();
            arreglo[i] = valor;
        }

        for (i = 0; i < arreglo.length; i++) {
            System.out.println(arreglo[i]);
        }

        i = 0;
        while (i < arreglo.length) {
            System.out.print("Número " + (i + 1) + ": ");
            valor = teclado.nextInt();
            arreglo[i] = valor;
            i++;
        }

        i = 0;
        while (i < arreglo.length) {
            System.out.println(arreglo[i]);
            i++;
        }

        i = 0;
        while (true) {
            System.out.print("Número " + (i + 1) + ": ");
            valor = teclado.nextInt();
            arreglo[i] = valor;
            i++;
            if (i >= arreglo.length) {
                break;
            }
        }

        for (int elemento : arreglo) {
            System.out.println(elemento);
        }

        teclado.close();
    }
}