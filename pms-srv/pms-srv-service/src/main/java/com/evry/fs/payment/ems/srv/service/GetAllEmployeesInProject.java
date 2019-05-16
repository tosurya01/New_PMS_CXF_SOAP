package com.evry.fs.payment.ems.srv.service;

import com.evry.fs.payment.ems.srv.model.GetAllEmployeesInProjectRequest;
import com.evry.fs.payment.ems.srv.model.GetAllEmployeesInProjectResponse;

public interface GetAllEmployeesInProject {
	public GetAllEmployeesInProjectResponse getAllEmployeesInProject(
			GetAllEmployeesInProjectRequest getAllEmployeesInProjectRequest);
}
