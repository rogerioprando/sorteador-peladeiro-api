package com.rogerio.peladeiro.modelo;

import javax.persistence.*;

@Entity
public class Jogador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @Enumerated(EnumType.STRING)
    private Posicao posicao;
    @Enumerated(EnumType.STRING)
    private Time time;
    @ManyToOne
    private Partida partida;
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

    //TODO: Atributos que vão pertencer ao jogador:
    // private Boolean mensalista;
    // private Nota nota;


    public Jogador(String nome, Posicao posicao,
                   int passe, int finalizacao, int desarme, int cobertura, int lancamento, int drible,
                   int fominha, int chuteLongo, int velocidade, int forca, int dominio, int folego, double nota) {
        this.nome = nome;
        this.posicao = posicao;
        this.passe = passe;
        this.finalizacao = finalizacao;
        this.desarme = desarme;
        this.cobertura = cobertura;
        this.lancamento = lancamento;
        this.drible = drible;
        this.fominha = fominha;
        this.chuteLongo = chuteLongo;
        this.velocidade = velocidade;
        this.forca = forca;
        this.dominio = dominio;
        this.folego = folego;
        this.nota = nota;
    }

    public Jogador() {

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

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Posicao getPosicao() {
        return posicao;
    }

    public void setPosicao(Posicao posicao) {
        this.posicao = posicao;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public Partida getPartida() {
        return partida;
    }

    public void setPartida(Partida partida) {
        this.partida = partida;
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

    public void setFinalizacao(int chute) {
        this.finalizacao = chute;
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
}
