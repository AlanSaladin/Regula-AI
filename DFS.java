import java.util.*;

class DFS {
    public void buscarTodasLasRutas(Nodo inicial, Nodo objetivo, List<Nodo> rutaActual, List<List<Nodo>> todasLasRutas) {
        if (inicial == null || objetivo == null) return;

        // Agregamos el nodo actual a la ruta
        rutaActual.add(inicial);

        // Si llegamos al objetivo, guardamos la ruta
        if (inicial.equals(objetivo)) {
            todasLasRutas.add(new ArrayList<>(rutaActual));
        } else {
            // Recorremos los vecinos del nodo actual
            for (Nodo vecino : inicial.getVecinos()) {
                if (!rutaActual.contains(vecino)) { // Evitar ciclos en la ruta actual
                    buscarTodasLasRutas(vecino, objetivo, rutaActual, todasLasRutas);
                }
            }
        }

        // Backtracking: eliminamos el nodo actual antes de regresar
        rutaActual.remove(rutaActual.size() - 1);
    }
}
