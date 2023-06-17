package com.eventus.api.service;

import com.eventus.api.domain.Perfil;
import com.eventus.api.domain.dto.PerfilDTO;
import com.eventus.api.repository.PerfilRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@AllArgsConstructor
@Service
public class PerfilService {

    private final PerfilRepository perfilRepository;

    public Long save(PerfilDTO dto) {
        Perfil bean = new Perfil();
        BeanUtils.copyProperties(dto, bean);
        bean = perfilRepository.save(bean);
        return bean.getIdPerfil();
    }

    public void delete(Long id) {
        perfilRepository.deleteById(id);
    }

    public void update(Long id, PerfilDTO dto) {
        Perfil bean = requireOne(id);
        BeanUtils.copyProperties(dto, bean);
        perfilRepository.save(bean);
    }

    public PerfilDTO getById(Long id) {
        Perfil original = requireOne(id);
        return toDTO(original);
    }

    public Page<PerfilDTO> query(PerfilDTO dto) {
        throw new UnsupportedOperationException();
    }

    private PerfilDTO toDTO(Perfil original) {
        PerfilDTO bean = new PerfilDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private Perfil requireOne(Long id) {
        return perfilRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
