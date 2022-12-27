package com.motivity.interview.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;

import com.motivity.interview.model.Manager;
import com.motivity.interview.repository.ManagerRepository;
import com.motivity.interview.service.ManagerService;

public class ManagerServiceImpl implements ManagerService{
	
	@Autowired
	ManagerRepository managerRepository;

	@Override
	public Manager saveManager(Manager manager) {
		
		
		// TODO Auto-generated method stub
		return managerRepository.save(manager);
	}

	@Override
	public Manager login(String email, String password) {
		// TODO Auto-generated method stub
		return managerRepository.managerLogin(email, password);
	}

}
