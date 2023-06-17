package com.eventus.api.controller;

import com.eventus.api.domain.dto.PontoComercialDTO;
import com.eventus.api.service.PontoComercialService;
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
@RequestMapping("/pontoComercial")
public class PontoComercialController {

    private final PontoComercialService pontoComercialService;

    @PostMapping
    @ApiOperation("Save ")
    public String save(@Valid @RequestBody PontoComercialDTO vO) {
        return pontoComercialService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Delete ")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        pontoComercialService.delete(id);
    }

    @PutMapping("/{id}")
    @ApiOperation("Update ")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody PontoComercialDTO vO) {
        pontoComercialService.update(id, vO);
    }

    @GetMapping("/{id}")
    @ApiOperation("Retrieve by ID ")
    public PontoComercialDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return pontoComercialService.getById(id);
    }

    @GetMapping
    @ApiOperation("Retrieve by query ")
    public Page<PontoComercialDTO> query(@Valid PontoComercialDTO vO) {
        return pontoComercialService.query(vO);
    }
}
