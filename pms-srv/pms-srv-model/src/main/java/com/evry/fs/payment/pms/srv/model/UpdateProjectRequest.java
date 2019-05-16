package com.evry.fs.payment.pms.srv.model;

import javax.validation.constraints.NotNull;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class UpdateProjectRequest {
	@NotNull
	private long projectId;
	private String projectName;
	private String projectStatus;
	private int estimatedHrs;
	private int loggedHrs;
	private int remainingHrs;
}
