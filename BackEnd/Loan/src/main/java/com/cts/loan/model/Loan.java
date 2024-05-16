package com.cts.loan.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "loan")
@Data
@ApiModel(description = "Model Class for the Loan Details")
@NoArgsConstructor
@AllArgsConstructor
public class Loan {

	/* Rishabh --> Loan Model Class*/
	
	@Id
	@Column(name = "loan_id")
	@NotNull(message = "Loan Id cannot be blank")
	@ApiModelProperty(value = "Id of the Loan")
	private Integer loanId;

	@Column(name = "loan_name")
	@ApiModelProperty(value = "Name of the Loan")
	@NotBlank(message = "Loan Name cannot be blank")
	private String loanName;

	@Column(name = "description")
	@ApiModelProperty(value = "Description of the Loan")
	@NotBlank(message = "Loan Description cannot be blank")
	private String description;
}
