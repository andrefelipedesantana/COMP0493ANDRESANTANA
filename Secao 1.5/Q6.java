import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Q6{
    public static void main(String[] args) throws IOException {

        String ultimalinha = "";

        FileReader arquivo = new FileReader("C:\\Users\\Usuario\\IdeaProjects\\exercicios\\src\\entrada.txt");
        BufferedReader leitor = new BufferedReader(arquivo);

        while (true) {
            String linha = leitor.readLine();
            if (linha == null || linha.trim().isEmpty()) {
                break;
            }
            ultimalinha = linha;
        }

        System.out.println("Ultima linha: " + ultimalinha + "\nQuantidade de caracteres: " + ultimalinha.length());
        leitor.close();
    }
}
