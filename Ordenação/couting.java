package Ordenação;
public class couting {

    public static void countingSort(int[] A) {
        int K = A[0];
        for (int i = 1; i < A.length; i++) {
            if (A[i] > K) {
                K = A[i];
            }
        }
        int[] C = new int[K + 1];

        for (int i = 0; i < A.length; i++) {
            C[A[i]]++;
        }
        for (int i = 1; i <= K; i++) {
            C[i] += C[i - 1];
        }


        int[] B = new int[A.length];

        for (int i = A.length - 1; i >= 0; i--) {
            B[C[A[i]] - 1] = A[i];
            C[A[i]]--;
        }

        for (int i = 0; i < A.length; i++) {
            A[i] = B[i];
        }
    }

    public static void main(String[] args) {
        int[] A = {4, 2, 2, 8, 3, 3, 1};
        
        System.out.println("Vetor original:");
        for (int numero : A) {
            System.out.print(numero + " ");
        }
        System.out.println();

        countingSort(A);

        System.out.println("Vetor ordenado:");
        for (int numero : A) {
            System.out.print(numero + " ");
        }
        System.out.println();
    }
}