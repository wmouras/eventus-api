package com.eventus.api.controller;

import com.eventus.api.domain.dto.PerfilDTO;
import com.eventus.api.service.PerfilService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@Api(tags = "")
@Validated
@RestController
@RequestMapping("/perfil")
public class PerfilController {

    private final PerfilService perfilService;

    @PostMapping
    @ApiOperation("Save ")
    public String save(@Valid @RequestBody PerfilDTO dto) {
        return perfilService.save(dto).toString();
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Delete ")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        perfilService.delete(id);
    }

    @PutMapping("/{id}")
    @ApiOperation("Update ")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody PerfilDTO vO) {
        perfilService.update(id, vO);
    }

    @GetMapping("/{id}")
    @ApiOperation("Retrieve by ID ")
    public PerfilDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return perfilService.getById(id);
    }

    @GetMapping
    @ApiOperation("Retrieve by query ")
    public Page<PerfilDTO> query(@Valid PerfilDTO dto) {
        return perfilService.query(dto);
    }
}
