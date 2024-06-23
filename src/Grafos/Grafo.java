package Grafos;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class Grafo {
	
	private int V; // Número de vértices
    private LinkedList<Arista>[] adj; // Lista de adyacencia

    class Arista {
        int nodo;
        int peso;

        Arista(int node, int weight) {
            this.nodo = node;
            this.peso = weight;
        }
    }

    // Constructor
    public Grafo(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList<>();
    }

    // Método para añadir una arista al grafo
    public void agregarArista(int u, int v, int weight) {
        adj[u].add(new Arista(v, weight));
        adj[v].add(new Arista(u, weight)); // Si el grafo es no dirigido
    }
	
	// Método para imprimir la solución
    void mostrarSolucion(int[] dist) {
        System.out.println("Distancia desde la fuente");
        for (int i = 0; i < V; i++)
            System.out.println(i + " \t\t " + dist[i]);
    }
    
 // Implementación del algoritmo de Dijkstra
    public void dijkstra(int src) {
        int[] dist = new int[V]; // Distancia más corta desde src hasta i
        Boolean[] sptSet = new Boolean[V]; // Conjunto de vértices incluidos en la ruta más corta

        // Inicializar todas las distancias como INFINITO y sptSet[] como falso
        for (int i = 0; i < V; i++) {
            dist[i] = Integer.MAX_VALUE;
            sptSet[i] = false;
        }

        // Distancia del vértice fuente a sí mismo es siempre 0
        dist[src] = 0;

        // Cola de prioridad para seleccionar el vértice con la distancia mínima
        PriorityQueue<Arista> pq = new PriorityQueue<>(V, Comparator.comparingInt(o -> o.peso));
        pq.add(new Arista(src, 0));

        while (!pq.isEmpty()) {
            // Obtener el vértice con la distancia mínima
            int u = pq.poll().nodo;

            if (!sptSet[u]) {
                sptSet[u] = true;

                // Actualizar los valores de dist[] de los vértices adyacentes al vértice seleccionado.
                for (Arista edge : adj[u]) {
                    int v = edge.nodo;
                    int weight = edge.peso;

                    if (!sptSet[v] && dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) {
                        dist[v] = dist[u] + weight;
                        pq.add(new Arista(v, dist[v]));
                    }
                }
            }
        }

        // Imprimir la solución
        mostrarSolucion(dist);
    }
}
