package com.eventus.api.service;

import com.eventus.api.domain.Ticket;
import com.eventus.api.domain.dto.TicketDTO;
import com.eventus.api.repository.TicketRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@AllArgsConstructor
@Service
public class TicketService {

    private final TicketRepository ticketRepository;

    public Long save(TicketDTO vO) {
        Ticket bean = new Ticket();
        BeanUtils.copyProperties(vO, bean);
        bean = ticketRepository.save(bean);
        return bean.getIdTicket();
    }

    public void delete(Long id) {
        ticketRepository.deleteById(id);
    }

    public void update(Long id, TicketDTO vO) {
        Ticket bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        ticketRepository.save(bean);
    }

    public TicketDTO getById(Long id) {
        Ticket original = requireOne(id);
        return toDTO(original);
    }

    public Page<TicketDTO> query(TicketDTO vO) {
        throw new UnsupportedOperationException();
    }

    private TicketDTO toDTO(Ticket original) {
        TicketDTO bean = new TicketDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private Ticket requireOne(Long id) {
        return ticketRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
