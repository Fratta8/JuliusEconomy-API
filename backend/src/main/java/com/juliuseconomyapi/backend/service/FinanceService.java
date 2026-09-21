package com.juliuseconomyapi.backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.juliuseconomyapi.backend.model.Finance;
import com.juliuseconomyapi.backend.repository.FinanceRepository;
import com.juliuseconomyapi.backend.service.FinanceService;


@Service
public class FinanceService {

    private final FinanceRepository financeRepository;

    public FinanceService(FinanceRepository financeRepository) {
        this.financeRepository = financeRepository;
    }
    
}
