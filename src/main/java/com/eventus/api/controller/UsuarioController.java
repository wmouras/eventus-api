package com.eventus.api.controller;

import com.eventus.api.domain.dto.UserDTO;
import com.eventus.api.service.UserService;
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

    private final UserService usuarioService;

    @PostMapping
    @ApiOperation("Save ")
    public String save(@Valid @RequestBody UserDTO vO) {
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
                       @Valid @RequestBody UserDTO vO) {
        usuarioService.update(id, vO);
    }

    @GetMapping("/{id}")
    @ApiOperation("Retrieve by ID ")
    public UserDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return usuarioService.getById(id);
    }

    @GetMapping
    @ApiOperation("Retrieve by query ")
    public Page<UserDTO> query(@Valid UserDTO vO) {
        return usuarioService.query(vO);
    }
}
