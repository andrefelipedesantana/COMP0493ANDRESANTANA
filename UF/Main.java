package UF;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Kruskal.Aresta> arestas = new ArrayList<>();
        arestas.add(new Kruskal.Aresta(0, 1, 4));
        arestas.add(new Kruskal.Aresta(0, 2, 3));
        arestas.add(new Kruskal.Aresta(1, 2, 1));
        arestas.add(new Kruskal.Aresta(1, 3, 2));
        arestas.add(new Kruskal.Aresta(2, 3, 4));
        arestas.add(new Kruskal.Aresta(3, 4, 2));
        arestas.add(new Kruskal.Aresta(4, 5, 6));

        Kruskal kruskal = new Kruskal();
        List<Kruskal.Aresta> resultado = kruskal.arvoreGeradoraMinima(arestas, 6);

        System.out.println("Kruskal:");
        for (Kruskal.Aresta a : resultado) {
            System.out.println(a.u + " - " + a.v + " : " + a.peso);
        }

        List<List<Prim.Aresta>> grafo = new ArrayList<>();
        for (int i = 0; i < 6; i++) grafo.add(new ArrayList<>());
        grafo.get(0).add(new Prim.Aresta(1, 4));
        grafo.get(0).add(new Prim.Aresta(2, 3));
        grafo.get(1).add(new Prim.Aresta(0, 4));
        grafo.get(1).add(new Prim.Aresta(2, 1));
        grafo.get(1).add(new Prim.Aresta(3, 2));
        grafo.get(2).add(new Prim.Aresta(0, 3));
        grafo.get(2).add(new Prim.Aresta(1, 1));
        grafo.get(2).add(new Prim.Aresta(3, 4));
        grafo.get(3).add(new Prim.Aresta(1, 2));
        grafo.get(3).add(new Prim.Aresta(2, 4));
        grafo.get(3).add(new Prim.Aresta(4, 2));
        grafo.get(4).add(new Prim.Aresta(3, 2));
        grafo.get(4).add(new Prim.Aresta(5, 6));
        grafo.get(5).add(new Prim.Aresta(4, 6));

        Prim prim = new Prim();
        int custo = prim.arvoreGeradoraMinima(grafo);
        System.out.println("Prim (custo total): " + custo);
    }
}

