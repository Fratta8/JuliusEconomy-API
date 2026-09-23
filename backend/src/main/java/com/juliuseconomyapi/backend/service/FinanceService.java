package com.juliuseconomyapi.backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.juliuseconomyapi.backend.dto.FinanceDTO;
import com.juliuseconomyapi.backend.mapper.FinanceMapper;
import com.juliuseconomyapi.backend.model.Finance;
import com.juliuseconomyapi.backend.repository.FinanceRepository;


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
            FinanceMapper.toEntity(financeDTO)));
    }
    
    public Optional<FinanceDTO> updateFinance(Long id, FinanceDTO financeDTO){
        return financeRepository.findById(id)
        .map(finance -> {
            finance.setDescription(financeDTO.getDescription());
            finance.setValue(financeDTO.getValue());
            finance.setCategory(financeDTO.getCategory());
            finance.setDate(financeDTO.getDate());
            return FinanceMapper.toDTO(financeRepository.save(finance));
        });
    }

    public boolean deleteFinance(Long id){
        if (!financeRepository.existsById(id))
        return false;
        financeRepository.deleteById(id);
        return true;
    }

    public Optional<FinanceDTO> approve(Long id){
        return financeRepository.findById(id)
        .map(finance -> {
            finance.setOk(true);
            return FinanceMapper.toDTO(financeRepository.save(finance));
        });
    }
}
