package com.evry.fs.payment.ems.srv.service.internal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.evry.fs.payment.ems.srv.dao.EmployeeDao;
import com.evry.fs.payment.ems.srv.model.GetAllFreeResourcesResponse;
import com.evry.fs.payment.ems.srv.service.GetAllFreeResources;

@Component("getAllFreeResources")
public class GetAllFreeResourcesImpl implements GetAllFreeResources {
	@Autowired
	EmployeeDao employeeDao;

	@Override
	public GetAllFreeResourcesResponse getAllFreeResources() {
		return employeeDao.getAllFreeResources();
	}

}
