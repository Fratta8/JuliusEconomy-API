package com.gastos.api.dto;

import java.math.BigDecimal;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

// @Schema documenta essa classe na interface do Swagger.
@Schema(description = "Despesa Data Transfer Object")
public class DespesaDTO {

    // READ_ONLY: o cliente não envia o id, ele é gerado no banco.
    @Schema(description = "Identificador único da despesa",
            example = "1",
            accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;

    @NotBlank(message = "descricao is required")
    @Size(max = 150, message = "descricao must not exceed 150 characters")
    @Schema(description = "Descrição da despesa", example = "Conta de luz")
    private String descricao;

    @NotNull(message = "valor is required")
    @Positive(message = "valor must be greater than zero")
    @Schema(description = "Valor da despesa", example = "150.75")
    private BigDecimal valor;

    @Size(max = 50, message = "categoria must not exceed 50 characters")
    @Schema(description = "Categoria da despesa", example = "Moradia")
    private String categoria;

    // Pattern não valida valores nulos, então o campo continua opcional.
    @Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}$", message = "data must be in format AAAA-MM-DD")
    @Schema(description = "Data da despesa no formato AAAA-MM-DD", example = "2026-09-17")
    private String data;

    // READ_ONLY: "paga" só é alterada pelo endpoint PATCH /marcar-paga,
    // não pelo cliente via POST/PUT.
    @Schema(description = "Indica se a despesa já foi paga",
            example = "false",
            accessMode = Schema.AccessMode.READ_ONLY)
    private Boolean paga;

    public DespesaDTO() {
    }

    public DespesaDTO(Long id, String descricao, BigDecimal valor, String categoria, String data, Boolean paga) {
        this.id = id;
        this.descricao = descricao;
        this.valor = valor;
        this.categoria = categoria;
        this.data = data;
        this.paga = paga;
    }

    // Getters
    public Long getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getData() {
        return data;
    }

    public Boolean getPaga() {
        return paga;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setPaga(Boolean paga) {
        this.paga = paga;
    }

}
