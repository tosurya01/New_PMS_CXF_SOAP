package com.evry.fs.payment.pms.srv.model;

import javax.validation.constraints.NotNull;

import lombok.Builder;
import lombok.Getter;

/**
 * 
 * @author venkata.kuppili
 *
 */
@Getter
@Builder
public class Project {
	@NotNull
	private long projectId;
	private String projectName;
	private String projectStatus;
	private int estimatedHrs;
	private int loggedHrs;
	private int remainingHrs;

}
