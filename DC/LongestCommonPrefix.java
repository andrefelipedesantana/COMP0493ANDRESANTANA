package DC;

public class LongestCommonPrefix {

    public static String encontrarLCP(String[] palavras, int inicio, int fim) {
        if (inicio == fim) {
            return palavras[inicio];
        }
        int meio = (inicio + fim) / 2;
        String esquerdaLCP = encontrarLCP(palavras, inicio, meio);
        String direitaLCP = encontrarLCP(palavras, meio + 1, fim);
        return prefixoComum(esquerdaLCP, direitaLCP);
    }

    private static String prefixoComum(String s1, String s2) {
        int minLength = Math.min(s1.length(), s2.length());
        for (int i = 0; i < minLength; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                return s1.substring(0, i);
            }
        }
        return s1.substring(0, minLength);
    }

    public static void main(String[] args) {
        String[] palavras = {"flor", "floresta", "fluxo", "flutuar"};
        String resultado = encontrarLCP(palavras, 0, palavras.length - 1);
        System.out.println("Prefixo comum mais longo: " + resultado);
    }
}

