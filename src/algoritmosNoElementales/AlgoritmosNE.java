package algoritmosNoElementales;

import java.util.ArrayList;
import java.util.Collections;

public class AlgoritmosNE {

	// Método principal que llama al método recursivo de quicksort
	public static void quicksort(ArrayList<Integer> array) {
		quicksort(array, 0, array.size() - 1);
	}

	// Método recursivo de quicksort
	private static void quicksort(ArrayList<Integer> array, int izq, int der) {
		if (izq < der) {
			int pivotIndex = partition(array, izq, der);
			if (izq < pivotIndex - 1)
				quicksort(array, izq, pivotIndex - 1); // Ordenar la mitad izquierda
			if (pivotIndex + 1 < der)
				quicksort(array, pivotIndex + 1, der); // Ordenar la mitad derecha
		}
	}

	// Método para particionar el array y encontrar el índice del pivote
	private static int partition(ArrayList<Integer> array, int izq, int der) {
		int mid = (izq + der) / 2;
		Collections.swap(array, mid, der); // Intercambiar el pivote con el último elemento
		int pivot = array.get(der); // Pivote ahora es el último elemento

		int i = izq;
		int j = der - 1;

		do {
			while (i < der && array.get(i) < pivot)
				i++; // Busco un elemento >= pivote
			while (j > izq && array.get(j) > pivot)
				j--; // Busco un elemento <= pivote
			if (i < j) {
				Collections.swap(array, i, j); // Intercambiar array[i] y array[j]
				i++;
				j--;
			}
		} while (i < j);

		Collections.swap(array, i, der); // Intercambiar array[i] y array[der] (pivote)

		return i;
	}

}
