package com.juliuseconomyapi.backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.juliuseconomyapi.backend.dto.FinanceDTO;
import com.juliuseconomyapi.backend.mapper.FinanceMapper;
import com.juliuseconomyapi.backend.model.Finance;
import com.juliuseconomyapi.backend.repository.FinanceRepository;
import com.juliuseconomyapi.backend.service.FinanceService;


@Service
public class FinanceService {

    private final FinanceRepository financeRepository;

    //recebe o repository
    public FinanceService(FinanceRepository financeRepository) {
        this.financeRepository = financeRepository;
    }

    public List<FinanceDTO> getAllFinance(){
        return financeRepository.findAll()
        .stream()
        .map(FinanceMapper::toDTO )
        .toList();
    }

    public Optional<FinanceDTO> getFinanceById(Long id){
        return financeRepository.findById(id)
            .map(FinanceMapper::toDTO);
    
    }

    public FinanceDTO createFinance(FinanceDTO financeDTO){
        return FinanceMapper.toDTO(financeRepository.save(
            FinaceMapper.toDTO()))
    }
    
}
