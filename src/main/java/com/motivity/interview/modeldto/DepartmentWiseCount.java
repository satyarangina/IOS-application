package com.motivity.interview.modeldto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentWiseCount {
	
	private String departmentName;
	private long noOfCandidates;
	
	

}
