package Strings;

public class Main {
    public static void main(String[] args) {
        String texto = "ABABDABACDABABCABAB";
        String padrao = "ABABCABAB";

        KMP kmp = new KMP();
        BoyerMoore bm = new BoyerMoore();
        RabinKarp rk = new RabinKarp();

        System.out.println("KMP: " + kmp.buscar(texto, padrao));
        System.out.println("Boyer-Moore: " + bm.buscar(texto, padrao));
        System.out.println("Rabin-Karp: " + rk.buscar(texto, padrao));
    }
}

