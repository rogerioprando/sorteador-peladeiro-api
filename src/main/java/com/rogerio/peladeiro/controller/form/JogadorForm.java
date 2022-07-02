package com.rogerio.peladeiro.controller.form;

import com.rogerio.peladeiro.modelo.Jogador;
import com.rogerio.peladeiro.modelo.Posicao;
import com.rogerio.peladeiro.repository.JogadorRepository;

import javax.validation.constraints.*;

public class JogadorForm {

    @NotNull @NotEmpty
    private String nome;
    private Posicao posicao;
    @Min(1) @Max(100)
    private int passe;
    @Min(1) @Max(100)
    private int finalizacao;
    @Min(1) @Max(100)
    private int desarme;
    @Min(1) @Max(100)
    private int cobertura;
    @Min(1) @Max(100)
    private int lancamento;
    @Min(1) @Max(100)
    private int drible;
    @Min(1) @Max(100)
    private int fominha;
    @Min(1) @Max(100)
    private int chuteLongo;
    @Min(1) @Max(100)
    private int velocidade;
    @Min(1) @Max(100)
    private int forca;
    @Min(1) @Max(100)
    private int dominio;
    @Min(1) @Max(100)
    private int folego;
    @Min(1) @Max(100)
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

    public int getFinalizacao() {
        return finalizacao;
    }

    public void setFinalizacao(int finalizacao) {
        this.finalizacao = finalizacao;
    }

    public int getDesarme() {
        return desarme;
    }

    public void setDesarme(int desarme) {
        this.desarme = desarme;
    }

    public int getCobertura() {
        return cobertura;
    }

    public void setCobertura(int cobertura) {
        this.cobertura = cobertura;
    }

    public int getLancamento() {
        return lancamento;
    }

    public void setLancamento(int lancamento) {
        this.lancamento = lancamento;
    }

    public int getDrible() {
        return drible;
    }

    public void setDrible(int drible) {
        this.drible = drible;
    }

    public int getFominha() {
        return fominha;
    }

    public void setFominha(int fominha) {
        this.fominha = fominha;
    }

    public int getChuteLongo() {
        return chuteLongo;
    }

    public void setChuteLongo(int chuteLongo) {
        this.chuteLongo = chuteLongo;
    }

    public int getVelocidade() {
        return velocidade;
    }

    public void setVelocidade(int velocidade) {
        this.velocidade = velocidade;
    }

    public int getForca() {
        return forca;
    }

    public void setForca(int forca) {
        this.forca = forca;
    }

    public int getDominio() {
        return dominio;
    }

    public void setDominio(int dominio) {
        this.dominio = dominio;
    }

    public int getFolego() {
        return folego;
    }

    public void setFolego(int folego) {
        this.folego = folego;
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
        jogador.setPasse(this.passe);
        jogador.setFinalizacao(this.finalizacao);
        jogador.setDesarme(this.desarme);
        jogador.setCobertura(this.cobertura);
        jogador.setLancamento(this.lancamento);
        jogador.setDrible(this.drible);
        jogador.setFominha(this.fominha);
        jogador.setChuteLongo(this.chuteLongo);
        jogador.setVelocidade(this.velocidade);
        jogador.setForca(this.forca);
        jogador.setDominio(this.dominio);
        jogador.setFolego(this.folego);
        jogador.setNota(this.nota);

        return jogador;
    }
}
