package algoritmosNoElementales;

import java.util.ArrayList;

public class ShellSort {

    public static void ordenar(ArrayList<Integer> lista) {
        int n = lista.size();
        
        for (int intervalo = n / 2; intervalo > 0; intervalo /= 2) {
            for (int i = intervalo; i < n; i++) {
                int valorActual = lista.get(i);
                int j;
                for (j = i; j >= intervalo && lista.get(j - intervalo) > valorActual; j -= intervalo) {
                    lista.set(j, lista.get(j - intervalo));
                }
                lista.set(j, valorActual);
            }
        }
    }
}
