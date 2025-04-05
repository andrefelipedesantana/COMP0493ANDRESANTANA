package FluxoGrafos;

public class Main {
    public static void main(String[] args) {
        int[][] grafo = {
            {0, 16, 13, 0, 0, 0},
            {0, 0, 10, 12, 0, 0},
            {0, 4, 0, 0, 14, 0},
            {0, 0, 9, 0, 0, 20},
            {0, 0, 0, 7, 0, 4},
            {0, 0, 0, 0, 0, 0}
        };

        int fonte = 0;
        int sumidouro = 5;

        FordFulkerson fordFulkerson = new FordFulkerson(6);
        int resultadoFordFulkerson = fordFulkerson.fordFulkerson(grafo, fonte, sumidouro);
        System.out.println("Fluxo máximo (Ford-Fulkerson): " + resultadoFordFulkerson);

        EdmondsKarp edmondsKarp = new EdmondsKarp(6);
        int resultadoEdmondsKarp = edmondsKarp.edmondsKarp(grafo, fonte, sumidouro);
        System.out.println("Fluxo máximo (Edmonds-Karp): " + resultadoEdmondsKarp);

        Dinic dinic = new Dinic(6);
        dinic.adicionarAresta(0, 1, 16);
        dinic.adicionarAresta(0, 2, 13);
        dinic.adicionarAresta(1, 2, 10);
        dinic.adicionarAresta(1, 3, 12);
        dinic.adicionarAresta(2, 1, 4);
        dinic.adicionarAresta(2, 4, 14);
        dinic.adicionarAresta(3, 2, 9);
        dinic.adicionarAresta(3, 5, 20);
        dinic.adicionarAresta(4, 3, 7);
        dinic.adicionarAresta(4, 5, 4);
        
        int resultadoDinic = dinic.dinicMaxflow(fonte, sumidouro);
        System.out.println("Fluxo máximo (Dinic): " + resultadoDinic);
    }
}
