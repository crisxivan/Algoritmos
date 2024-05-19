package algoritmos;

import java.util.ArrayList;

public class Algoritmo {
	public static void seleccion(ArrayList<Integer> lista) {
		for( int i = 0; i < lista.size()-1; i++) {
			int numeroMenor = lista.get(i);
			int indexMenor = i;
			
			for( int j = i+1; j < lista.size(); j++) {
				if( lista.get(j) != null && lista.get(j) < numeroMenor ) {
					indexMenor = j;
					numeroMenor = lista.get(j);
				}
			}
			
			int temp = lista.get(i);
			lista.set(i, numeroMenor);
			lista.set(indexMenor, temp);
		}
	}
	
	public static void burbujeo(ArrayList<Integer> lista) {
		Boolean intercambio;
		for( int i = 0; i < lista.size(); i++) {
			 intercambio = false;
			 
			 for( int j = lista.size() -1; j > i; j--) {
				 
				 if( lista.get(j) < lista.get(j-1) ) {
					 
					 int temp = lista.get(j);
					 lista.set(j, lista.get(j-1));
					 lista.set(j-1, temp);
					 intercambio = true;
				 }
			 }
			 
			 if( !intercambio ) {
				 break;
			 }
		}
	}
	
	public static void insersion(ArrayList<Integer> lista) {
		
		int aux;
		for( int i = 1; i < lista.size(); i++) {
			
			aux = lista.get(i);
			int j = i - 1;
			
			while( j >= 0 && lista.get(j) > aux ) {
				
				lista.set(j + 1, lista.get(j));
				j = j -1;
			}
			lista.set(j +1, aux);
			
		}
	}
}
