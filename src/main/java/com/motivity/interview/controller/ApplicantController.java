package com.motivity.interview.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.motivity.interview.model.ApplicantModel;
import com.motivity.interview.modeldto.DepartmentWiseCount;
import com.motivity.interview.service.ApplicantService;

@RestController
@CrossOrigin("http://localhost:3000")
public class ApplicantController {
	
	@Autowired
	ApplicantService applicantService;
	
	@PostMapping("/save")
	public ResponseEntity<?> candidateRegistration(@RequestBody ApplicantModel applicantModel)
	{
		return applicantService.saveApplicant(applicantModel);
	}
	@GetMapping("/")
	public String hai()
	{
		return "welcome";
	}
	
	@GetMapping("/count")
	public List<DepartmentWiseCount> countOfDepartmentWiseData()
	{
		
		List<DepartmentWiseCount> dw =  applicantService.countOfDepartmentWise();
		return dw;
	}
	
	@GetMapping("/getdetailsbydept")
	public ResponseEntity<List<ApplicantModel>> getapplicantDatabyDept(@RequestParam String department)
	{
		return new ResponseEntity<List<ApplicantModel>>(applicantService.deptwisedata(department),HttpStatus.OK);
	}
	

	

}
