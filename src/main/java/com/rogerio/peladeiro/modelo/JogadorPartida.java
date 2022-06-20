package com.rogerio.peladeiro.modelo;

import javax.persistence.*;

@Entity(name = "jogadores_partida")
public class JogadorPartida {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Jogador jogador;

    @ManyToOne(fetch = FetchType.LAZY)
    private Partida partida;

    public JogadorPartida() {

    }

    public JogadorPartida(Long id, Jogador jogador, Partida partida) {
        this.id = id;
        this.jogador = jogador;
        this.partida = partida;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Jogador getJogador() {
        return jogador;
    }

    public void setJogador(Jogador jogador) {
        this.jogador = jogador;
    }

    public Partida getPartida() {
        return partida;
    }

    public void setPartida(Partida partida) {
        this.partida = partida;
    }
}
