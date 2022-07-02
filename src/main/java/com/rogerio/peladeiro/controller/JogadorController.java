package com.rogerio.peladeiro.controller;

import com.rogerio.peladeiro.controller.dto.JogadorDto;
import com.rogerio.peladeiro.controller.dto.JogadorDtoDetalhado;
import com.rogerio.peladeiro.controller.form.JogadorForm;
import com.rogerio.peladeiro.modelo.Jogador;
import com.rogerio.peladeiro.repository.JogadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/jogadores")
public class JogadorController {

    @Autowired
    private JogadorRepository jogadorRepository;

    @GetMapping
    public Page<JogadorDto> listar(@PageableDefault(sort = "id", size = 20, direction = Sort.Direction.ASC) Pageable paginacao) {
        // /jogadores?page=0&size=20&sort=id,asc
        Page<Jogador> jogadores = jogadorRepository.findAll(paginacao);

        return JogadorDto.converter(jogadores);
    }

    @PostMapping
    public ResponseEntity<JogadorDto> cadastrar(@RequestBody @Valid JogadorForm form, UriComponentsBuilder uriBuilder) {
        Jogador jogador = form.converter();     // Por enquanto sem nenhuma relação, não passa nada pro converter().
        jogadorRepository.save(jogador);

        // Devolve via HTTP o JSON do objeto criado e persistido
        URI uri = uriBuilder.path("jogador/{id}").buildAndExpand(jogador.getId()).toUri();
        return ResponseEntity.created(uri).body(new JogadorDto(jogador));
    }

    // TODO: Criar um JogadorDto detalhado para os futuros atributos do Jogador.
    @GetMapping("/{id}")
    public ResponseEntity<JogadorDtoDetalhado> detalhar(@PathVariable Long id) {
        Optional<Jogador> jogador = jogadorRepository.findById(id);
        if (jogador.isPresent()) {
            return ResponseEntity.ok(new JogadorDtoDetalhado(jogador.get()));
        }
        return ResponseEntity.notFound().build();
        //return jogador.map(value -> ResponseEntity.ok(new JogadorDto(value))).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // TODO: Para controlar melhor os parâmetros que podem ser atualizados criar um JogadorFormDeAtualizacao
    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<JogadorDto> atualizar(@PathVariable Long id, @RequestBody @Valid JogadorForm form) {
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
