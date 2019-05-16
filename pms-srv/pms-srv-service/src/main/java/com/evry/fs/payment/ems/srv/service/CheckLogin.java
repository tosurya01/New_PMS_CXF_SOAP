package com.evry.fs.payment.ems.srv.service;

import com.evry.fs.payment.ems.srv.model.CheckLoginRequest;
import com.evry.fs.payment.ems.srv.model.CheckLoginResponse;

public interface CheckLogin {
	public CheckLoginResponse checkLogin(final CheckLoginRequest checkLoginRequest);
}
