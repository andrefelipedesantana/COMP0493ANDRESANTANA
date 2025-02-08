package MetodoGuloso;

import java.util.ArrayList;
import java.util.List;

public class ProblemaTroco {
    public static List<Integer> calcularTroco(int valor, int[] moedas) {
        List<Integer> troco = new ArrayList<>();
        for (int moeda : moedas) {
            while (valor >= moeda) {
                valor -= moeda;
                troco.add(moeda);
            }
        }
        return troco;
    }

    public static void main(String[] args) {
        int valor = 63;
        int[] moedas = {25, 10, 5, 1};
        List<Integer> resultado = calcularTroco(valor, moedas);
        System.out.println("Moedas usadas para o troco: " + resultado);
    }
}

