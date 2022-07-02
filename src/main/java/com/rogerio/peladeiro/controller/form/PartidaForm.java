package com.rogerio.peladeiro.controller.form;

import com.rogerio.peladeiro.modelo.Jogador;
import com.rogerio.peladeiro.modelo.Partida;
import com.rogerio.peladeiro.modelo.Time;
import com.rogerio.peladeiro.repository.JogadorRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PartidaForm {

    private String data;
    private Time vencedor;
    private List<JogadorForm> jogadores;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Time getVencedor() {
        return vencedor;
    }

    public void setVencedor(Time vencedor) {
        this.vencedor = vencedor;
    }

    public List<JogadorForm> getJogadores() {
        return jogadores;
    }

    public void setJogadores(List<JogadorForm> jogadores) {
        this.jogadores = jogadores;
    }

        public Partida converter(JogadorRepository jogadorRepository){
        List<Jogador> listaJogadores = new ArrayList<>();
        for(JogadorForm jogador : jogadores){
            Jogador jog1 = jogadorRepository.findByNome(jogador.getNome());
            listaJogadores.add(jog1);
        }

        return new Partida(LocalDate.parse(data), vencedor, listaJogadores);
    }

}
