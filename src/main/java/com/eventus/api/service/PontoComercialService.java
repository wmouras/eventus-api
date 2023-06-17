package com.eventus.api.service;

import com.eventus.api.domain.PontoComercial;
import com.eventus.api.domain.dto.PontoComercialDTO;
import com.eventus.api.repository.PontoComercialRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@AllArgsConstructor
@Service
public class PontoComercialService {

    private final PontoComercialRepository pontoComercialRepository;

    public Long save(PontoComercialDTO vO) {
        PontoComercial bean = new PontoComercial();
        BeanUtils.copyProperties(vO, bean);
        bean = pontoComercialRepository.save(bean);
        return bean.getIdPontoComercial();
    }

    public void delete(Long id) {
        pontoComercialRepository.deleteById(id);
    }

    public void update(Long id, PontoComercialDTO vO) {
        PontoComercial bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        pontoComercialRepository.save(bean);
    }

    public PontoComercialDTO getById(Long id) {
        PontoComercial original = requireOne(id);
        return toDTO(original);
    }

    public Page<PontoComercialDTO> query(PontoComercialDTO vO) {
        throw new UnsupportedOperationException();
    }

    private PontoComercialDTO toDTO(PontoComercial original) {
        PontoComercialDTO bean = new PontoComercialDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private PontoComercial requireOne(Long id) {
        return pontoComercialRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
