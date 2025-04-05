package FluxoGrafos;

import java.util.LinkedList;

class Dinic {
    private int V;
    private int[] nivel;
    private int[] ponteiro;
    private LinkedList<Aresta>[] grafo;

    class Aresta {
        int v;
        int capacidade;
        int fluxo;
        int reversa;

        Aresta(int v, int capacidade, int fluxo, int reversa) {
            this.v = v;
            this.capacidade = capacidade;
            this.fluxo = fluxo;
            this.reversa = reversa;
        }
    }

    public Dinic(int v) {
        V = v;
        nivel = new int[V];
        ponteiro = new int[V];
        grafo = new LinkedList[V];
        for (int i = 0; i < V; i++) {
            grafo[i] = new LinkedList<>();
        }
    }

    void adicionarAresta(int u, int v, int capacidade) {
        Aresta a = new Aresta(v, capacidade, 0, grafo[v].size());
        Aresta b = new Aresta(u, 0, 0, grafo[u].size());
        grafo[u].add(a);
        grafo[v].add(b);
    }

    boolean bfs(int s, int t) {
        for (int i = 0; i < V; i++) {
            nivel[i] = -1;
        }
        nivel[s] = 0;
        LinkedList<Integer> fila = new LinkedList<>();
        fila.add(s);

        while (!fila.isEmpty()) {
            int u = fila.poll();
            for (Aresta e : grafo[u]) {
                if (nivel[e.v] < 0 && e.fluxo < e.capacidade) {
                    nivel[e.v] = nivel[u] + 1;
                    fila.add(e.v);
                }
            }
        }
        return nivel[t] >= 0;
    }

    int dfs(int u, int fluxo, int t) {
        if (u == t) {
            return fluxo;
        }
        for (; ponteiro[u] < grafo[u].size(); ponteiro[u]++) {
            Aresta e = grafo[u].get(ponteiro[u]);
            if (nivel[e.v] == nivel[u] + 1 && e.fluxo < e.capacidade) {
                int fluxoAtual = Math.min(fluxo, e.capacidade - e.fluxo);
                int fluxoTemporario = dfs(e.v, fluxoAtual, t);
                if (fluxoTemporario > 0) {
                    e.fluxo += fluxoTemporario;
                    grafo[e.v].get(e.reversa).fluxo -= fluxoTemporario;
                    return fluxoTemporario;
                }
            }
        }
        return 0;
    }

    int dinicMaxflow(int s, int t) {
        if (s == t) {
            return -1;
        }
        int fluxoTotal = 0;
        while (bfs(s, t)) {
            for (int i = 0; i < V; i++) {
                ponteiro[i] = 0;
            }
            while (true) {
                int fluxo = dfs(s, Integer.MAX_VALUE, t);
                if (fluxo == 0) {
                    break;
                }
                fluxoTotal += fluxo;
            }
        }
        return fluxoTotal;
    }
}
