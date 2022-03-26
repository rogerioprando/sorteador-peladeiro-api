package com.rogerio.futmanager.controller.dto;

import com.rogerio.futmanager.modelo.Jogador;
import com.rogerio.futmanager.modelo.Partida;
import com.rogerio.futmanager.modelo.Time;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PartidaDto {

    private Long id;
    private LocalDate data = LocalDate.now();
    private Time vencedor;
    private List<Jogador> jogadores = new ArrayList<>();

    public PartidaDto(Partida partida) {
        this.id = partida.getId();
        this.data = partida.getData();
        this.jogadores = partida.getJogadores();
    }

    public static List<PartidaDto> converter(List<Partida> partidas) {
        List<PartidaDto> partidaDtoList = new ArrayList<>();

        for (Partida partida : partidas){
            partidaDtoList.add(new PartidaDto(partida));
        }
        return partidaDtoList;
    }

    public Long getId() {
        return id;
    }

    public LocalDate getData() {
        return data;
    }

    public Time getVencedor() {
        return vencedor;
    }

    public List<Jogador> getJogadores() {
        return jogadores;
    }

}
