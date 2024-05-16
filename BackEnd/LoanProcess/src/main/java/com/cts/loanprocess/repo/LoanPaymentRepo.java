package com.cts.loanprocess.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.loanprocess.model.LoanPayment;

@Repository
public interface LoanPaymentRepo extends JpaRepository<LoanPayment, Integer>{
       
}
