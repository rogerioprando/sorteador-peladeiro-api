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
    private LocalDate nascimento;
    private Posicao posicao;

    public JogadorDto(Long id, String nome, LocalDate nascimento, Posicao posicao) {
        this.id = id;
        this.nome = nome;
        this.nascimento = nascimento;
        this.posicao = posicao;
    }

    public static List<JogadorDto> converter(List<Jogador> jogadores) {
        List<JogadorDto> jogadorList = new ArrayList<>();

        for (Jogador jogador :jogadores){
            jogadorList.add(new JogadorDto(jogador.getId(), jogador.getNome(), jogador.getNascimento(), jogador.getPosicao()));
        }
        return  jogadorList;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public LocalDate getNascimento() {
        return nascimento;
    }

    public Posicao getPosicao() {
        return posicao;
    }
}
