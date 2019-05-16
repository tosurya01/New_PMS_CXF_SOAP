package com.evry.fs.payment.ems.srv.service.internal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.evry.fs.payment.ems.srv.dao.EmployeeDao;
import com.evry.fs.payment.ems.srv.model.UpdateEmployeeRequest;
import com.evry.fs.payment.ems.srv.model.UpdateEmployeeResponse;
import com.evry.fs.payment.ems.srv.service.UpdateEmployee;
@Component("updateEmployee")
public class UpdateEmployeeImpl implements UpdateEmployee {
	@Autowired
	EmployeeDao employeeDao;
	public UpdateEmployeeResponse updateEmployee(UpdateEmployeeRequest updateEmployeeRequest) {
		return employeeDao.updateEmployee(updateEmployeeRequest);
	}

}
