package com.cts.loanprocess.model;

import javax.persistence.CascadeType;
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
@Table(name = "loan_application")
@Data
@ApiModel(description = "Model Class for Loan Application Details")
@SequenceGenerator(name="application_id_seq", initialValue=1006, allocationSize=100)
public class LoanApplication {
	
	@Id
	@Column(name = "application_id")
	@NotNull(message = "Application Id cannot be blank")
	@ApiModelProperty(value = "Id of the Application")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="application_id_seq")
	private Integer applicationId;
	
	@Column(name = "member_id")
	@NotNull(message = "Member Id cannot be blank")
	@ApiModelProperty(value = "Id of the Member")
	private Integer memberId;
	
	@Column(name = "loan_id")
	@NotNull(message = "Loan Id cannot be blank")
	@ApiModelProperty(value = "Id of the Loan")
	private Integer loanId;
	
	@Column(name = "mode_of_payment")
	@NotNull(message = "mode of the payment cannot be blank")
	@ApiModelProperty(value = "Nature of the mode of payment")
	private String modeOfPayment;
	
	@Column(name = "loan_amount")
	@NotNull(message = "Loan Amount cannot be blank")
	@ApiModelProperty(value = "Amount of the Loan")
	private Float loanAmount;
	
	@Column(name = "loan_duration")
	@NotNull(message = "Loan Duration cannot be blank")
	@ApiModelProperty(value = "Duration of the Loan")
	private Integer loanDuration;
	
	@Column(name = "purpose")
	@NotBlank(message = "Purpose cannot be empty")
	@ApiModelProperty(value = "Purpose of the Loan")
	private String purpose;
	
	@Column(name = "loan_status")
	@ApiModelProperty(value = "Status of the Loan Application")
	private String loanStatus;
	
	@ApiModelProperty(value = "Payment Class Object")
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL )
//  Attempt -- Bidirectional Hibernate Mapping
//	@JoinColumn(name = "payment_id", referencedColumnName = "application_id")
//	@OneToOne(fetch = FetchType.LAZY, mappedBy = "loanApplication", cascade = CascadeType.ALL )
	private LoanPayment loanPayment;
}
