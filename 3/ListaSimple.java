import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;


public class ListaSimple<T> implements Iterable<T> {

    private Nodo<T> cabeza;
    private Nodo<T> cola;
    private int tamaño;

    public boolean estaVacia() {
        return cabeza == null;
    }

    public int tamaño() {
        return tamaño;
    }



    public void insertarInicio(T dato) {
        Nodo<T> nuevo = new Nodo<>(dato);
        nuevo.siguiente = cabeza;
        cabeza = nuevo;

        if (cola == null) cola = nuevo;

        tamaño++;
    }

    public void insertarFinal(T dato) {
        Nodo<T> nuevo = new Nodo<>(dato);

        if (estaVacia()) {
            cabeza = cola = nuevo;
        } else {
            cola.siguiente = nuevo;
            cola = nuevo;
        }

        tamaño++;
    }

    public void insertarEn(int pos, T dato) {
        if (pos < 0 || pos > tamaño)
            throw new IndexOutOfBoundsException("Posición inválida: " + pos);

        if (pos == 0) {
            insertarInicio(dato);
            return;
        }

        if (pos == tamaño) {
            insertarFinal(dato);
            return;
        }

        Nodo<T> anterior = nodoEn(pos - 1);
        Nodo<T> nuevo = new Nodo<>(dato);

        nuevo.siguiente = anterior.siguiente;
        anterior.siguiente = nuevo;

        tamaño++;
    }



    public T eliminarInicio() {
        if (estaVacia()) throw new NoSuchElementException("Lista vacía");

        T dato = cabeza.dato;
        cabeza = cabeza.siguiente;

        if (cabeza == null) cola = null;

        tamaño--;
        return dato;
    }

    public T eliminarFinal() {
        if (estaVacia()) throw new NoSuchElementException("Lista vacía");

        if (tamaño == 1) return eliminarInicio();

        Nodo<T> penultimo = nodoEn(tamaño - 2);
        T dato = cola.dato;

        penultimo.siguiente = null;
        cola = penultimo;
        tamaño--;

        return dato;
    }

    public boolean eliminar(T dato) {
        if (estaVacia()) return false;

        if (Objects.equals(cabeza.dato, dato)) {
            eliminarInicio();
            return true;
        }

        Nodo<T> anterior = cabeza;

        while (anterior.siguiente != null
                && !Objects.equals(anterior.siguiente.dato, dato)) {
            anterior = anterior.siguiente;
        }

        if (anterior.siguiente == null) return false;

        if (anterior.siguiente == cola) cola = anterior;

        anterior.siguiente = anterior.siguiente.siguiente;
        tamaño--;

        return true;
    }



    public T obtener(int pos) {
        if (pos < 0 || pos >= tamaño)
            throw new IndexOutOfBoundsException("Posición inválida: " + pos);

        return nodoEn(pos).dato;
    }

    public int indiceDe(T dato) {
        int i = 0;

        for (Nodo<T> actual = cabeza;
             actual != null;
             actual = actual.siguiente, i++) {
            if (Objects.equals(actual.dato, dato)) return i;
        }

        return -1;
    }

    public boolean contiene(T dato) {
        return indiceDe(dato) != -1;
    }



    public void invertir() {
        Nodo<T> anterior = null, actual = cabeza;
        cola = cabeza;

        while (actual != null) {
            Nodo<T> siguiente = actual.siguiente;
            actual.siguiente = anterior;
            anterior = actual;
            actual = siguiente;
        }

        cabeza = anterior;
    }



    private Nodo<T> nodoEn(int pos) {
        if (pos < 0 || pos >= tamaño)
            throw new IndexOutOfBoundsException("Posición inválida: " + pos);

        Nodo<T> actual = cabeza;

        for (int i = 0; i < pos; i++)
            actual = actual.siguiente;

        return actual;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Nodo<T> actual = cabeza;

            @Override
            public boolean hasNext() {
                return actual != null;
            }

            @Override
            public T next() {
                if (actual == null)
                    throw new NoSuchElementException();

                T dato = actual.dato;
                actual = actual.siguiente;

                return dato;
            }
        };
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (T dato : this)
            sb.append(dato).append(" -> ");

        return sb.append("null").toString();
    }



    public static void main(String[] args) {

        ListaSimple<Integer> lista = new ListaSimple<>();

        lista.insertarFinal(20);
        lista.insertarFinal(30);
        lista.insertarInicio(10);
        lista.insertarEn(2, 25);

        System.out.println(lista);

        lista.eliminar(20);
        lista.eliminarFinal();

        System.out.println(lista);

        lista.invertir();

        System.out.println(lista);

        System.out.println(lista.indiceDe(10));
        System.out.println(lista.contiene(99));
        System.out.println(lista.tamaño());



        lista.eliminarInicio();
        lista.eliminarFinal();

        System.out.println(lista.estaVacia());

        lista.insertarFinal(7);

        System.out.println(lista);



        ListaSimple<String> nombres = new ListaSimple<>();

        nombres.insertarFinal("Ana");
        nombres.insertarFinal("Luis");

        for (String n : nombres)
            System.out.println(n);



        try {
            nombres.obtener(5);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}


class Nodo<T> {
    T dato;
    Nodo<T> siguiente;

    Nodo(T dato) {
        this.dato = dato;
        this.siguiente = null;
    }
}