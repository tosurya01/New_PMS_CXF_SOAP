package com.evry.fs.payment.ems.srv.model;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class GetAllEmployeesInProjectRequest {
	private long projectId;
}
