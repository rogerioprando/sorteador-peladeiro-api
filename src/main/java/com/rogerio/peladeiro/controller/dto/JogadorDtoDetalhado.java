package com.rogerio.peladeiro.controller.dto;

import com.rogerio.peladeiro.modelo.Jogador;
import com.rogerio.peladeiro.modelo.Posicao;
import org.springframework.data.domain.Page;

public class JogadorDtoDetalhado {

    private Long id;
    private String nome;
    private Posicao posicao;
    private int passe;
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
    private double nota;


    public JogadorDtoDetalhado(Jogador jogador) {
        this.id = jogador.getId();
        this.nome = jogador.getNome();
        this.posicao = jogador.getPosicao();
        this.passe = jogador.getPasse();
        this.finalizacao = jogador.getFinalizacao();
        this.desarme = jogador.getDesarme();
        this.cobertura = jogador.getCobertura();
        this.lancamento = jogador.getLancamento();
        this.drible = jogador.getDrible();
        this.fominha = jogador.getFominha();
        this.chuteLongo = jogador.getChuteLongo();
        this.velocidade = jogador.getVelocidade();
        this.forca = jogador.getForca();
        this.dominio = jogador.getDominio();
        this.folego = jogador.getFolego();
        this.nota = jogador.getNota();
    }


    public static Page<JogadorDtoDetalhado> converter(Page<Jogador> jogadores) {
        return jogadores.map(JogadorDtoDetalhado::new);
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

    public Posicao getPosicao() {
        return posicao;
    }

    public int getPasse() {
        return passe;
    }

    public int getFinalizacao() {
        return finalizacao;
    }

    public double getNota() {
        return nota;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPosicao(Posicao posicao) {
        this.posicao = posicao;
    }

    public void setPasse(int passe) {
        this.passe = passe;
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

    public void setNota(double nota) {
        this.nota = nota;
    }
}
