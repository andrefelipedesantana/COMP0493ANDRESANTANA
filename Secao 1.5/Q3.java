public class Q3 {
    public static void main(String[] args){

        String TTT = "I love CS3233 Competitive Programming. i also love AlGoRiThM";

        int vogais = 0, consoantes = 0, digitos = 0;
        TTT = TTT.toLowerCase();

        for (int i = 0; i < TTT.length(); i++) {
            char caractere = TTT.charAt(i);
            if(Character.isDigit(caractere)) digitos++;
            else if(caractere == 'a' || caractere == 'e' || caractere== 'i' || caractere == 'o' || caractere == 'u') vogais++;
            else if(Character.isLetter(caractere)) consoantes++;
        }

        System.out.println(TTT);
        System.out.println("VOGAIS: " + vogais);
        System.out.println("CONSOANTES: " + consoantes);
        System.out.println("DIGITOS: " + digitos);
    }
}

