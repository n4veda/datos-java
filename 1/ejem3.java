public class ejem3 {
    public void suma(int a, int b) {
        int c = a + b;
        System.out.println("La suma de " + a + " y " + b + " es: " + c);
    }
    public void suma(float a, float b) {
        float c = a + b;
        System.out.println("La suma de " + a + " y " + b + " es: " + c);
    }
    public void suma(double a, double b) {
        double c = a + b;
        System.out.println("La suma de " + a + " y " + b + " es: " + c);
    }

    public static void main(String[] args) {
        ejem3 obj = new ejem3();
        obj.suma(5, 10);
        obj.suma(5.5f, 10.5f);
        obj.suma(5.5, 10.5);
    }
}
