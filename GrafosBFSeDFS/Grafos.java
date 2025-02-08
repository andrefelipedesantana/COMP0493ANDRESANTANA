package GrafosBFSeDFS;

import java.util.*;

class GrafoMatriz {
    private int[][] matriz;
    private int vertices;

    public GrafoMatriz(int vertices) {
        this.vertices = vertices;
        matriz = new int[vertices][vertices];
    }

    public void adicionarAresta(int origem, int destino) {
        matriz[origem][destino] = 1;
        matriz[destino][origem] = 1;
    }

    public void bfs(int inicio) {
        boolean[] visitado = new boolean[vertices];
        Queue<Integer> fila = new LinkedList<>();
        visitado[inicio] = true;
        fila.add(inicio);
        
        while (!fila.isEmpty()) {
            int vertice = fila.poll();
            System.out.print(vertice + " ");
            
            for (int i = 0; i < vertices; i++) {
                if (matriz[vertice][i] == 1 && !visitado[i]) {
                    visitado[i] = true;
                    fila.add(i);
                }
            }
        }
    }

    public void dfs(int inicio, boolean[] visitado) {
        visitado[inicio] = true;
        System.out.print(inicio + " ");
        
        for (int i = 0; i < vertices; i++) {
            if (matriz[inicio][i] == 1 && !visitado[i]) {
                dfs(i, visitado);
            }
        }
    }
}

class GrafoLista {
    private List<List<Integer>> lista;
    
    public GrafoLista(int vertices) {
        lista = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
            lista.add(new ArrayList<>());
        }
    }
    
    public void adicionarAresta(int origem, int destino) {
        lista.get(origem).add(destino);
        lista.get(destino).add(origem);
    }
    
    public void bfs(int inicio) {
        boolean[] visitado = new boolean[lista.size()];
        Queue<Integer> fila = new LinkedList<>();
        visitado[inicio] = true;
        fila.add(inicio);
        
        while (!fila.isEmpty()) {
            int vertice = fila.poll();
            System.out.print(vertice + " ");
            
            for (int vizinho : lista.get(vertice)) {
                if (!visitado[vizinho]) {
                    visitado[vizinho] = true;
                    fila.add(vizinho);
                }
            }
        }
    }
    
    public void dfs(int inicio, boolean[] visitado) {
        visitado[inicio] = true;
        System.out.print(inicio + " ");
        
        for (int vizinho : lista.get(inicio)) {
            if (!visitado[vizinho]) {
                dfs(vizinho, visitado);
            }
        }
    }
}

public class Grafos {
    public static void main(String[] args) {
        int vertices = 5;
        GrafoMatriz grafoMatriz = new GrafoMatriz(vertices);
        GrafoLista grafoLista = new GrafoLista(vertices);
        
        grafoMatriz.adicionarAresta(0, 1);
        grafoMatriz.adicionarAresta(0, 2);
        grafoMatriz.adicionarAresta(1, 3);
        grafoMatriz.adicionarAresta(2, 4);
        
        grafoLista.adicionarAresta(0, 1);
        grafoLista.adicionarAresta(0, 2);
        grafoLista.adicionarAresta(1, 3);
        grafoLista.adicionarAresta(2, 4);
        
        System.out.println("BFS em Matriz de Adjacência:");
        grafoMatriz.bfs(0);
        System.out.println("\nDFS em Matriz de Adjacência:");
        grafoMatriz.dfs(0, new boolean[vertices]);
        
        System.out.println("\nBFS em Lista de Adjacência:");
        grafoLista.bfs(0);
        System.out.println("\nDFS em Lista de Adjacência:");
        grafoLista.dfs(0, new boolean[vertices]);
    }


}
