package com.evry.fs.payment.ems.srv.model;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class UpdateEmployeeRequest {
	private long employeeId;
	private String employeeName;
	private String location;
	private String password;
	private int access;
	private long projectId;
}
