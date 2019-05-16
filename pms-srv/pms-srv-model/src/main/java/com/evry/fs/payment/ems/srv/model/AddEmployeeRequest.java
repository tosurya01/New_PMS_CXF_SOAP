package com.evry.fs.payment.ems.srv.model;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class AddEmployeeRequest {
	private String employeeName;
	private String password;
	private String location;
	private int access;
	private long projectId;

}
