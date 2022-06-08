package com.rogerio.futmanager.controller.form;

import com.rogerio.futmanager.modelo.Jogador;
import com.rogerio.futmanager.modelo.Posicao;
import com.rogerio.futmanager.repository.JogadorRepository;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDate;

public class JogadorForm {

    private String nome;
    private Posicao posicao;
    private int passe;
    private int chute;
    private double nota;

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

    public Jogador converter(){
        /*
        * Se jogador tiver alguma relação aqui pode ser feita a conversão
        * recebe o repository, busca relação e devolve new Jogador.
        */

        return new Jogador(nome, posicao, passe, chute, nota);

    }

    public Jogador atualizar(Long id, JogadorRepository jogadorRepository) {
        // getById pois tem-se certeza que o Id existe (validado antes de chamar o atualizar)
        Jogador jogador = jogadorRepository.getById(id);
        jogador.setNome(this.nome);
        jogador.setPosicao(this.posicao);
        jogador.setChute(this.chute);
        jogador.setPasse(this.passe);
        jogador.setNota(this.nota);

        return jogador;
    }
}
