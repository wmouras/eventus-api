package com.eventus.api.service;

import com.eventus.api.domain.Evento;
import com.eventus.api.domain.dto.EventoDTO;
import com.eventus.api.repository.EventoRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.NoSuchElementException;

@AllArgsConstructor
@Service
public class EventoService {

    private final EventoRepository eventoRepository;

    public Long save(EventoDTO dto) {

        Evento bean = new Evento();
        BeanUtils.copyProperties(dto, bean);
        bean = eventoRepository.save(bean);
        return bean.getIdEvento();
    }

    public void delete(Long id) {
        eventoRepository.deleteById(id);
    }

    public void update(Long id, EventoDTO dto) {
        Evento bean = requireOne(id);
        BeanUtils.copyProperties(dto, bean);
        eventoRepository.save(bean);
    }

    public EventoDTO getById(Long id) {
        Evento original = requireOne(id);
        return toDTO(original);
    }

    public Page<EventoDTO> query(EventoDTO dto) {
        throw new UnsupportedOperationException();
    }

    private EventoDTO toDTO(Evento original) {
        EventoDTO bean = new EventoDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private Evento requireOne(Long id) {
        return eventoRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
