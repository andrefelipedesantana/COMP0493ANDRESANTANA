package Strings;

public class RabinKarp {
    public int buscar(String texto, String padrao) {
        int d = 256;
        int q = 101;
        int n = texto.length();
        int m = padrao.length();
        int p = 0, t = 0, h = 1;
        for (int i = 0; i < m - 1; i++) h = (h * d) % q;
        for (int i = 0; i < m; i++) {
            p = (d * p + padrao.charAt(i)) % q;
            t = (d * t + texto.charAt(i)) % q;
        }
        for (int i = 0; i <= n - m; i++) {
            if (p == t) {
                int j = 0;
                while (j < m && texto.charAt(i + j) == padrao.charAt(j)) j++;
                if (j == m) return i;
            }
            if (i < n - m) {
                t = (d * (t - texto.charAt(i) * h) + texto.charAt(i + m)) % q;
                if (t < 0) t += q;
            }
        }
        return -1;
    }
}

