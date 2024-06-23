package algoritmosNoElementales;

import java.util.ArrayList;

public class MergeSort {
	
	// Método principal que llama al método recursivo de mergesort
    public static void mergeSort(ArrayList<Integer> array) {
        if (array.size() > 1) {
            ArrayList<Integer> left = new ArrayList<>(array.subList(0, array.size() / 2));
            ArrayList<Integer> right = new ArrayList<>(array.subList(array.size() / 2, array.size()));

            mergeSort(left);
            mergeSort(right);
            merge(array, left, right);
        }
    }

    // Método para fusionar dos subarrays ordenados
    private static void merge(ArrayList<Integer> array, ArrayList<Integer> left, ArrayList<Integer> right) {
        int i = 0, j = 0, k = 0;

        // Fusionar las dos mitades en un solo array ordenado
        while (i < left.size() && j < right.size()) {
            if (left.get(i) <= right.get(j)) {
                array.set(k++, left.get(i++));
            } else {
                array.set(k++, right.get(j++));
            }
        }

        // Copiar los elementos restantes de left
        while (i < left.size()) {
            array.set(k++, left.get(i++));
        }

        // Copiar los elementos restantes de right
        while (j < right.size()) {
            array.set(k++, right.get(j++));
        }
    }
}
