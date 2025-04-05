package Strings;

public class KMP {
    public int buscar(String texto, String padrao) {
        int[] lps = calcularLPS(padrao);
        int i = 0, j = 0;
        while (i < texto.length()) {
            if (padrao.charAt(j) == texto.charAt(i)) {
                i++;
                j++;
            }
            if (j == padrao.length()) {
                return i - j;
            } else if (i < texto.length() && padrao.charAt(j) != texto.charAt(i)) {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }
        return -1;
    }

    private int[] calcularLPS(String padrao) {
        int[] lps = new int[padrao.length()];
        int len = 0, i = 1;
        while (i < padrao.length()) {
            if (padrao.charAt(i) == padrao.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }
}

