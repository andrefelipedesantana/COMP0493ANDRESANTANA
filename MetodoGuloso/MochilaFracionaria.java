package MetodoGuloso;

import java.util.Arrays;
import java.util.Comparator;

class Item {
    int peso;
    int valor;
    
    public Item(int peso, int valor) {
        this.peso = peso;
        this.valor = valor;
    }
}

public class MochilaFracionaria {
    public static double resolverMochilaFracionaria(Item[] itens, int capacidade) {
        Arrays.sort(itens, Comparator.comparingDouble(i -> -(double) i.valor / i.peso));
        
        double valorTotal = 0;
        for (Item item : itens) {
            if (capacidade >= item.peso) {
                capacidade -= item.peso;
                valorTotal += item.valor;
            } else {
                valorTotal += (double) item.valor * capacidade / item.peso;
                break;
            }
        }
        return valorTotal;
    }
    
    public static void main(String[] args) {
        Item[] itens = {new Item(10, 60), new Item(20, 100), new Item(30, 120)};
        int capacidade = 50;
        double valorMaximo = resolverMochilaFracionaria(itens, capacidade);
        System.out.println("Valor máximo na mochila: " + valorMaximo);
    }
}

