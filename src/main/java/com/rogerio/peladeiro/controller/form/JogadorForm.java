package com.rogerio.peladeiro.controller.form;

import com.rogerio.peladeiro.modelo.Jogador;
import com.rogerio.peladeiro.modelo.Posicao;
import com.rogerio.peladeiro.repository.JogadorRepository;

import javax.validation.constraints.*;

public class JogadorForm {

    @NotNull @NotEmpty
    private String nome;
    private Posicao posicao;
    @Min(1) @Max(99)
    private int passe;
    @Min(1) @Max(99)
    private int finalizacao;
    private int desarme;
    private int cobertura;
    private int lancamento;
    private int drible;
    private int fominha;
    private int chuteLongo;
    private int velocidade;
    private int forca;
    private int dominio;
    private int folego;
    @Min(1) @Max(99)
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
        return finalizacao;
    }

    public void setChute(int chute) {
        this.finalizacao = chute;
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

        return new Jogador(nome, posicao,
        passe, finalizacao, desarme, cobertura, lancamento, drible,
        fominha, chuteLongo, velocidade, forca, dominio, folego, nota);

    }

    public Jogador atualizar(Long id, JogadorRepository jogadorRepository) {
        // getById pois tem-se certeza que o Id existe (validado antes de chamar o atualizar)
        Jogador jogador = jogadorRepository.getById(id);
        jogador.setNome(this.nome);
        jogador.setPosicao(this.posicao);
        jogador.setFinalizacao(this.finalizacao);
        jogador.setPasse(this.passe);
        jogador.setNota(this.nota);

        return jogador;
    }
}
