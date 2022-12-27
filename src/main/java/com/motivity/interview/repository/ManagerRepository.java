package com.motivity.interview.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.motivity.interview.model.Manager;

@Repository
public interface ManagerRepository extends JpaRepository<Manager, String>{
	
	
	@Query("select m from Manager m where  m.username = :email and m.password=:password")
	public Manager managerLogin(String email,String password);
	
	
	
	
	
	

}
