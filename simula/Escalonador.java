package com.mycompany.simulador;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 *
 * @author teteu
 */
public class Escalonador {
    private Queue<Evento> filaProcessos;

    public Escalonador() {
        // Inicializa a fila como uma PriorityQueue, assumindo que Evento implementa Comparable
        this.filaProcessos = new PriorityQueue<>();
    }

    public void agendaSaida(double tempo) {
        Evento eventoSaida = new Evento("saida", tempo);
        filaProcessos.add(eventoSaida);
    }

    public void agendaChegada(double tempo) {
        Evento eventoChegada = new Evento("chegada", tempo);
        filaProcessos.add(eventoChegada);
    }
    
    public void agendaPassagem(double tempo) {
        Evento eventoPassagem = new Evento("passagem", tempo);
        filaProcessos.add(eventoPassagem);
    }
    
    public Evento nextEvento(){
       Evento e = new Evento();
        if(!filaProcessos.isEmpty()){
          e = filaProcessos.poll();
        }
      
        return e;
    }
    
}
