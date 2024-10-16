package com.mycompany.simulador;

import java.util.LinkedList;

/**
 *
 * @author teteu
 */
public class Fila {
    private int nServidores;
    private int capacity;
    private double minArrivel; //tempo mínimo para chegada de clientes na fila
    private double maxArrivel; //tempo máximo para chegada de clientes na fila
    private double minService; //tempo mínimo de atendimento de clientes
    private double maxService; //tempo máximo de atendimento de clientes
    private int customers; // contabiliza o número de clientes na fila
    private int loss; // contabiliza o número de clientes perdidos
    private double[] tempos; // tempos acumulados na fila

    public Fila() {
        this.tempos = new double[100]; // exemplo com tamanho fixo de 100 posições
    }

    public Fila(int nServidores, int capacity, double minArrivel, double maxArrivel,double minService, double maxService) {
        this.nServidores = nServidores;
        this.capacity = capacity;
        this.minArrivel = minArrivel;
        this.maxArrivel = maxArrivel;
        this.minService = minService;
        this.maxService = maxService;
        this.customers = 0;
        this.loss = 0;
        this.tempos = new double[capacity+1]; 
    }
    
    public int status() {
        return customers;
    }

    public int capacity() {
        return capacity;
    }

    public int servers() { // Ajustei o nome do método para lowercase, seguindo convenção
        return nServidores;
    }

    public void loss() {
       loss = loss+1;
    }

    public void in() {
        customers = customers + 1;
    }

    public void out() {
        customers = customers - 1;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setTempos(int posicao,double valor) {
        if(posicao>=0 && posicao < tempos.length){
            tempos[posicao] = valor;
        }else{
            System.out.println("posicao inalida no arrey de tempos (posicao "+posicao+ ")" );
        }
            
    }
    
     public double getTempo(int posicao) {
        if (posicao < 0 || posicao >= tempos.length) {
            throw new IndexOutOfBoundsException("Posição inválida: " + posicao);
        }
        return tempos[posicao];

     }

    @Override
    public String toString() {
        return tempos.toString();
    }
}
