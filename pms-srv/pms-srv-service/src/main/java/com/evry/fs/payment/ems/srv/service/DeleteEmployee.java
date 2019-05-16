package com.evry.fs.payment.ems.srv.service;

import com.evry.fs.payment.ems.srv.model.DeleteEmployeeRequest;
import com.evry.fs.payment.ems.srv.model.DeleteEmployeeResponse;

public interface DeleteEmployee {
	/**
	 * 
	 * @param addEmployeeRequest
	 * @return
	 */
	public DeleteEmployeeResponse deleteEmployee(final DeleteEmployeeRequest deleteEmployeesRequest);
}
