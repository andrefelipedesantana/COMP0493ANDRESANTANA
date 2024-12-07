 import java.util.Arrays;

public class Q4 {
    public static void main(String[] args) {

        String TTT = "i love cs3233 competitive programming. i also love algorithm";
        String[] tokens = TTT.split("[ .]+");
        Arrays.sort(tokens);
        System.out.println(Arrays.toString(tokens));
    }
}

