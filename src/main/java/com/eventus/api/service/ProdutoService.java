package com.eventus.api.service;

import com.eventus.api.domain.Produto;
import com.eventus.api.domain.dto.ProdutoDTO;
import com.eventus.api.repository.ProdutoRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@AllArgsConstructor
@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    public Long save(ProdutoDTO vO) {
        Produto bean = new Produto();
        BeanUtils.copyProperties(vO, bean);
        bean = produtoRepository.save(bean);
        return bean.getIdProduto();
    }

    public void delete(Long id) {
        produtoRepository.deleteById(id);
    }

    public void update(Long id, ProdutoDTO vO) {
        Produto bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        produtoRepository.save(bean);
    }

    public ProdutoDTO getById(Long id) {
        Produto original = requireOne(id);
        return toDTO(original);
    }

    public Page<ProdutoDTO> query(ProdutoDTO vO) {
        throw new UnsupportedOperationException();
    }

    private ProdutoDTO toDTO(Produto original) {
        ProdutoDTO bean = new ProdutoDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private Produto requireOne(Long id) {
        return produtoRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
