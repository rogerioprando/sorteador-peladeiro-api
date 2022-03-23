package com.rogerio.futmanager.controller;

import com.rogerio.futmanager.controller.dto.JogadorDto;
import com.rogerio.futmanager.modelo.Jogador;
import com.rogerio.futmanager.repository.JogadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
public class JogadoresController {


    @Autowired
    private JogadorRepository jogadorRepository;

    @RequestMapping("/jogadores")
    public List<JogadorDto> listJogadores(String nomeJogador){

        List<Jogador> jogadores = jogadorRepository.findAll();

        return JogadorDto.converter(jogadores);
    }
}
