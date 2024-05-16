package com.cts.loanprocess.service;


import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.cts.loanprocess.exception.LoanApplicationNotFoundException;
import com.cts.loanprocess.model.LoanApplication;
import com.cts.loanprocess.repo.LoanApplicationRepo;
import com.cts.loanprocess.repo.LoanPaymentRepo;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class LoanProcessService {
	
	@Autowired
	LoanApplicationRepo loanApplicationRepo;
	
	@Autowired
	LoanPaymentRepo loanPaymentRepo;
	
	//Aryan---Method to apply for loan
	@Transactional
	public LoanApplication addLoanApplication(LoanApplication loanApplication) {
		log.info("adding new Loan Application to record...");
		loanApplicationRepo.save(loanApplication);
		log.info("done.");
		return loanApplication;
	}

	//Lokesh -- Update Loan Status
	@Transactional
	public void updateStatus (int id, String loanStatus)
	{
		Optional<LoanApplication> opLoan = loanApplicationRepo.findById(id);

		log.info("updating Loan status...");
		if (!opLoan.isPresent()) {
			throw new LoanApplicationNotFoundException("Loan Application with the id " + id + " does not exist");
		}

		LoanApplication loanObj = opLoan.get();
		loanObj.setLoanStatus(loanStatus);
		
		loanApplicationRepo.save(loanObj);
		log.info("done.");
	}

	//Lokesh -- View All Loan Applications
	@Transactional
	public List<LoanApplication> viewAllLoanApplications() throws LoanApplicationNotFoundException{
		// TODO Auto-generated method stub
		List<LoanApplication> loanApplicationList=loanApplicationRepo.findAll();
		if(loanApplicationList.size()==0)
		{
			throw new LoanApplicationNotFoundException("No Applications to view");
		}
		else
		{
			return loanApplicationList;
		}
	}
		
	//Lokesh -- View Loan Application By ID
	public LoanApplication viewLoanApplication(Integer applicationId){
		// TODO Auto-generated method stub
		log.info("searching Loan Application Records...");
		return loanApplicationRepo.findById(applicationId)
				.orElseThrow(() -> new LoanApplicationNotFoundException("Loan Application with the id " + applicationId + " does not exist"));
	}
	
}
