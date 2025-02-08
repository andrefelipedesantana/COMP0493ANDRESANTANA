package GeometriaComputacional;

class Ponto {
    double x, y;

    Ponto(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public static double distancia(Ponto p1, Ponto p2) {
        return Math.sqrt(Math.pow(p2.x - p1.x, 2) + Math.pow(p2.y - p1.y, 2));
    }

    public static double distanciaPontoReta(Ponto ponto, double a, double b, double c) {
        return Math.abs(a * ponto.x + b * ponto.y + c) / Math.sqrt(a * a + b * b);
    }

    public static Ponto intersecaoRetas(double a1, double b1, double c1, double a2, double b2, double c2) {
        
        double det = a1 * b2 - a2 * b1;
        
        if (det == 0) {
            return null;
        }
        
        double x = (b1 * c2 - b2 * c1) / det;
        double y = (c1 * a2 - c2 * a1) / det;
        
        return new Ponto(x, y);
    }
}


public class Main {

    public static double areaSeccaoTransversal(double raio) {
        return Math.PI * Math.pow(raio, 2); 
    }
    
    public static void main(String[] args) {

        Ponto p1 = new Ponto(1, 2);
        Ponto p2 = new Ponto(4, 6);

        double distanciaEntrePontos = Ponto.distancia(p1, p2);
        System.out.println("Distância entre os pontos: " + distanciaEntrePontos);
        

        double distanciaReta = Ponto.distanciaPontoReta(p1, 1, 1, -5);
        System.out.println("Distância do ponto até a reta: " + distanciaReta);

        double area = areaSeccaoTransversal(3);
        System.out.println("Área da seção transversal do cilindro: " + area);
        
        Ponto intersecao = Ponto.intersecaoRetas(1, 1, -5, 2, -1, 1);
        
        if (intersecao != null) {
            System.out.println("Interseção das retas: (" + intersecao.x + ", " + intersecao.y + ")");
        } else {
            System.out.println("As retas são paralelas e não têm interseção.");
        }
    }
}
