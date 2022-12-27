package com.motivity.interview.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data

@Entity
@NoArgsConstructor
@AllArgsConstructor
@DynamicInsert
public class ApplicantModel {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int applicantId;
	private String applicantFirstName;
	private String applicantLastName;
	private String applicantCollegeName;
	@Column(unique = true)
	private String applicantEmail;
	private String applicantPassword;
	private String applicantQualification;
	private String applicantPOY;
	private String applicantDepartment;
	private String applicantExp;
	private String applicantGender;
	@Column(unique = true)
	private String applicantMobileNumber;
	private String applicantAddress;
	@Column(columnDefinition ="varchar(255) default 'pending'")
	private String GDRoundStatus;
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "gd_manager")
	private Manager gdManager;
	@Column(columnDefinition ="varchar(255) default 'pending'")
	private String testStatus;
	@Column(columnDefinition ="varchar(255) default 'pending'")
	private String testScore;
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "test_manager")
	private Manager testManager;
	@Column(columnDefinition ="varchar(255) default 'pending'")
	private String f2fStatus;
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "f2f_manager")
	private Manager f2fManager;
	
	
	

}
