package com.cts.loan.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.loan.exception.LoanNotFoundException;
import com.cts.loan.model.Loan;
import com.cts.loan.repo.LoanRepo;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class LoanService {

	@Autowired
	LoanRepo loanRepo;

	/* Rishabh -----> View Loan Products */
	@Transactional
	public List<Loan> viewAllLoans() {

		log.info("loading all loans...");
		List<Loan> loanList = loanRepo.findAll();
		if (loanList.size() == 0) {
			log.info("Exception occurs");
			throw new LoanNotFoundException("Database is emplty!");
		} else {
			return loanList;
		}
	}

	@Transactional
	public Loan loanById(int id) {
		log.info("searching Loan record...");
		return loanRepo.findById(id)
				.orElseThrow(() -> new LoanNotFoundException("Loan with the id " + id + " does not exist"));
	}

	/* Rishabh -----> Add and Update Loan Products */
	@Transactional
	public Loan addLoan(Loan loan) {
		log.info("adding new Loan record...");
		loanRepo.save(loan);
		log.info("done.");
		return loan;
	}

	@Transactional
	public Loan updateLoan(int id, Loan loan) {
		Optional<Loan> opLoan = loanRepo.findById(id);

		log.info("updating Loan record...");
		if (!opLoan.isPresent()) {
			throw new LoanNotFoundException("Loan with the id " + id + " does not exist");
		}

		Loan loanObj = opLoan.get();
		if (loan.getLoanName() != null) {
			loanObj.setLoanName(loan.getLoanName());
		}
		if (loan.getDescription() != null) {
			loanObj.setDescription(loan.getDescription());
		}

		loanRepo.save(loan);
		log.info("done.");
		return loan;
	}

	@Transactional
	public Loan deleteLoanById(int id) {
		log.info("deleting Loan record...");
		Loan loan = loanRepo.findById(id).get();
		loanRepo.deleteById(id);
		log.info("done.");
		return loan;
	}
}
