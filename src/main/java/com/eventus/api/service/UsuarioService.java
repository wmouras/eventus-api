package com.eventus.api.service;

import com.eventus.api.domain.Usuario;
import com.eventus.api.domain.dto.UsuarioDTO;
import com.eventus.api.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@AllArgsConstructor
@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public Long save(UsuarioDTO vO) {
        Usuario bean = new Usuario();
        BeanUtils.copyProperties(vO, bean);
        bean = usuarioRepository.save(bean);
        return bean.getIdUsuario();
    }

    public void delete(Long id) {
        usuarioRepository.deleteById(id);
    }

    public void update(Long id, UsuarioDTO vO) {
        Usuario bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        usuarioRepository.save(bean);
    }

    public UsuarioDTO getById(Long id) {
        Usuario original = requireOne(id);
        return toDTO(original);
    }

    public Page<UsuarioDTO> query(UsuarioDTO vO) {
        throw new UnsupportedOperationException();
    }

    private UsuarioDTO toDTO(Usuario original) {
        UsuarioDTO bean = new UsuarioDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private Usuario requireOne(Long id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
