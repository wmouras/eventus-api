package com.eventus.api.controller;

import com.eventus.api.domain.dto.TicketDTO;
import com.eventus.api.service.TicketService;
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
@RequestMapping("/ticket")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @PostMapping
    @ApiOperation("Save ")
    public String save(@Valid @RequestBody TicketDTO vO) {
        return ticketService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Delete ")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        ticketService.delete(id);
    }

    @PutMapping("/{id}")
    @ApiOperation("Update ")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody TicketDTO vO) {
        ticketService.update(id, vO);
    }

    @GetMapping("/{id}")
    @ApiOperation("Retrieve by ID ")
    public TicketDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return ticketService.getById(id);
    }

    @GetMapping
    @ApiOperation("Retrieve by query ")
    public Page<TicketDTO> query(@Valid TicketDTO vO) {
        return ticketService.query(vO);
    }
}
