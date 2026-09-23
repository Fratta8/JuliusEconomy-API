package com.juliuseconomyapi.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.juliuseconomyapi.backend.model.Finance;

public interface FinanceRepository extends JpaRepository<Finance, Long> {
}
