package com.evry.fs.payment.ems.srv.service.internal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.evry.fs.payment.ems.srv.dao.EmployeeDao;
import com.evry.fs.payment.ems.srv.model.DeleteEmployeeRequest;
import com.evry.fs.payment.ems.srv.model.DeleteEmployeeResponse;
import com.evry.fs.payment.ems.srv.service.DeleteEmployee;
@Component("deleteEmployee")
public class DeleteEmployeeImpl implements DeleteEmployee {
	@Autowired
	EmployeeDao employeeDetailsDao;
	public DeleteEmployeeResponse deleteEmployee(DeleteEmployeeRequest deleteEmployeesRequest) {
		return employeeDetailsDao.deleteEmployee(deleteEmployeesRequest);
	}

}
