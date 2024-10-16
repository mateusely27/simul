package com.mycompany.simulador;

import java.util.ArrayList;
import java.util.Stack;
/**
 *
 * @author teteu
 */

public class Simulador {

    public static void main(String[] args) {
        // Corrigido para criar uma nova instância de ArrayList
        NpseudoAleatorio aleatorio = new NpseudoAleatorio(-1);
        Fila f1 = new Fila(1,3,1,2,3,6); // nservidor,capacidade,entrada1,entrada2,saida1,saida2
        Escalonador esc1 = new Escalonador();
        esc1.agendaChegada(2.0); // chegada padrao
       
        int k = 3; // k = capacidade da fila : pode ser f1.getCapacity()
        double[] times = new double[k+1]; // [0][1][2][3]
        times[0] = 0.0;
        
        Stack<Double> pilhaDeDouble = new Stack<>();
        pilhaDeDouble.push(0.3276);
        pilhaDeDouble.push(0.8851);
        pilhaDeDouble.push(0.1643);
        pilhaDeDouble.push(0.5542);
        pilhaDeDouble.push(0.6813);
        pilhaDeDouble.push(0.7221);
        pilhaDeDouble.push(0.9881);
        
        double random = 0.0;
        double tempoEvento = 0;
        double tempoGlobal = 0.0;
        int estadoAtualFila = f1.status(); // estatus inicial da fila(começa igual a 0)
        
        
        int count = 0;
        
        while (!pilhaDeDouble.isEmpty()) {
            Evento e = esc1.nextEvento();  // Obtém o próximo evento do escalonador

            // Corrigido para comparação de strings
            if(e.getTipo().equals("chegada")) {
              //contabiliza tempo
              double aux = tempoGlobal; //tempo antetior
              tempoGlobal =  e.getTempo();
              double delta  = tempoGlobal - aux; 
               estadoAtualFila = f1.status();
              times[estadoAtualFila] = times[estadoAtualFila] + delta;
              
              if(f1.status() < f1.capacity()){
                  f1.in();
                  if(f1.status()<= f1.servers()){
                     
                   random = U(3,6,pilhaDeDouble.remove(0)); 
                  System.out.println(" Agendou SAIDA tempoglobal:"+tempoGlobal + " aleatorio:"+random);
                  
                  tempoEvento =tempoGlobal +random;
                  esc1.agendaSaida(tempoEvento); // antigo :U(3,6,aleatorio.gerarNumeroDouble(0,1))
              }
              }
              else{ f1.loss();}   
                random = U(1,2,pilhaDeDouble.remove(0));  
               System.out.println(" Agendou CHEGADA tempoglobal:"+tempoGlobal + " aleatorio:"+random);
               tempoEvento = tempoGlobal+ random;
              esc1.agendaChegada(tempoEvento);
              
            }else if (e.getTipo().equals("saida")) {
              //contabiliza tempo        
              double aux = tempoGlobal; //tempo antetior
              tempoGlobal = e.getTempo();
              double delta  = tempoGlobal - aux;            
              estadoAtualFila = f1.status();
              times[estadoAtualFila] = times[estadoAtualFila] + delta;
              
             f1.out();
             if(f1.status() >= f1.servers()){  
                random = U(3,6,pilhaDeDouble.remove(0));  
                tempoEvento = tempoGlobal + random;
                System.out.println("Agendou SAIDA:tempoglobal:"+tempoGlobal + " aleatorio:"+random);
                esc1.agendaSaida(tempoEvento); // antigo :U(3,6,aleatorio.gerarNumeroDouble(0,1))
             }
            }
             

            count++;  // Decrementa o contador para evitar loop infinito
        }
        
       for (int i = 0; i < k + 1; i++) {
            System.out.printf("%d: %.2f (%.2f%%)\n", i, times[i], (times[i] / tempoGlobal) * 100);
        }
        
        // teste numeros aleatorios e distribuicao
        double n = 0;
        double x = aleatorio.gerarNumeroDouble();
        n = U(3,6,x);
        System.out.println("Número aleatorio gerado: " + x);
        System.out.println("Número gerado: " + n);
    }

    // Tornando o método U estático para poder ser chamado dentro do main
    public static double U(int a, int b, double aleatorio) {
        return ((b - a) * aleatorio) + a;
    }
}
