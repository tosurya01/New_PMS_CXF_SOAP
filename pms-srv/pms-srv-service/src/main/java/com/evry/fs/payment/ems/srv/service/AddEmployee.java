package com.evry.fs.payment.ems.srv.service;

import com.evry.fs.payment.ems.srv.model.AddEmployeeRequest;
import com.evry.fs.payment.ems.srv.model.AddEmployeeResponse;

public interface AddEmployee {
	public AddEmployeeResponse addEmployee(final AddEmployeeRequest addEmployeeRequest);
}
