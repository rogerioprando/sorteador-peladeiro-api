package com.rogerio.futmanager.controller.form;

import com.rogerio.futmanager.modelo.Jogador;
import com.rogerio.futmanager.modelo.Partida;
import com.rogerio.futmanager.modelo.Time;
import com.rogerio.futmanager.repository.JogadorRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PartidaForm {

    private LocalDate data;
    private Time vencedor;
    private List<Jogador> jogadores;

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Time getVencedor() {
        return vencedor;
    }

    public void setVencedor(Time vencedor) {
        this.vencedor = vencedor;
    }

    public List<Jogador> getJogadores() {
        return jogadores;
    }

    public void setJogadores(List<Jogador> jogadores) {
        this.jogadores = jogadores;
    }

    public Partida converter(JogadorRepository jogadorRepository){
        List<Jogador> listaJogadores = new ArrayList<>();
        for(Jogador jogador : jogadores){
            String nome = jogador.getNome();
            Jogador jog1 = (Jogador) jogadorRepository.findByNome(nome);
            listaJogadores.add(jog1);
        }

        return new Partida(data, vencedor, listaJogadores);
    }
}
