package com.juliuseconomyapi.backend.model;


import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

// @Entity diz ao jpa que essa classe representa uma tabela no banco de dados
@Entity

@Table(name = "finance")
public class Finance {

    @Id
    // Id gerado automaticamente pelo banco
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 150)
    private String description;

   
    @Column(nullable = false)
    private BigDecimal value;

    @Column(length = 50)
    private String category;

    // Guarda como String no formato de data padrao(como do pc)
    @Column(name = "data_despesa")
    private LocalDate date;

    @Column(nullable = false)
    private Boolean ok = false;

    //o jpa precisa de um construtor vazio para ciar obj 
    public Finance() {
    }

    // recebe os dados do financedto
    //ok começa sempre como false
    public Finance(String description, BigDecimal value, String category, LocalDate date) {
        this.description = description;
        this.value = value;
        this.category = category;
        this.date = date;
        this.ok = false;
    }

//getters e setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Boolean getOk() {
        return ok;
    }

    public void setOk(Boolean ok) {
        this.ok = ok;
    }

    // mostra os dados fomatados 
    @Override
    public String toString() {
        return "Despesas{" +
                "id=" + id +
                ", descrição='" + description + '\'' +
                ", valor=" + value +
                ", categoria='" + category + '\'' +
                ", data='" + date + '\'' +
                ", paga=" + ok +
                '}';
    }

}

