package com.rogerio.futmanager.repository;

import com.rogerio.futmanager.modelo.Jogador;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JogadorRepository extends JpaRepository<Jogador, Long> {

    List<Jogador> findByNome(String nome);


}
