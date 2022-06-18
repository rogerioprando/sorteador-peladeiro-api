package com.rogerio.futmanager.controller.dto;

import com.rogerio.futmanager.modelo.Jogador;
import com.rogerio.futmanager.modelo.Posicao;
import org.springframework.data.domain.Page;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class JogadorDto {

    private Long id;
    private String nome;
    private Posicao posicao;
    private double nota;


    public JogadorDto(Jogador jogador) {
        this.id = jogador.getId();
        this.nome = jogador.getNome();
        this.posicao = jogador.getPosicao();
        this.nota = jogador.getNota();
    }


    public static Page<JogadorDto> converter(Page<Jogador> jogadores) {
//        List<JogadorDto> jogadorList = new ArrayList<>();
//
//        for (Jogador jogador :jogadores){
//            jogadorList.add(new JogadorDto(jogador));
//        }
//        return  jogadorList;
        return jogadores.map(JogadorDto::new);
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

    public double getNota() {
        return nota;
    }
}
