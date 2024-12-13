import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Construcción del grafo
        Grafo grafo = new Grafo();
        Nodo A = new Nodo("A");
        Nodo X = new Nodo("X");
        Nodo B = new Nodo("B");
        Nodo C = new Nodo("C");
        Nodo D = new Nodo("D");
        Nodo E = new Nodo("E");
        Nodo Z = new Nodo("Z");

        // Definir las conexiones entre nodos
        A.agregarVecino(X);
        A.agregarVecino(C);
        A.agregarVecino(B);
        C.agregarVecino(D);
        C.agregarVecino(E);
        D.agregarVecino(Z);
        E.agregarVecino(Z);
        X.agregarVecino(Z);

        // Agregar nodos al grafo
        grafo.agregarNodo(A);
        grafo.agregarNodo(B);
        grafo.agregarNodo(C);
        grafo.agregarNodo(D);
        grafo.agregarNodo(E);
        grafo.agregarNodo(Z);

        // Nodo de inicio y fin
        Nodo inicio = grafo.buscarNodo("A");
        Nodo fin = grafo.buscarNodo("Z");

        // DFS: Buscar todas las rutas
        DFS dfs = new DFS();
        List<List<Nodo>> rutasDFS = new ArrayList<>();
        dfs.buscarTodasLasRutas(inicio, fin, new ArrayList<>(), rutasDFS);
        System.out.println("(DFS):");
        imprimirRutas(rutasDFS);

        // BFS: Buscar todas las rutas
        BFS bfs = new BFS();
        List<List<Nodo>> rutasBFS = new ArrayList<>();
        bfs.buscarTodasLasRutas(inicio, fin, rutasBFS);
        System.out.println("\n(BFS):");
        imprimirRutas(rutasBFS);
    }

    // Método auxiliar para imprimir rutas
    public static void imprimirRutas(List<List<Nodo>> rutas) {
        for (List<Nodo> ruta : rutas) {
            for (Nodo nodo : ruta) {
                System.out.print(nodo.getNombre() + " ---> ");
            }
            System.out.println("Fin");
        }
    }
}