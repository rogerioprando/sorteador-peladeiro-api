package com.rogerio.futmanager.controller.dto;

import com.rogerio.futmanager.modelo.Jogador;
import com.rogerio.futmanager.modelo.Posicao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class JogadorDto {

    private Long id;
    private String nome;
    private Posicao posicao;
    private int passe;
    private int chute;
    private double nota;


    public JogadorDto(Jogador jogador) {
        this.id = jogador.getId();
        this.nome = jogador.getNome();
        this.posicao = jogador.getPosicao();
        this.passe = jogador.getPasse();
        this.chute = jogador.getChute();
        this.nota = jogador.getNota();
    }


    public static List<JogadorDto> converter(List<Jogador> jogadores) {
        List<JogadorDto> jogadorList = new ArrayList<>();

        for (Jogador jogador :jogadores){
            jogadorList.add(new JogadorDto(jogador));
        }
        return  jogadorList;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Posicao getPosicao() {
        return posicao;
    }

    public int getPasse() {
        return passe;
    }

    public int getChute() {
        return chute;
    }

    public double getNota() {
        return nota;
    }
}
