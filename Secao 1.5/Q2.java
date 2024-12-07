import java.util.ArrayList;
import java.util.Scanner;

public class Q2 {
    public static void main(String[] args){

        String TTT = "I love CS3233 Competitive Programming. i also love AlGoRiThM";
        Scanner entrada = new Scanner(System.in);
        String substring;
        ArrayList<Integer> indices = new ArrayList<>();
        boolean n = false;

        String PPP = entrada.nextLine();

        for (int i = 0; i <= TTT.length() - PPP.length(); i++) {
            substring = TTT.substring(i, i + PPP.length());
            if (substring.equals(PPP)) {
                indices.add(i);
                n = true;
            }
        }

        if(!n){
            System.out.println("-1");
            return;
        }
        System.out.println(indices);
    }
}
