package com.eventus.api.controller;

import com.eventus.api.domain.dto.UsuarioDTO;
import com.eventus.api.service.UsuarioService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@Api(tags = "")
@Validated
@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    private UsuarioService usuarioService;

    @PostMapping
    @ApiOperation("Save ")
    public String save(@Valid @RequestBody UsuarioDTO vO) {
        return usuarioService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Delete ")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        usuarioService.delete(id);
    }

    @PutMapping("/{id}")
    @ApiOperation("Update ")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody UsuarioDTO vO) {
        usuarioService.update(id, vO);
    }

    @GetMapping("/{id}")
    @ApiOperation("Retrieve by ID ")
    public UsuarioDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return usuarioService.getById(id);
    }

    @GetMapping
    @ApiOperation("Retrieve by query ")
    public Page<UsuarioDTO> query(@Valid UsuarioDTO vO) {
        return usuarioService.query(vO);
    }
}
