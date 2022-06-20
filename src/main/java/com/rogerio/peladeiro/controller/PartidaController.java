package com.rogerio.peladeiro.controller;

import com.rogerio.peladeiro.controller.dto.PartidaDto;
import com.rogerio.peladeiro.controller.form.PartidaForm;
import com.rogerio.peladeiro.modelo.Partida;
import com.rogerio.peladeiro.repository.JogadorRepository;
import com.rogerio.peladeiro.repository.PartidaRepository;
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
