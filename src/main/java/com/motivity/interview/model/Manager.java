package com.motivity.interview.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Manager {
	@Id
	private String employeeId;
	private String name;
	private String username;
	private String password;
	private String role;
	private String interviewTask;
}
