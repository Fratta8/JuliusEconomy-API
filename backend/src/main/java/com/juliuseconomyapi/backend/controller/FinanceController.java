package com.juliuseconomyapi.backend.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gastos.api.dto.DespesaDTO;
import com.gastos.api.service.DespesaService;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/finance")
@Tag(name = "Finance", description = "CRUD operations for Finance ")

public class FinanceController {

    private final FinanceService financeService;
    public FinanceController(FinanceService financeservice){
        this.financeService = financeservice;

    }
    @GetMapping
    public List<FinanceDTO> getAll(){
        return financeService.getAllFinaces();
    }
    @GetMapping("/{id}")
    public ResponseEntity<FinanceDTO> getById(@PathVariable Long id){
        return financeService.getFinanceById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    
    }

    @PostMapping
    public ResponseEntity<FinanceDTO> create(@Valid @RequestBody FinanceDTO financeDTO){
        return ResponseEntity.status(201).body(financeService.createFinance(financeDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<FinanceDTO> update(@PathVariable Long id, @Valid @RequestBody FinanceDTO financeDTO){
        return financeService.updateFinance(id, financeDTO) 
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        return financeService.deleteFinance(id)
                ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();
    }

    @PatchMapping("/{id}/aprove")
    public ResponseEntity<FinanceDTO> Aprove(@PathVariable Long id){
        return financeService.Aprove(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    }

