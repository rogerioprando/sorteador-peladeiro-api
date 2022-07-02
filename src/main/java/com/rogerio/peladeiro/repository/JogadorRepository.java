package com.rogerio.peladeiro.repository;

import com.rogerio.peladeiro.modelo.Jogador;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JogadorRepository extends JpaRepository<Jogador, Long> {

    Jogador findByNome(String nome);


}
