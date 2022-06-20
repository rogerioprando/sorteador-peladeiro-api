package com.rogerio.peladeiro.controller.dto;

import com.rogerio.peladeiro.modelo.Jogador;
import com.rogerio.peladeiro.modelo.Posicao;
import org.springframework.data.domain.Page;

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
