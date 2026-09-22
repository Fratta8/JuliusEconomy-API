package com.juliuseconomyapi.backend.mapper;

import com.juliuseconomyapi.backend.dto.FinanceDTO;
import com.juliuseconomyapi.backend.model.Finance;

public class FinanceMapper {

    public static FinanceDTO toDTO(Finance finance) {

        FinanceDTO dto = new FinanceDTO();

        dto.setId(finance.getId());
        dto.setDescription(finance.getDescription());
        dto.setValue(finance.getValue());
        dto.setCategory(finance.getCategory());
        dto.setDate(finance.getDate());
        dto.setOk(finance.getOk());

        return dto;
    }

    public static Finance toEntity(FinanceDTO dto) {

        Finance finance = new Finance();

        finance.setId(dto.getId());
        finance.setDescription(dto.getDescription());
        finance.setValue(dto.getValue());
        finance.setCategory(dto.getCategory());
        finance.setDate(dto.getDate());
        finance.setOk(dto.getOk());

        return finance;
    }
}