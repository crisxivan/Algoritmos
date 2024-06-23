package algoritmos;

import java.util.ArrayList;
import java.util.Random;

import Grafos.Grafo;
import algoritmosNoElementales.MergeSort;

public class Resoluciones {

	public static void main(String[] args) {
		pruebaAlgoritmosOrdenamiento();
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

        g.dijkstra(0);
	}

	private static void pruebaAlgoritmosOrdenamiento() {
		// Array con los números predefinidos
//		int[] numeros1 = { 17, 42, 89, 5, 63, 11, 75 };
		
		ArrayList<Integer> numeros = new ArrayList<>();
        numeros.add(17);
        numeros.add(42);
        numeros.add(89);
        numeros.add(5);
        numeros.add(63);
        numeros.add(11);
        numeros.add(75);
        
        imprimirListaNumeros(numeros);
        
//        Algoritmo.seleccion(numeros);
//        Algoritmo.burbujeo(numeros);
//        Algoritmo.insersion(numeros);
//        AlgoritmosNE.quicksort(numeros);
        MergeSort.mergeSort(numeros);

        imprimirListaNumeros(numeros);
	}
	
	// Función para imprimir una lista de números
    public static void imprimirListaNumeros(ArrayList<Integer> lista) {
        System.out.println("Lista de números: ");
        for (int numero : lista) {
            System.out.print(" " + numero);
        }
        System.out.println();
    }

	// ** PARA GENERAR NUMERO ALEATORIOS
	public ArrayList<Integer> numRandoms() {
		// Crear un objeto Random para generar números aleatorios
		Random rand = new Random();

		// Crear una lista para almacenar los números
		ArrayList<Integer> numeros = new ArrayList<>();

		// Generar 7 números aleatorios y añadirlos a la lista
		for (int i = 0; i < 7; i++) {
			int numeroAleatorio = rand.nextInt(100) + 1; // Genera un número aleatorio entre 1 y 100
			numeros.add(numeroAleatorio);
		}
		
		return numeros;		
	}

}
