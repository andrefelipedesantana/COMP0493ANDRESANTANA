package MetodoGuloso;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Evento {
    String nome;
    int inicio;
    int termino;
    
    public Evento(String nome, int inicio, int termino) {
        this.nome = nome;
        this.inicio = inicio;
        this.termino = termino;
    }
}

public class EscalonamentoDeTarefas {
    public static List<String> selecionarEventos(Evento[] eventos) {
        Arrays.sort(eventos, (a, b) -> Integer.compare(a.termino, b.termino));
        
        List<String> agenda = new ArrayList<>();
        int ultimoTermino = 0;
        
        for (Evento evento : eventos) {
            if (evento.inicio >= ultimoTermino) {
                agenda.add(evento.nome);
                ultimoTermino = evento.termino;
            }
        }
        return agenda;
    }
    
    public static void main(String[] args) {
        Evento[] eventos = {
            new Evento("a", 1, 3),
            new Evento("b", 2, 5),
            new Evento("c", 3, 9),
            new Evento("d", 3, 5),
            new Evento("e", 6, 8)
        };
        
        List<String> resultado = selecionarEventos(eventos);
        System.out.println("Eventos selecionados: " + resultado);
    }
}

