package UF;

public class UnionFind {
    private int[] pai;
    private int[] tamanho;

    public UnionFind(int n) {
        pai = new int[n];
        tamanho = new int[n];
        for (int i = 0; i < n; i++) {
            pai[i] = i;
            tamanho[i] = 1;
        }
    }

    public int encontrar(int x) {
        if (pai[x] != x) pai[x] = encontrar(pai[x]);
        return pai[x];
    }

    public boolean unir(int x, int y) {
        int raizX = encontrar(x);
        int raizY = encontrar(y);
        if (raizX == raizY) return false;
        if (tamanho[raizX] < tamanho[raizY]) {
            pai[raizX] = raizY;
            tamanho[raizY] += tamanho[raizX];
        } else {
            pai[raizY] = raizX;
            tamanho[raizX] += tamanho[raizY];
        }
        return true;
    }
}

