import java.util.Scanner;

public class proyectobinomio {

    public static double binomioSumaCubo(double x, double y) {
        return Math.pow(x, 3) + 3 * Math.pow(x, 2) * y + 3 * x * Math.pow(y, 2) + Math.pow(y, 3);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese x: ");
        double x = scanner.nextDouble();

        System.out.print("Ingrese y: ");
        double y = scanner.nextDouble();

        double resultado = binomioSumaCubo(x, y);

        System.out.println("(x + y)^3 = x^3 + 3x^2y + 3xy^2 + y^3");
        System.out.println("Con x = " + x + " y = " + y + ":");
        System.out.println("Resultado = " + resultado);

        scanner.close();
    }
}
