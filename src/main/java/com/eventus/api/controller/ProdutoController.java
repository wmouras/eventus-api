package com.eventus.api.controller;

import com.eventus.api.domain.dto.ProdutoDTO;
import com.eventus.api.service.ProdutoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Api(tags = "")
@Validated
@RestController
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @PostMapping
    @ApiOperation("Save ")
    public String save(@Valid @RequestBody ProdutoDTO vO) {
        return produtoService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Delete ")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        produtoService.delete(id);
    }

    @PutMapping("/{id}")
    @ApiOperation("Update ")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody ProdutoDTO vO) {
        produtoService.update(id, vO);
    }

    @GetMapping("/{id}")
    @ApiOperation("Retrieve by ID ")
    public ProdutoDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return produtoService.getById(id);
    }

    @GetMapping
    @ApiOperation("Retrieve by query ")
    public Page<ProdutoDTO> query(@Valid ProdutoDTO vO) {
        return produtoService.query(vO);
    }
}
