package com.evry.fs.payment.ems.srv.service.internal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.evry.fs.payment.ems.srv.dao.EmployeeDao;
import com.evry.fs.payment.ems.srv.model.AddEmployeeRequest;
import com.evry.fs.payment.ems.srv.model.AddEmployeeResponse;
import com.evry.fs.payment.ems.srv.service.AddEmployee;
@Component("addEmployee")
public class AddEmployeeImpl implements AddEmployee {
	@Autowired
	EmployeeDao employeeDao;
	@Override
	public AddEmployeeResponse addEmployee(AddEmployeeRequest addEmployeeRequest) {
		return employeeDao.addEmployee(addEmployeeRequest);
	}

}
