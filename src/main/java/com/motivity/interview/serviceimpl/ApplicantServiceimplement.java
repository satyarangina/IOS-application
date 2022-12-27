package com.motivity.interview.serviceimpl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.motivity.interview.model.ApplicantModel;
import com.motivity.interview.modeldto.ApplicantModelDto;
import com.motivity.interview.modeldto.DepartmentWiseCount;
import com.motivity.interview.repository.ApplicantRepository;
import com.motivity.interview.service.ApplicantService;

@Service
public class ApplicantServiceimplement implements ApplicantService
{
	@Autowired
	ApplicantRepository applicantRepository;
	
	@Autowired
	ModelMapper modelMapper;
	
	@Autowired
	EmailNotificationSender emailNotificationSender;



	@Override
	public ApplicantModel findByEmailId(String email) {
		// TODO Auto-generated method stub
		return applicantRepository.findBYEmail(email);
	}

	@Override
	public ResponseEntity<?> saveApplicant(ApplicantModel applicantModel){
		ApplicantModel model  = applicantRepository.findBYEmail(applicantModel.getApplicantEmail());
		System.out.println("applicant model......");
		
		if(model!=null)
		{
			System.out.println("model attribute is not null");
			if(model.getApplicantEmail().equalsIgnoreCase(applicantModel.getApplicantEmail()))
			{
				System.out.println("email checks");
				return new  ResponseEntity<String>("you already registered plz verify your account by username : "+model.getApplicantEmail(),HttpStatus.OK);
			}
			else
			{
				System.out.println("not a duplicate entry but its not work............................");
				return new  ResponseEntity<String>("you already registered plz verify your account by username : "+model.getApplicantEmail(),HttpStatus.OK);
				
			}
		}
		else {
			ApplicantModel saveddata = applicantRepository.save(applicantModel);
			
			String text = "hi "+saveddata.getApplicantFirstName()+" you are not submited your B.Tech certifications to motivitylabs. please submit your certificates as soon as possible. For any queries feel free to reach us. ";
			String to  = saveddata.getApplicantEmail();
			String subject = "final warning to cirtificate submission";
			emailNotificationSender.mailSender(to, subject, text);
			
			return new ResponseEntity<ApplicantModel>(saveddata,HttpStatus.OK);
		}
		
	}

	@Override
	public List<DepartmentWiseCount> countOfDepartmentWise() {
		
		List<Object []> object = applicantRepository.countOfApplicationsBydept();
		List<DepartmentWiseCount> departmentwiseData = new ArrayList<>();
		
		for(Object[] o:object)
		{
			DepartmentWiseCount dwc = new DepartmentWiseCount();
			dwc.setDepartmentName((String)o[1]);
			dwc.setNoOfCandidates((Long) o[0]);
			departmentwiseData.add(dwc);	
		}
		return departmentwiseData;
	}

	@Override
	public List<ApplicantModel> deptwisedata(String department) {
		// TODO Auto-generated method stub
		return applicantRepository.applicantsListByDept(department);
	}
	
	
	

}
