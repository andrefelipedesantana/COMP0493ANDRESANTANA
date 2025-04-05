package UF;

import java.util.*;

public class Prim {
    public static class Aresta {
        int destino, peso;
        public Aresta(int destino, int peso) {
            this.destino = destino;
            this.peso = peso;
        }
    }

    public int arvoreGeradoraMinima(List<List<Aresta>> grafo) {
        int n = grafo.size();
        boolean[] visitado = new boolean[n];
        PriorityQueue<int[]> fila = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        fila.add(new int[]{0, 0});
        int custoTotal = 0;

        while (!fila.isEmpty()) {
            int[] atual = fila.poll();
            int no = atual[0];
            int custo = atual[1];
            if (visitado[no]) continue;
            visitado[no] = true;
            custoTotal += custo;
            for (Aresta viz : grafo.get(no)) {
                if (!visitado[viz.destino]) fila.add(new int[]{viz.destino, viz.peso});
            }
        }
        return custoTotal;
    }
}

