package com.rogerio.futmanager.controller;

import com.rogerio.futmanager.controller.dto.JogadorDto;
import com.rogerio.futmanager.controller.form.JogadorForm;
import com.rogerio.futmanager.modelo.Jogador;
import com.rogerio.futmanager.repository.JogadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;


import javax.transaction.Transactional;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/jogadores")
public class JogadorController {

    @Autowired
    private JogadorRepository jogadorRepository;

    @RequestMapping()
    public List<JogadorDto> listaJogadores(String nomeJogador) {

        List<Jogador> jogadores = jogadorRepository.findAll();

        return JogadorDto.converter(jogadores);
    }

    @PostMapping
    public ResponseEntity<JogadorDto> cadastrar(@RequestBody JogadorForm form, UriComponentsBuilder uriBuilder) {
        Jogador jogador = form.converter();     // Por enquanto sem nenhuma relação, não passa nada pro converter().
        jogadorRepository.save(jogador);

        // Devolve via HTTP o JSON do objeto criado e persistido
        URI uri = uriBuilder.path("jogador/{id}").buildAndExpand(jogador.getId()).toUri();
        return ResponseEntity.created(uri).body(new JogadorDto(jogador));
    }

    // TODO: Criar um JogadorDto detalhado para os futuros atributos do Jogador.
    @GetMapping("/{id}")
    public ResponseEntity<JogadorDto> detalhar(@PathVariable Long id) {
        Optional<Jogador> jogador = jogadorRepository.findById(id);
        if (jogador.isPresent()) {
            return ResponseEntity.ok(new JogadorDto(jogador.get()));
        }
        return ResponseEntity.notFound().build();
    }

    // TODO: Para controlar melhor os parâmetros que podem ser atualizados criar um JogadorFormDeAtualizacao
    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<JogadorDto> atualizar(@PathVariable Long id, @RequestBody JogadorForm form) {
        Optional<Jogador> jogadorOptional = jogadorRepository.findById(id);
        if (jogadorOptional.isPresent()) {
            Jogador jogador = form.atualizar(id, jogadorRepository);
            return ResponseEntity.ok(new JogadorDto(jogador));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable Long id) {
        Optional<Jogador> jogador = jogadorRepository.findById(id);
        if (jogador.isPresent()){
            jogadorRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
