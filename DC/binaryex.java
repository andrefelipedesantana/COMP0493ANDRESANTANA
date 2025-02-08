package DC;

public class binaryex {

    public static long potencia(long base, long expoente) {
        long resultado = 1;
        while (expoente > 0) {
            if ((expoente & 1) == 1) { 
                resultado *= base;
            }
            base *= base; 
            expoente >>= 1; 
        }
        return resultado;
    }

    public static void main(String[] args) {
        long base = 2;
        long expoente = 10;
        long resultado = potencia(base, expoente);

        System.out.println(base + "^" + expoente + " = " + resultado);
    }
}
