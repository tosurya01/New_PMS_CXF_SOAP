package com.evry.fs.payment.ems.srv.service.internal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.evry.fs.payment.ems.srv.dao.EmployeeDao;
import com.evry.fs.payment.ems.srv.model.GetEmployeeInfoRequest;
import com.evry.fs.payment.ems.srv.model.GetEmployeeInfoResponse;
import com.evry.fs.payment.ems.srv.service.GetEmployeeInfo;
@Component("getEmployeeInfo")
public class GetEmployeeInfoImpl implements GetEmployeeInfo {
	@Autowired
	EmployeeDao employeeDao;
	public GetEmployeeInfoResponse getEmployeeInfo(GetEmployeeInfoRequest getEmployeeInfoRequest) {
		return employeeDao.getEmployeeInfo(getEmployeeInfoRequest);
	}

}
