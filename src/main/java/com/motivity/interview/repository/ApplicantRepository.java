package com.motivity.interview.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.motivity.interview.model.ApplicantModel;

@Repository
public interface ApplicantRepository extends JpaRepository<ApplicantModel, String>
{
	
	@Query("select a from ApplicantModel a where a.applicantEmail=:email")
	public ApplicantModel findBYEmail(String email);
	
	@Query("select count(a),a.applicantDepartment from ApplicantModel a group by  a.applicantDepartment")
	public List<Object[]> countOfApplicationsBydept();
	
	@Query("select a from ApplicantModel a  where a.applicantDepartment = :applicantDepartment")
	public List<ApplicantModel> applicantsListByDept(String applicantDepartment);
	

}
