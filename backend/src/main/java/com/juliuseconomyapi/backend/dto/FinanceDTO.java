package com.juliuseconomyapi.backend.dto;


import java.math.BigDecimal;
import java.time.LocalDate;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

// @Schema documentacao para o swagger
@Schema(description = "Despesa Data Transfer Object")
public class FinanceDTO {

    // o id é gerado pelo banco, nao é necessario perguntar ao usuario
    @Schema(description = "Identificador único da despesa",
            example = "1",
            accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;

    @NotBlank(message = "descrição é necessária")
    @Size(max = 150, message = "descrição não pode ultrapassar 150 caracteres")
    @Schema(description = "Descrição da despesa", example = "Conta de luz")
    private String description;

    @NotNull(message = "valor é necessário")
    @Positive(message = "valor deve ser maior que 0")
    @Schema(description = "Valor da despesa", example = "111.11")
    private BigDecimal value;

    @Size(max = 50, message = "categoria não pode ultrapassar 50 caracteres")
    @Schema(description = "Categoria da despesa", example = "Moradia")
    private String category;

    // @Pattern nao pd validar valores nulos
    @Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}$", message = "date must be in format AAAA-MM-DD")
    @Schema(description = "Data da despesa no formato AAAA-MM-DD", example = "2026-09-17")
    private LocalDate date;

    // valor do ok nao pd ser alterado pelo usuario
    @Schema(description = "Indica se a despesa já foi paga",
            example = "false",
            accessMode = Schema.AccessMode.READ_ONLY)
    private Boolean ok;

    public FinanceDTO() {
    }

    public FinanceDTO(Long id, String description, BigDecimal value, String category, LocalDate date, Boolean ok) {
        this.id = id;
        this.description = description;
        this.value = value;
        this.category = category;
        this.date = date;
        this.ok = ok;
    }

    // gettres e setters
    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getValue() {
        return value;
    }

    public String getCategory() {
        return category;
    }

    public LocalDate getDate() {
        return date;
    }

    public Boolean getOk() {
        return ok;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDescription(String descricao) {
        this.description = descricao;
    }

    public void setValue(BigDecimal valor) {
        this.value = valor;
    }

    public void setCategory(String categoria) {
        this.category = categoria;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setOk(Boolean ok) {
        this.ok = ok;
    }

}
