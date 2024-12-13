import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Q1{
    public static void main(String[] args) throws IOException {

        int contador;
        StringBuilder string = new StringBuilder();

        FileReader arquivo = new FileReader("C:\\Users\\Usuario\\IdeaProjects\\exercicios\\src\\entrada.txt");
        BufferedReader leitor = new BufferedReader(arquivo);

        while (true) {
            String linha = leitor.readLine();
            contador = 0;

            if (linha.isEmpty()) {
                break;
            }

            char[] frase = linha.toCharArray();
            for(int i = 0; i < linha.length(); i++){
                    if (frase[i] == '.') contador++;
                    if(i != linha.length() - 1){
                        if(frase[i] == '.' && frase[i + 1] != '.') break;
                    }
            }

            if (!string.isEmpty()) {
                string.append(" ");
            }

            if(contador == 7) break;
            if (!string.isEmpty()) {
                string.append(" ");
            }

            string.append(linha);
            System.out.println(string);

        }
    }
}
