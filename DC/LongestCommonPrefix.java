package DC;
public class LongestCommonPrefix {
    // Método para encontrar o prefixo comum mais longo entre as palavras
    public static String encontrarLCP(String[] palavras, int inicio, int fim) {
        // Caso base: quando a busca é em apenas uma palavra, o prefixo comum é a própria palavra
        if (inicio == fim) {
            return palavras[inicio];}
        // Encontrar o ponto médio para dividir o intervalo
        int meio = (inicio + fim) / 2;
        // Chamada recursiva para a metade esquerda (início até meio)
        String esquerdaLCP = encontrarLCP(palavras, inicio, meio);
        // Chamada recursiva para a metade direita (meio + 1 até fim)
        String direitaLCP = encontrarLCP(palavras, meio + 1, fim);
        // Retornar o prefixo comum entre os dois prefixos encontrados
        return prefixoComum(esquerdaLCP, direitaLCP); }
    // Método para encontrar o prefixo comum entre duas strings
    private static String prefixoComum(String s1, String s2) {
        // Encontrar o comprimento mínimo entre as duas strings
        int minLength = Math.min(s1.length(), s2.length());
        // Comparar caractere a caractere até o menor comprimento
        for (int i = 0; i < minLength; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                // Se os caracteres forem diferentes, retornar o prefixo até o índice anterior
                return s1.substring(0, i); }}
        // Se todas as comparações forem iguais, retornar o prefixo até o comprimento mínimo
        return s1.substring(0, minLength);}
    public static void main(String[] args) {
        // Exemplo de entrada com um array de palavras
        String[] palavras = {"flor", "floresta", "fluxo", "flutuar"};
        // Chamada do método para encontrar o prefixo comum mais longo entre as palavras
        String resultado = encontrarLCP(palavras, 0, palavras.length - 1);
        // Exibir o resultado na tela
        System.out.println("Prefixo comum mais longo: " + resultado);
    }
}
