package com.cts.loan.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.loan.model.Loan;

@Repository
public interface LoanRepo extends JpaRepository<Loan, Integer> {

}
