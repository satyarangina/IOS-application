package com.motivity.interview.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import com.motivity.interview.model.ApplicantModel;
import com.motivity.interview.modeldto.DepartmentWiseCount;

public interface ApplicantService 
{
	public ResponseEntity<?> saveApplicant(ApplicantModel applicantModel);
	public ApplicantModel findByEmailId(String email);
	public List<DepartmentWiseCount> countOfDepartmentWise();
	public List<ApplicantModel> deptwisedata(String ddepartment);
	
	

}
