package com.rogerio.futmanager.controller;

import com.rogerio.futmanager.controller.dto.PartidaDto;
import com.rogerio.futmanager.controller.form.PartidaForm;
import com.rogerio.futmanager.modelo.Jogador;
import com.rogerio.futmanager.modelo.Partida;
import com.rogerio.futmanager.repository.JogadorRepository;
import com.rogerio.futmanager.repository.PartidaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/partida")
public class PartidaController {

    @Autowired
    private PartidaRepository partidaRepository;

    @Autowired
    private JogadorRepository jogadorRepository;

    @RequestMapping
    public List<PartidaDto> listaPartidas(){
        List<Partida> partidas = partidaRepository.findAll();

        return PartidaDto.converter(partidas);
    }

    @PostMapping
    public ResponseEntity<PartidaDto> cadastrar(@RequestBody PartidaForm form, UriComponentsBuilder uriBuilder){
        Partida partida = form.converter(jogadorRepository);
        partidaRepository.save(partida);

        URI uri = uriBuilder.path("partida/{id}").buildAndExpand(partida.getId()).toUri();
        return ResponseEntity.created(uri).body(new PartidaDto(partida));

    }

}
