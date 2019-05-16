package com.evry.fs.payment.ems.srv.service.internal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.evry.fs.payment.ems.srv.dao.EmployeeDao;
import com.evry.fs.payment.ems.srv.model.CheckLoginRequest;
import com.evry.fs.payment.ems.srv.model.CheckLoginResponse;
import com.evry.fs.payment.ems.srv.service.CheckLogin;
@Component("checkLogin")
public class CheckLoginImpl implements CheckLogin {
	@Autowired
	EmployeeDao employeeDao;
	@Override
	public CheckLoginResponse checkLogin(CheckLoginRequest checkLoginRequest) {
		return employeeDao.checkLogin(checkLoginRequest);
	}

}
