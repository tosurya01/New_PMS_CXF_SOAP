package com.evry.fs.payment.ems.srv.service.internal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.evry.fs.payment.ems.srv.dao.EmployeeDao;
import com.evry.fs.payment.ems.srv.model.GetAllEmployeesInProjectRequest;
import com.evry.fs.payment.ems.srv.model.GetAllEmployeesInProjectResponse;
import com.evry.fs.payment.ems.srv.service.GetAllEmployeesInProject;
@Component("getAllEmployeesInProject")
public class GetAllEmployeesInProjectImpl implements GetAllEmployeesInProject {
	@Autowired
	EmployeeDao employeeDao;
	@Override
	public GetAllEmployeesInProjectResponse getAllEmployeesInProject(
			GetAllEmployeesInProjectRequest getAllEmployeesInProjectRequest) {
		return employeeDao.getAllEmployeesInProject(getAllEmployeesInProjectRequest);
	}

}
