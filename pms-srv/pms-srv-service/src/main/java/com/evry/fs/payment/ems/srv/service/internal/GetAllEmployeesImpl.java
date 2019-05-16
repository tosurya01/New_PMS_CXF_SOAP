package com.evry.fs.payment.ems.srv.service.internal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.evry.fs.payment.ems.srv.dao.EmployeeDao;
import com.evry.fs.payment.ems.srv.model.GetAllEmployeesResponse;
import com.evry.fs.payment.ems.srv.service.GetAllEmployees;
@Component("getAllEmployees")
public class GetAllEmployeesImpl implements GetAllEmployees {
	@Autowired
	EmployeeDao employeeDao;
	public GetAllEmployeesResponse getAllEmployees() {
		return employeeDao.getAllEmployees();
	}

}
