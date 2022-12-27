package com.motivity.interview.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.motivity.interview.model.Manager;
import com.motivity.interview.service.ManagerService;

public class ManagerController {
	
	@Autowired
	ManagerService managerService;
	
	@PostMapping("/savemanager")
	public ResponseEntity<Manager> saveManager(@RequestBody Manager manager)
	{
		Manager savemanager = managerService.saveManager(manager);
		
		return new ResponseEntity<Manager>(savemanager,HttpStatus.OK);		
	}
	@PostMapping("/managerlogin")
	public ResponseEntity<Manager> loginManager(@RequestBody Manager manager)
	{
		Manager loginManager = managerService.login(manager.getUsername(), manager.getPassword());
		return new ResponseEntity<Manager>(loginManager,HttpStatus.OK);
	}
	
	

}
