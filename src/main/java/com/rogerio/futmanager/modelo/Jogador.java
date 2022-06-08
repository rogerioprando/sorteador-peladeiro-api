package com.rogerio.futmanager.modelo;

import java.time.LocalDate;
import java.util.List;
import javax.persistence.*;

@Entity
public class Jogador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @Enumerated(EnumType.STRING)
    private Posicao posicao;
    @Enumerated(EnumType.STRING)
    private Time time;
    @ManyToOne
    private Partida partida;
    private int passe;
    private int chute;
    private double nota;

    //TODO: Atributos que vão pertencer ao jogador:
    // private Boolean mensalista;
    // private Nota nota;


    public Jogador(String nome, Posicao posicao, int passe, int chute, double nota) {
        this.nome = nome;
        this.posicao = posicao;
        this.passe = passe;
        this.chute = chute;
        this.nota = nota;
    }

    public Jogador() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Posicao getPosicao() {
        return posicao;
    }

    public void setPosicao(Posicao posicao) {
        this.posicao = posicao;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public Partida getPartida() {
        return partida;
    }

    public void setPartida(Partida partida) {
        this.partida = partida;
    }

    public int getPasse() {
        return passe;
    }

    public void setPasse(int passe) {
        this.passe = passe;
    }

    public int getChute() {
        return chute;
    }

    public void setChute(int chute) {
        this.chute = chute;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }
}
