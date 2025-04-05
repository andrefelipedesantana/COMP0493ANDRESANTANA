package TeoriaNumeros;

import java.util.Scanner;

public class TeoriaDosNumeros {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite um número para testar primalidade: ");
        int num = scanner.nextInt();
        System.out.println("Força bruta: " + ehPrimoForcaBruta(num));
        System.out.println("Otimizado: " + ehPrimoOtimizado(num));

        System.out.print("Digite um número para encontrar o inverso modular: ");
        int a = scanner.nextInt();
        System.out.print("Digite o módulo: ");
        int m = scanner.nextInt();
        int inverso = inversoModular(a, m);
        System.out.println("Inverso modular de " + a + " mod " + m + ": " + (inverso != -1 ? inverso : "Não existe"));

        scanner.close();
    }

    public static boolean ehPrimoForcaBruta(int n) {
        if (n <= 1) return false;
        for (int i = 2; i < n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public static boolean ehPrimoOtimizado(int n) {
        if (n <= 1) return false;
        if (n <= 3) return true;
        if (n % 2 == 0 || n % 3 == 0) return false;
        for (int i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) return false;
        }
        return true;
    }

    public static int inversoModular(int a, int m) {
        int[] euclidesEstendido = euclidesEstendido(a, m);
        if (euclidesEstendido[0] != 1) return -1;
        return (euclidesEstendido[1] % m + m) % m;
    }

    public static int[] euclidesEstendido(int a, int b) {
        if (b == 0) return new int[]{a, 1, 0};
        int[] resultado = euclidesEstendido(b, a % b);
        int mdc = resultado[0];
        int x = resultado[2];
        int y = resultado[1] - (a / b) * resultado[2];
        return new int[]{mdc, x, y};
    }
}
