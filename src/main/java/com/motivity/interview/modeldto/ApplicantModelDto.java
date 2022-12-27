package com.motivity.interview.modeldto;

import javax.persistence.Column;
import javax.persistence.Lob;
import javax.servlet.annotation.MultipartConfig;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
@Builder
@MultipartConfig
public class ApplicantModelDto 
{
	
	
	private String applicantFirstName;
	private String applicantLastName;
	private String applicantCollegeName;
	
	private String applicantEmail;
	private String applicantPassword;
	private String applicantQualification;
	private String applicantPOY;
	private String applicantDepartment;
	private String applicantExp;
	private String applicantGender;

	private String applicantMobileNumber;
	private String applicantAddress;

	private MultipartFile resume;
	

}
