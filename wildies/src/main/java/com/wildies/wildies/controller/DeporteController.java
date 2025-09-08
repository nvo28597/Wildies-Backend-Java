package com.wildies.wildies.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wildies.wildies.dto.request.DeporteRequestDto;
import com.wildies.wildies.dto.response.DeporteResponseDto;
import com.wildies.wildies.service.DeporteService;

import jakarta.validation.Valid;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/deportes")
public class DeporteController {

    private DeporteService deporteService;

    public DeporteController(DeporteService deporteService){
        this.deporteService = deporteService;
    }

    @GetMapping("/{id}")
    public ResponseEntity <DeporteResponseDto> read(@PathVariable Integer id) {
        return ResponseEntity.ok(deporteService.findById(id));
    }

    @GetMapping
    public ResponseEntity <List <DeporteResponseDto>> readAll() {
        return ResponseEntity.ok(deporteService.findAll());
    }

    @PostMapping
    public ResponseEntity<DeporteResponseDto> create(@Valid @RequestBody DeporteRequestDto deporteRequestDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(deporteService.save(deporteRequestDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity <DeporteResponseDto> update(@PathVariable Integer id, @Valid @RequestBody DeporteRequestDto deporteRequestDto){
        return ResponseEntity.ok(deporteService.update(id, deporteRequestDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity <?> delete(@PathVariable Integer id){
        return ResponseEntity.noContent().build();
    }
 
}
