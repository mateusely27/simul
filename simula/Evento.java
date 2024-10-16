/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.simulador;

/**
 *
 * @author teteu
 */
public class Evento implements Comparable<Evento> {
    private String tipo; // tipo (chegada, saída ou passagem)
    private double tempo;

    public Evento(String tipo, double tempo) {
        this.tipo = tipo;
        this.tempo = tempo;
    }
    public Evento() {       
        this.tipo = "null";
        this.tempo = 0.0;
    }
    

    public String getTipo() {
        return tipo;
    }

    public double getTempo() {
        return tempo;
    }

    @Override
    public int compareTo(Evento outroEvento) {
        return Double.compare(this.tempo, outroEvento.getTempo());
    }
}



