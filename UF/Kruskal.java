package UF;

import java.util.*;

public class Kruskal {
    public static class Aresta implements Comparable<Aresta> {
        int u, v, peso;
        public Aresta(int u, int v, int peso) {
            this.u = u;
            this.v = v;
            this.peso = peso;
        }
        public int compareTo(Aresta outra) {
            return this.peso - outra.peso;
        }
    }

    public List<Aresta> arvoreGeradoraMinima(List<Aresta> arestas, int n) {
        Collections.sort(arestas);
        UnionFind uf = new UnionFind(n);
        List<Aresta> resultado = new ArrayList<>();
        for (Aresta a : arestas) {
            if (uf.unir(a.u, a.v)) resultado.add(a);
        }
        return resultado;
    }
}
