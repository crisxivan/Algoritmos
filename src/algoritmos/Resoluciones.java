package algoritmos;

import java.util.ArrayList;
import java.util.Random;
import Grafos.Grafo;
import algoritmosNoElementales.MergeSort;
import algoritmosNoElementales.ShellSort;
import algoritmosNoElementales.QuickSort;

public class Resoluciones {

    public static void main(String[] args) {
        // Prueba de algoritmos de ordenamiento
        pruebaAlgoritmosOrdenamiento();

        // Prueba de algoritmos de grafos
        pruebaAlgoritmosGrafos();
    }

    private static void pruebaAlgoritmosGrafos() {
        int V = 9;
        Grafo g = new Grafo(V);

        g.agregarArista(0, 1, 4);
        g.agregarArista(0, 7, 8);
        g.agregarArista(1, 2, 8);
        g.agregarArista(1, 7, 11);
        g.agregarArista(2, 3, 7);
        g.agregarArista(2, 8, 2);
        g.agregarArista(2, 5, 4);
        g.agregarArista(3, 4, 9);
        g.agregarArista(3, 5, 14);
        g.agregarArista(4, 5, 10);
        g.agregarArista(5, 6, 2);
        g.agregarArista(6, 7, 1);
        g.agregarArista(6, 8, 6);
        g.agregarArista(7, 8, 7);

        // Ejecutar algoritmos en el grafo
        g.dijkstra(0);
        ArrayList<Grafo.Arista> aristasMSTPrim = g.prim();
        int[] coloresWelshPowell = g.welshPowell();
        g.matula();
    }

    private static void pruebaAlgoritmosOrdenamiento() {
        // Lista de números generada aleatoriamente
        ArrayList<Integer> numeros = generarListaAleatoria(20);

        // Imprimir lista antes de ordenar
        imprimirListaNumeros(numeros);

        // Ordenar utilizando MergeSort
        ArrayList<Integer> mergeSorted = new ArrayList<>(numeros);
        MergeSort.mergeSort(mergeSorted);
        imprimirOrdenamiento("MergeSort", mergeSorted);

        // Ordenar utilizando ShellSort
        ArrayList<Integer> shellSorted = new ArrayList<>(numeros);
        ShellSort.ordenar(shellSorted);
        imprimirOrdenamiento("ShellSort", shellSorted);

        // Ordenar utilizando QuickSort
        ArrayList<Integer> quickSorted = new ArrayList<>(numeros);
        QuickSort.quicksort(quickSorted);
        imprimirOrdenamiento("QuickSort", quickSorted);
    }

    // Genera una lista de números aleatorios entre 1 y 100
    private static ArrayList<Integer> generarListaAleatoria(int cantidad) {
        ArrayList<Integer> lista = new ArrayList<>();
        Random rand = new Random();
        for (int i = 0; i < cantidad; i++) {
            lista.add(rand.nextInt(100) + 1);
        }
        return lista;
    }

    // Función para imprimir una lista de números
    public static void imprimirListaNumeros(ArrayList<Integer> lista) {
        System.out.println("Lista de números: ");
        for (int numero : lista) {
            System.out.print(" " + numero);
        }
        System.out.println();
    }

    // Función para imprimir el resultado del ordenamiento
    public static void imprimirOrdenamiento(String algoritmo, ArrayList<Integer> lista) {
        System.out.println("Ordenados con " + algoritmo + ": ");
        for (int numero : lista) {
            System.out.print(" " + numero);
        }
        System.out.println();
    }
}
