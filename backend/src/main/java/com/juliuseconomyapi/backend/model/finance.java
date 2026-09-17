package com.juliuseconomyapi.backend.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "finance")

public class Finance {

    @Id
    @Generatedvalue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 150)
    private String description;

    @Column(nullable = false)
    private double value;

    @Column(length = 50)
    private String category;

    @Column(name = "date_finance")
    private String date;

    @Column(nullable = false)
    private Boolean paga = false;

    public Finance(String description, double value, String category, String date){

        this.description = description;
        this.value = value;
        this.category = category;
        this.date = date;
        this.paga = false;

    }

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

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Boolean getPaga() {
        return paga;
    }

    public void setPaga(Boolean paga) {
        this.paga = paga;
    }

    @Override
    public String toString() {
        return "Finance{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", value=" + value +
                ", category='" + category + '\'' +
                ", date='" + date + '\'' +
                ", paga=" + paga +
                '}';

}
    
}   
