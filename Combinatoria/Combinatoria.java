package Combinatoria;

import java.util.Scanner;

public class Combinatoria {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o valor de n: ");
        int n = scanner.nextInt();
        System.out.print("Digite o valor de k: ");
        int k = scanner.nextInt();
        
        System.out.println("Coeficiente binomial (analitico): " + coeficienteBinomialAnalitico(n, k));
        System.out.println("Coeficiente binomial (recursivo): " + coeficienteBinomialRecursivo(n, k));
        
        scanner.close();
    }
    
    public static int coeficienteBinomialAnalitico(int n, int k) {
        if (k < 0 || k > n) {
            return 0;
        }
        int resultado = 1;
        for (int i = 1; i <= k; i++) {
            resultado = resultado * (n - k + i) / i;
        }
        return resultado;
    }
    
    public static int coeficienteBinomialRecursivo(int n, int k) {
        if (k == 0 || k == n) {
            return 1;
        }
        return coeficienteBinomialRecursivo(n - 1, k - 1) + coeficienteBinomialRecursivo(n - 1, k);
    }
}
