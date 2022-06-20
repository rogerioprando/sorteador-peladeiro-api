package com.rogerio.peladeiro.modelo;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Partida {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate data;
    @Enumerated(EnumType.STRING)
    private Time vencedor;

    @OneToMany(mappedBy = "partida")
    private List<Jogador> jogadores = new ArrayList<>();

    public Partida() {

    }

    public Partida(LocalDate data, Time vencedor, List<Jogador> jogadores) {
        this.data = data;
        this.vencedor = vencedor;
        this.jogadores = jogadores;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Time getVencedor() {
        return vencedor;
    }

    public void setVencedor(Time vencedor) {
        this.vencedor = vencedor;
    }

    public List<Jogador> getJogadores() {
        return jogadores;
    }

    public void setJogadores(List<Jogador> jogadores) {
        this.jogadores = jogadores;
    }
}
