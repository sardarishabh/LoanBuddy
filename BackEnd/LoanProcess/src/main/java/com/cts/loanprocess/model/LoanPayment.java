package com.cts.loanprocess.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Entity
@Table(name = "loan_payment")
@Data
@ApiModel(description = "Model Class for Loan Payment Details")
@SequenceGenerator(name="payment_id_seq", initialValue=100006, allocationSize=100)
public class LoanPayment {
	
	@Id
	@Column(name = "payment_id")
	@NotNull(message = "Payment Id cannot be blank")
	@ApiModelProperty(value = "Id of the Payment")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="payment_id_seq")
	private Integer paymentId;
	

	@Column(name = "application_id") 
	//@NotNull(message = "Application Id cannot be blank")
	@ApiModelProperty(value = "Id of the Application")
	private Integer applicationId;
	
	@Column(name = "date_of_payment")
	@NotBlank(message = "Date of payment cannot be empty")
	@ApiModelProperty(value = "Date of the Payment")
	private String dateOfPayment;
	
	@Column(name = "amount")
	@NotNull(message = "Amount cannot be blank")
	@ApiModelProperty(value = "Amount of the Payment")
	private Float amount;
	
	@Column(name = "interest_paid")
	@NotNull(message = "Interest cannot be blank")
	@ApiModelProperty(value = "Interest paid of the Loan")
	private Float interestPaid;
	
	@Column(name = "principal_paid")
	@NotNull(message = "Principal cannot be blank")
	@ApiModelProperty(value = "Principal paid of the Loan")
	private Float principalPaid;
	
	@Column(name = "balance")
	@NotNull(message = "Balance cannot be blank")
	@ApiModelProperty(value = "Balance amount of the Loan")
	private Float balance;
	
//  Attempt -- Bidirectional Hibernate Mapping
//	@OneToOne
//	@JoinColumn(name="application_id", updatable =false, insertable = false )
//	@ApiModelProperty(value = "LoanApplication object")
//	private LoanApplication loanApplication;

}
