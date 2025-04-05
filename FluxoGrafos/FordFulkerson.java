package FluxoGrafos;
import java.util.LinkedList;

class FordFulkerson {
    private int V;

    public FordFulkerson(int v) {
        V = v;
    }

    boolean bfs(int[][] grafoResidual, int s, int t, int[] parente) {
        boolean[] visitado = new boolean[V];
        LinkedList<Integer> fila = new LinkedList<>();
        fila.add(s);
        visitado[s] = true;
        parente[s] = -1;

        while (!fila.isEmpty()) {
            int u = fila.poll();

            for (int v = 0; v < V; v++) {
                if (!visitado[v] && grafoResidual[u][v] > 0) {
                    if (v == t) {
                        parente[v] = u;
                        return true;
                    }
                    fila.add(v);
                    parente[v] = u;
                    visitado[v] = true;
                }
            }
        }
        return false;
    }

    int fordFulkerson(int[][] grafo, int s, int t) {
        int u, v;
        int[][] grafoResidual = new int[V][V];

        for (u = 0; u < V; u++) {
            for (v = 0; v < V; v++) {
                grafoResidual[u][v] = grafo[u][v];
            }
        }

        int[] parente = new int[V];
        int fluxoMaximo = 0;

        while (bfs(grafoResidual, s, t, parente)) {
            int fluxoCaminho = Integer.MAX_VALUE;
            for (v = t; v != s; v = parente[v]) {
                u = parente[v];
                fluxoCaminho = Math.min(fluxoCaminho, grafoResidual[u][v]);
            }

            for (v = t; v != s; v = parente[v]) {
                u = parente[v];
                grafoResidual[u][v] -= fluxoCaminho;
                grafoResidual[v][u] += fluxoCaminho;
            }

            fluxoMaximo += fluxoCaminho;
        }
        return fluxoMaximo;
    }
}