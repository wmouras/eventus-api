package com.eventus.api.service;

import com.eventus.api.domain.Evento;
import com.eventus.api.domain.dto.EventoDTO;
import com.eventus.api.repository.EventoRepository;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.NoResultException;
import lombok.AllArgsConstructor;
import org.bouncycastle.asn1.cms.OtherRecipientInfo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@AllArgsConstructor
@Service
@JsonInclude
public class EventoService {

    private final EventoRepository repository;

    public Long save(EventoDTO dto) {

        Evento bean = new Evento();
        BeanUtils.copyProperties(dto, bean);
        bean = repository.save(bean);
        return bean.getId();
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public void update(Long id, EventoDTO dto) {
        Evento bean = requireOne(id);
        BeanUtils.copyProperties(dto, bean);
        repository.save(bean);
    }

    public EventoDTO getById(Long id) {
        Evento original = requireOne(id);
        return toDTO(original);
    }

    public List<EventoDTO> query(EventoDTO eventoDTO) {

        ModelMapper mapper = new ModelMapper();
        List<Evento> lista = repository.findAllByDsEventoContainingIgnoreCaseAndNoEventoContainingIgnoreCase(eventoDTO.getDsEvento(), eventoDTO.getNoEvento())
                .orElseThrow(NoResultException::new);

        return lista.stream().map(e -> mapper.map(e, EventoDTO.class)).toList();
    }

    private EventoDTO toDTO(Evento original) {
        EventoDTO bean = new EventoDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private Evento requireOne(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
