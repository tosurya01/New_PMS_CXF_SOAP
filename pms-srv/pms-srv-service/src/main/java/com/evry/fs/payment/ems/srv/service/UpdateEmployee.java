package com.evry.fs.payment.ems.srv.service;

import com.evry.fs.payment.ems.srv.model.UpdateEmployeeRequest;
import com.evry.fs.payment.ems.srv.model.UpdateEmployeeResponse;

public interface UpdateEmployee {
	public UpdateEmployeeResponse updateEmployee(final UpdateEmployeeRequest updateEmployeeRequest);
}
