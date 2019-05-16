package com.evry.fs.payment.ems.srv.model;

import java.util.List;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class GetAllEmployeesInProjectResponse {
	private List<Employee> employeeList;
}
