package com.rogerio.futmanager.controller.form;

import com.rogerio.futmanager.modelo.Jogador;
import com.rogerio.futmanager.modelo.Posicao;
import com.rogerio.futmanager.repository.JogadorRepository;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDate;

public class JogadorForm {

    private String nome;
    private LocalDate nascimento;
    private Posicao posicao;

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

    public Jogador converter(){
        /*
        * Se jogador tiver alguma relação aqui pode ser feita a conversão
        * recebe o repository, busca relação e devolve new Jogador.
        */

        return new Jogador(nome, nascimento, posicao);

    }

    public Jogador atualizar(Long id, JogadorRepository jogadorRepository) {
        // getById pois tem-se certeza que o Id existe (validado antes de chamar o atualizar)
        Jogador jogador = jogadorRepository.getById(id);
        jogador.setNome(this.nome);
        jogador.setNascimento(this.nascimento);
        jogador.setPosicao(this.posicao);

        return jogador;
    }
}
