/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.simulador;


public class NpseudoAleatorio {
    // Parâmetros do LCG (valores típicos para boas distribuições)
    private long a;  // Multiplicador
    private long c;  // Incremento
    private long m;  // Módulo (limite superior)
    private long seed;  // Semente atual

    // Construtor que inicializa o gerador de números com valores padrão
    public NpseudoAleatorio(long seed) {
        // Parâmetros comuns usados no LCG (exemplo)
        this.a = 1664525L;
        this.c = 1013904223L;
        this.m = (long) Math.pow(2, 32); // Módulo típico para gerar números entre 0 e 2^32
        this.seed = seed;
    }

    // Gera o próximo número pseudo-aleatório na sequência
    private long proximoNumero() {
        seed = (a * seed + c) % m; // Atualiza a semente usando o método do congruente linear
        return seed; // Retorna o próximo número pseudo-aleatório
    }

    // Gera um número aleatório inteiro entre 0 e max (exclusivo)
    public int gerarNumeroInteiro(int max) {
        return (int) (proximoNumero() % max); // Restringe o número ao intervalo [0, max)
    }

    // Gera um número aleatório inteiro entre min e max (inclusivo)
    public int gerarNumeroInteiro(int min, int max) {
        return min + (int) (proximoNumero() % (max - min + 1)); // Gera entre min e max (inclusivo)
    }

    // Gera um número aleatório em ponto flutuante entre 0.0 e 1.0 (exclusivo)
    public double gerarNumeroDouble() {
        return (double) proximoNumero() / m; // Normaliza o número para o intervalo [0.0, 1.0)
    }

    // Gera um número aleatório em ponto flutuante em um intervalo (min e max)
    public double gerarNumeroDouble(double min, double max) {
        return min + (max - min) * gerarNumeroDouble(); // Gera entre min e max
    }

    // Gera um valor booleano aleatório (true ou false)
    public boolean gerarBooleano() {
        return proximoNumero() % 2 == 0; // Se o número for par, retorna true; senão, false
    }

    // Método principal para testar a classe
    
}
