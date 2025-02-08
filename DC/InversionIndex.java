package DC;

public class InversionIndex {
    public static int contarInversoes(int[] array, int inicio, int fim) {
        if (inicio >= fim) {
            return 0;
        }
        int meio = (inicio + fim) / 2;
        int inversoes = contarInversoes(array, inicio, meio);
        inversoes += contarInversoes(array, meio + 1, fim);
        inversoes += mesclarEContar(array, inicio, meio, fim);
        return inversoes;
    }

    private static int mesclarEContar(int[] array, int inicio, int meio, int fim) {
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

        int i = 0, j = 0, k = inicio, inversoes = 0;
        while (i < n1 && j < n2) {
            if (esquerda[i] <= direita[j]) {
                array[k] = esquerda[i];
                i++;
            } else {
                array[k] = direita[j];
                inversoes += (n1 - i); 
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

        return inversoes;
    }

    public static void main(String[] args) {
        int[] array = {8, 4, 2, 1};
        System.out.println("Array original:");
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();

        int inversoes = contarInversoes(array, 0, array.length - 1);

        System.out.println("Array ordenado:");
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println("\nNúmero de inversões: " + inversoes);
    }
}
