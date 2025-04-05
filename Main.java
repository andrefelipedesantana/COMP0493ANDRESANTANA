import java.util.Scanner;

public class Main {
    private static boolean buscaprofunda(int[][] labirinto, int i, int j, boolean[][] visitados) {
        if (i < 0 || i >= 5 || j < 0 || j >= 5 || labirinto[i][j] == 1 || visitados[i][j]) {
            return false;}
        visitados[i][j] = true;
        if (i == 4 && j == 4) {
            return true;}
        if (buscaprofunda(labirinto, i + 1, j, visitados)) return true; // Baixo
        if (buscaprofunda(labirinto, i - 1, j, visitados)) return true; // Cima
        if (buscaprofunda(labirinto, i, j + 1, visitados)) return true; // Direita
        if (buscaprofunda(labirinto, i, j - 1, visitados)) return true; // Esquerda

        return false;
    }
    private static boolean resolverLabirinto(int[][] labirinto) {
        boolean[][] visitados = new boolean[5][5];
        return buscaprofunda(labirinto, 0, 0, visitados);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int t = 0; t < T; t++) {
            int[][] labirinto = new int[5][5];
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    labirinto[i][j] = scanner.nextInt();
                }}
            if (resolverLabirinto(labirinto)) {
                System.out.println("COPS");
            } else {
                System.out.println("ROBBERS");
            }
        }
        scanner.close();}
}