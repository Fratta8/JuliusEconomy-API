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

import com.juliuseconomyapi.backend.dto.FinanceDTO;
import com.juliuseconomyapi.backend.service.FinanceService;

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
    // getAll   rota get q lista todas as despesas
    @GetMapping
    public List<FinanceDTO> getAll(){
        return financeService.getAllFinance();
    }

    //getById   rota get q busca uma despesa pelo id
    @GetMapping("/{id}")
    public ResponseEntity<FinanceDTO> getById(@PathVariable Long id){
        return financeService.getFinanceById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    
    }

    //create   rota post q cria uma despesa
    @PostMapping
    public ResponseEntity<FinanceDTO> create(@Valid @RequestBody FinanceDTO financeDTO){
        return ResponseEntity.status(201).body(financeService.createFinance(financeDTO));
    }

    //update   rota put q atualiza uma despesa
    @PutMapping("/{id}")
    public ResponseEntity<FinanceDTO> update(@PathVariable Long id, @Valid @RequestBody FinanceDTO financeDTO){
        return financeService.updateFinance(id, financeDTO) 
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    //delete   rota delete q deleta uma despesa
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        return financeService.deleteFinance(id)
                ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();
    }

    //aprove   rota patch q marca uma despesa como paga
    @PatchMapping("/{id}/aprove")
    public ResponseEntity<FinanceDTO> approve(@PathVariable Long id){
        return financeService.approve(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    }

