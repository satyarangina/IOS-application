package com.motivity.interview.service;

import com.motivity.interview.model.Manager;

public interface ManagerService {
	
	public Manager saveManager(Manager manager);
	public Manager login(String email,String password);

}
