package com.evry.fs.payment.ems.srv.service;

import com.evry.fs.payment.ems.srv.model.GetEmployeeInfoRequest;
import com.evry.fs.payment.ems.srv.model.GetEmployeeInfoResponse;

public interface GetEmployeeInfo {
	/**
	 * 
	 * @param getEmployeeInfoRequest
	 * @return
	 */
	public GetEmployeeInfoResponse getEmployeeInfo(final GetEmployeeInfoRequest getEmployeeInfoRequest);
}
