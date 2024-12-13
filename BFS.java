import java.util.*;

class BFS {
    public void buscarTodasLasRutas(Nodo inicial, Nodo objetivo, List<List<Nodo>> todasLasRutas) {
        if (inicial == null || objetivo == null) return;

        // Cola para manejar rutas parciales
        Queue<List<Nodo>> cola = new LinkedList<>();
        List<Nodo> rutaInicial = new ArrayList<>();
        rutaInicial.add(inicial);
        cola.add(rutaInicial);

        // Procesamos las rutas en la cola
        while (!cola.isEmpty()) {
            List<Nodo> rutaActual = cola.poll();
            Nodo actual = rutaActual.get(rutaActual.size() - 1);

            // Si llegamos al objetivo, guardamos la ruta
            if (actual.equals(objetivo)) {
                todasLasRutas.add(new ArrayList<>(rutaActual));
            } else {
                // Expandimos la ruta actual hacia sus vecinos
                for (Nodo vecino : actual.getVecinos()) {
                    if (!rutaActual.contains(vecino)) { // Evitar ciclos en la ruta actual
                        List<Nodo> nuevaRuta = new ArrayList<>(rutaActual);
                        nuevaRuta.add(vecino);
                        cola.add(nuevaRuta);
                    }
                }
            }
        }
    }
}
