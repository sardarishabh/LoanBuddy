package com.cts.loanprocess.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cts.loanprocess.model.LoanApplication;

@Repository
public interface LoanApplicationRepo extends JpaRepository<LoanApplication, Integer>{

		
}
