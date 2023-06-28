package com.eventus.api.controller;

import com.eventus.api.domain.dto.EventoDTO;
import com.eventus.api.service.EventoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@Api(tags = "")
@Validated
@RestController
@RequestMapping("/evento")
public class EventoController {

    private final EventoService eventoService;

    @PostMapping
    @ApiOperation("Salvar ")
    public String save(@Valid @RequestBody EventoDTO dto) {
        return eventoService.save(dto).toString();
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Delete ")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        eventoService.delete(id);
    }
    @PutMapping("/{id}")
    @ApiOperation("Update ")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody EventoDTO dto) {
        eventoService.update(id, dto);
    }
    @GetMapping("/{id}")
    @ApiOperation("Recuperar pelo ID ")
    public EventoDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return eventoService.getById(id);
    }
    @GetMapping
    @ApiOperation("Consulta ")
    public List<EventoDTO> query(@RequestBody EventoDTO dto) {
        return eventoService.query(dto);
    }
}
