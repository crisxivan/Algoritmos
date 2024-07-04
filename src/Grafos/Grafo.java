package Grafos;

import java.util.*;

public class Grafo {
    private int V; // Número de vértices
    private LinkedList<Arista>[] adj; // Lista de adyacencia

    public class Arista {
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
        System.out.println("Distancia desde la fuente:");
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

                // Actualizar los valores de dist[] de los vértices adyacentes al vértice
                // seleccionado.
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

    // Implementación del algoritmo de Prim
    public ArrayList<Arista> prim() {
        boolean[] incluidosEnMST = new boolean[V];
        int[] llave = new int[V];
        int[] padres = new int[V];

        Arrays.fill(llave, Integer.MAX_VALUE);
        Arrays.fill(padres, -1);

        PriorityQueue<Arista> colaPrioridad = new PriorityQueue<>(V, Comparator.comparingInt(a -> a.peso));

        llave[0] = 0;
        colaPrioridad.add(new Arista(0, llave[0]));

        while (!colaPrioridad.isEmpty()) {
            int u = colaPrioridad.poll().nodo;
            incluidosEnMST[u] = true;

            for (Arista arista : adj[u]) {
                int v = arista.nodo;
                int peso = arista.peso;

                if (!incluidosEnMST[v] && llave[v] > peso) {
                    llave[v] = peso;
                    colaPrioridad.add(new Arista(v, llave[v]));
                    padres[v] = u;
                }
            }
        }

        return construirMST(padres);
    }

    // Método auxiliar para construir el MST
    private ArrayList<Arista> construirMST(int[] padres) {
        ArrayList<Arista> aristasMST = new ArrayList<>();
        for (int i = 1; i < V; i++) {
            for (Arista arista : adj[i]) {
                if (arista.nodo == padres[i]) {
                    aristasMST.add(arista);
                }
            }
        }
        return aristasMST;
    }

    // Implementación del algoritmo de Welsh-Powell
    public int[] welshPowell() {
        int[] grados = new int[V];
        for (int i = 0; i < V; i++) {
            grados[i] = adj[i].size();
        }

        Integer[] vertices = new Integer[V];
        for (int i = 0; i < V; i++) {
            vertices[i] = i;
        }

        Arrays.sort(vertices, Comparator.comparingInt(i -> -grados[i]));

        int[] colores = new int[V];
        Arrays.fill(colores, -1);

        int color = 0;
        for (int u : vertices) {
            if (colores[u] == -1) {
                colores[u] = color;
                for (int v : vertices) {
                    if (colores[v] == -1 && !sonAdyacentes(u, v)) {
                        colores[v] = color;
                    }
                }
                color++;
            }
        }

        mostrarColores(colores);
        return colores;
    }

    private boolean sonAdyacentes(int u, int v) {
        for (Arista arista : adj[u]) {
            if (arista.nodo == v) {
                return true;
            }
        }
        return false;
    }

    // Método para imprimir los colores asignados por Welsh-Powell
    public void mostrarColores(int[] colores) {
        System.out.println("Nodo \tColor");
        for (int i = 0; i < V; i++) {
            System.out.println(i + " \t\t " + colores[i]);
        }
    }

    // Implementación del algoritmo de Matula
    public void matula() {
        ArrayList<Integer> ordenPorGrado = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            ordenPorGrado.add(i);
        }

        // Ordenar los vértices según su grado
        ordenPorGrado.sort((v1, v2) -> adj[v1].size() - adj[v2].size());

        // Mostrar los vértices ordenados por grado
        System.out.println("Vértices ordenados por grado según Matula:");
        for (int v : ordenPorGrado) {
            System.out.print(v + " ");
        }
        System.out.println();
    }

    // Método para imprimir la solución de Prim
    public void mostrarMSTPrim(ArrayList<Arista> mst) {
        System.out.println("Aristas del MST obtenido con Prim:");
        for (Arista arista : mst) {
            System.out.println(arista.nodo + " - " + arista.peso);
        }
    }
}
