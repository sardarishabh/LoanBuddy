package com.cts.member.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


@Entity
@Table(name = "member")
@Data
@ApiModel(description = "Model Class for Member Details")
@SequenceGenerator(name="member_id_seq", initialValue=12, allocationSize=100)
public class Member {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="member_id_seq")
	@Column(name = "member_id", unique = true)
	@ApiModelProperty(value = "Id of the Member")
	private Integer memberId;

	@Column(name = "first_name")
	@ApiModelProperty(value = "First name of the Member")
	@NotBlank(message = "First name cannot be blank")
	private String firstName;

	@Column(name = "last_name")
	@ApiModelProperty(value = "Last name of the Member")
	@NotBlank(message = "Last name cannot be blank")
	private String lastName;

	@Column(name = "address")
	@ApiModelProperty(value = "Address of the Member")
	@NotBlank(message = "Address cannot be blank")
	private String address;

	@Column(name = "contact_number")
	@ApiModelProperty(value = "Contact Number of the Member")
	@NotBlank(message = "Contact Number cannot be blank")
	private String contactNumber;

	@Column(name = "email_id")
	@ApiModelProperty(value = "Email Id of the Member")
	@NotBlank(message = "Email Id cannot be blank")
	private String emailId;

	@Column(name = "gender")
	@ApiModelProperty(value = "Gender of the Member")
	@NotBlank(message = "Gender cannot be blank")
	private String gender;

	@Column(name = "civil_status")
	@ApiModelProperty(value = "Civil Status of the Member")
	@NotNull(message = "Civil Status cannot be blank")
	private Integer civilStatus;

	@Column(name = "date_of_birth")
	@ApiModelProperty(value = "Date of birth of the Member")
	@NotBlank(message = "Date of Birth cannot be blank")
	private String dateOfBirth;

	@Column(name = "age")
	@ApiModelProperty(value = "Age of the Member")
	@NotNull(message = "Age cannot be blank")
	private Integer age;

	@Column(name = "user_name", unique = true)
	@ApiModelProperty(value = "Username of the Member")
	@NotBlank(message = "User name cannot be blank")
	private String userName;

	@Column(name = "password")
	@ApiModelProperty(value = "Password of the Member")
	@NotBlank(message = "Password cannot be blank")
	private String password;
	
	@Column(name = "member_type")
	@ApiModelProperty(value = "Type of Member")
	@NotBlank(message = "Member type cannot be blank")
	private String memberType;

}
