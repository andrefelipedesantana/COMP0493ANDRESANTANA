package DC;

public class Mergesort {

    public static void ordenar(int[] array, int inicio, int fim) {
        if (inicio < fim) {
            int meio = (inicio + fim) / 2;
            ordenar(array, inicio, meio);
            ordenar(array, meio + 1, fim);
            mesclar(array, inicio, meio, fim);
        }
    }

    private static void mesclar(int[] array, int inicio, int meio, int fim) {
        int n1 = meio - inicio + 1;
        int n2 = fim - meio;

        int[] esquerda = new int[n1];
        int[] direita = new int[n2];

        for (int i = 0; i < n1; i++) {
            esquerda[i] = array[inicio + i];
        }
        for (int j = 0; j < n2; j++) {
            direita[j] = array[meio + 1 + j];
        }

        int i = 0, j = 0, k = inicio;
        while (i < n1 && j < n2) {
            if (esquerda[i] <= direita[j]) {
                array[k] = esquerda[i];
                i++;
            } else {
                array[k] = direita[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            array[k] = esquerda[i];
            i++;
            k++;
        }

        while (j < n2) {
            array[k] = direita[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args) {
        int[] array = {38, 27, 43, 3, 9, 82, 10};
        System.out.println("Array original:");
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();

        ordenar(array, 0, array.length - 1);

        System.out.println("Array ordenado:");
        for (int num : array) {
            System.out.print(num + " ");
        }
    }
}

