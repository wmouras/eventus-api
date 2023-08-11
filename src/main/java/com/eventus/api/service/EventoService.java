package com.eventus.api.service;

import com.eventus.api.domain.Evento;
import com.eventus.api.domain.dto.EventoDTO;
import com.eventus.api.repository.EventoRepository;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

@AllArgsConstructor
@Service
@Transactional
@JsonInclude
public class EventoService {

    private final EventoRepository repository;
    private final ModelMapper mapper = new ModelMapper();

    public Long save(EventoDTO dto) {
        return repository.save(mapper.map(dto, Evento.class)).getId();
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public void update(Long id, EventoDTO dto) {
        repository.save(mapper.map(dto, Evento.class));
    }

    public EventoDTO getById(Long id) {
        Evento original = requireOne(id);
        return toDTO(original);
    }

    public List<EventoDTO> query(String dsEvento, String noEvento, LocalDateTime dtEvento) {

        List<Evento> lista = repository.findAll().stream()
                .filter(e -> (Objects.isNull(e.getDtEvento()) || e.getDtEvento().equals(dtEvento))
                        && (Objects.isNull(e.getDsEvento()) || e.getDsEvento().contains(dsEvento))
                         && (Objects.isNull(e.getNoEvento()) || e.getNoEvento().contains(noEvento)))
                .toList();

        return lista.stream().map(e -> mapper.map(e, EventoDTO.class)).toList();
    }

    private EventoDTO toDTO(Evento evento) {
        return mapper.map(evento, EventoDTO.class);
    }

    private Evento requireOne(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
