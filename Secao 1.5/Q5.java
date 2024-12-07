import java.util.LinkedHashMap;

public class Q5 {
    public static void main(String[] args) {

        int contador;
        int maximo = 0;


        LinkedHashMap<String, Integer> palavras = new LinkedHashMap<>();

        String TTT = "i love cs3233 competitive programming. i also love algorithm";
        String[] tokens = TTT.split("[ .]+");
        
        for(String palavra : tokens){
            contador = 0;
            for(int i = 0; i < tokens.length; i++){
                if(palavra.equals(tokens[i])) contador++;
            }

            palavras.put(palavra, contador);
            if(contador > maximo) maximo = contador;
        }

        for (String palavra : palavras.keySet()) {
            int count = palavras.get(palavra);
            if (count == maximo) System.out.print(palavra + " ");
        }
    }
}
