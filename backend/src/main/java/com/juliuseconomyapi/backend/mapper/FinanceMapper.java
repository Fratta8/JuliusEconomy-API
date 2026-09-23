package com.juliuseconomyapi.backend.mapper;

import com.juliuseconomyapi.backend.dto.FinanceDTO;
import com.juliuseconomyapi.backend.model.Finance;

//toDTO pega oq veio do banco e transforma em dto
public class FinanceMapper {

    public static FinanceDTO toDTO(Finance finance) {

        return new FinanceDTO(
            finance.getId(),
            finance.getDescription(),
            finance.getValue(),
            finance.getCategory(),
            finance.getDate(),
            finance.getOk());
    }
    //toEntity pega oq veio do dto e transforma em entity

    public static Finance toEntity(FinanceDTO dto) {

        return new Finance(
            dto.getDescription(),
            dto.getValue(),
            dto.getCategory(),
            dto.getDate());
    }
}