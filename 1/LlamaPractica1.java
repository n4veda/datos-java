public class LlamaPractica1 {
    public static void main(String[] args) {
        Practica1<String, String> ejem1 = new Practica1<>("Hola", "Mundo");
        ejem1.verificatipo();

        Practica1<Integer, Integer> ejem2 = new Practica1<>(30, 40);
        ejem2.verificatipo();
        Practica1<Double, Double> ejem3 = new Practica1<>(3.08, 7.56);
        ejem3.verificatipo();

        Practica1<Boolean, Boolean> ejem4 = new Practica1<>(true, false);
        ejem4.verificatipo();

        Practica1<Character, Character> ejem5 = new Practica1<>('B', 'C');
        ejem5.verificatipo();

        Practica1<Float, Float> ejem6 = new Practica1<>(6.6f, 6.5f);
        ejem6.verificatipo();
    }
}