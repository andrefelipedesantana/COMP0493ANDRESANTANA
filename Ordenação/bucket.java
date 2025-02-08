package Ordenação;

import java.util.ArrayList;
import java.util.Collections;

public class bucket {

    public static void bucketSort(float[] A) {
        int n = A.length;

        ArrayList<Float>[] buckets = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            buckets[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            int bucketIndex = (int) (n * A[i]); 
            buckets[bucketIndex].add(A[i]);
        }

        for (int i = 0; i < n; i++) {
            Collections.sort(buckets[i]);
        }

        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < buckets[i].size(); j++) {
                A[index++] = buckets[i].get(j);
            }
        }
    }

    public static void main(String[] args) {
        float[] A = {0.42f, 0.32f, 0.33f, 0.52f, 0.37f, 0.47f, 0.51f};

        System.out.println("Vetor original:");
        for (float numero : A) {
            System.out.print(numero + " ");
        }
        System.out.println();

        bucketSort(A);

        System.out.println("Vetor ordenado:");
        for (float numero : A) {
            System.out.print(numero + " ");
        }
        System.out.println();
    }
}
