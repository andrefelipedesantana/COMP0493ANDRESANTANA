package Ordenação;

import java.util.Arrays;

public class radix {

    public static int encontrarMaximo(int[] vetor) {
        int maximo = vetor[0];
        for (int numero : vetor) {
            if (numero > maximo) {
                maximo = numero;
            }
        }
        return maximo;
    }

    public static void ordenacaoPorContagem(int[] vetor, int expoente) {
        int tamanho = vetor.length;
        int[] saida = new int[tamanho];
        int[] contagem = new int[10];

        Arrays.fill(contagem, 0);

        for (int i = 0; i < tamanho; i++) {
            int digito = (vetor[i] / expoente) % 10;
            contagem[digito]++;
        }

        for (int i = 1; i < 10; i++) {
            contagem[i] += contagem[i - 1];
        }

        for (int i = tamanho - 1; i >= 0; i--) {
            int digito = (vetor[i] / expoente) % 10;
            saida[contagem[digito] - 1] = vetor[i];
            contagem[digito]--;
        }

        for (int i = 0; i < tamanho; i++) {
            vetor[i] = saida[i];
        }
    }

    public static void radixSort(int[] vetor) {

        int maximo = encontrarMaximo(vetor);

        for (int expoente = 1; maximo / expoente > 0; expoente *= 10) {
            ordenacaoPorContagem(vetor, expoente);
        }
    }

    public static void main(String[] args) {
        int[] vetor = {170, 45, 75, 90, 802, 24, 2, 66};

        System.out.println("Vetor original:");
        for (int numero : vetor) {
            System.out.print(numero + " ");
        }
        System.out.println();

        radixSort(vetor);

        System.out.println("Vetor ordenado:");
        for (int numero : vetor) {
            System.out.print(numero + " ");
        }
        System.out.println();
    }
}
