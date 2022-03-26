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
    private LocalDate nascimento;
    @Enumerated(EnumType.STRING)
    private Posicao posicao;
    @Enumerated(EnumType.STRING)
    private Time time;
    @ManyToOne
    private Partida partida;

    //TODO: Atributos que vão pertencer ao jogador:
    // private Boolean mensalista;
    // private Nota nota;


    public Jogador(String nome, LocalDate nascimento, Posicao posicao) {
        this.nome = nome;
        this.nascimento = nascimento;
        this.posicao = posicao;
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

    public LocalDate getNascimento() {
        return nascimento;
    }

    public void setNascimento(LocalDate nascimento) {
        this.nascimento = nascimento;
    }

    public Posicao getPosicao() {
        return posicao;
    }

    public void setPosicao(Posicao posicao) {
        this.posicao = posicao;
    }

}
