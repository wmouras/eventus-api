package com.eventus.api.repository;

import com.eventus.api.domain.Evento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EventoRepository extends JpaRepository<Evento, Long> {

    Optional<List<Evento>> findAllByDsEventoContainingIgnoreCaseAndNoEventoContainingIgnoreCase(String dsEvento, String noEvento);

    List<Evento> findAll();

}