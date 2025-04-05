package Strings;

public class BoyerMoore {
    private int[] tabela;

    public int buscar(String texto, String padrao) {
        int n = texto.length();
        int m = padrao.length();
        tabela = new int[256];
        for (int i = 0; i < 256; i++) tabela[i] = -1;
        for (int i = 0; i < m; i++) tabela[padrao.charAt(i)] = i;
        int s = 0;
        while (s <= n - m) {
            int j = m - 1;
            while (j >= 0 && padrao.charAt(j) == texto.charAt(s + j)) j--;
            if (j < 0) return s;
            else s += Math.max(1, j - tabela[texto.charAt(s + j)]);
        }
        return -1;
    }
}

