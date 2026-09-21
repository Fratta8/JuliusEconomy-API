package com.juliuseconomyapi.backend.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

// @Schema documenta essa classe na interface do Swagger.
@Schema(description = "Despesa Data Transfer Object")
public class FinanceDTO {

    // READ_ONLY: o cliente não envia o id, ele é gerado no banco.
    @Schema(description = "Identificador único da despesa",
            example = "1",
            accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;

    @NotBlank(message = "description is required")
    @Size(max = 150, message = "description must not exceed 150 characters")
    @Schema(description = "Descrição da despesa", example = "Conta de luz")
    private String description;

    @NotNull(message = "value is required")
    @Positive(message = "value must be greater than 0")
    @Schema(description = "Valor da despesa", example = "111.11")
    private double value;

    @Size(max = 50, message = "category must not exceed 50 characters")
    @Schema(description = "Categoria da despesa", example = "Moradia")
    private String category;

    // Pattern não valida valores nulos, então o campo continua opcional.
    @Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}$", message = "date must be in format AAAA-MM-DD")
    @Schema(description = "Data da despesa no formato AAAA-MM-DD", example = "2026-09-17")
    private String date;

    // READ_ONLY: "paga" só é alterada pelo endpoint PATCH /marcar-paga,
    // não pelo cliente via POST/PUT.
    @Schema(description = "Indica se a despesa já foi paga",
            example = "false",
            accessMode = Schema.AccessMode.READ_ONLY)
    private Boolean ok;

    public FinanceDTO() {
    }

    public FinanceDTO(Long id, String description, double value, String category, String date, Boolean ok) {
        this.id = id;
        this.description = description;
        this.value = value;
        this.category = category;
        this.date = date;
        this.ok = ok;
    }

    // Getters
    public Long getId() {
        return id;
    }

    public String getDescricao() {
        return description;
    }

    public double getValor() {
        return value;
    }

    public String getCategoria() {
        return category;
    }

    public String getData() {
        return date;
    }

    public Boolean getPaga() {
        return ok;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setDescricao(String descricao) {
        this.description = descricao;
    }

    public void setValor(double valor) {
        this.value = valor;
    }

    public void setCategoria(String categoria) {
        this.category = categoria;
    }

    public void setData(String data) {
        this.date = data;
    }

    public void setPaga(Boolean paga) {
        this.ok = paga;
    }

}
