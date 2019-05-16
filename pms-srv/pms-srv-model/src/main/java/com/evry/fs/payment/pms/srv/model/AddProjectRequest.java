package com.evry.fs.payment.pms.srv.model;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class AddProjectRequest {
	private String projectName;
	private String projectStatus;
	private int estimatedHrs;
	private int loggedHrs;
	private int remainingHrs;
}
