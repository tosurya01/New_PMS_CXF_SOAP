package com.evry.fs.payment.pms.srv.service.mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import com.evry.fs.payment.pms.AddProjectRequestType;
import com.evry.fs.payment.pms.AddProjectResponseType;
import com.evry.fs.payment.pms.DeleteProjectRequestType;
import com.evry.fs.payment.pms.DeleteProjectResponseType;
import com.evry.fs.payment.pms.GetAllProjectsResponseType;
import com.evry.fs.payment.pms.GetProjectInfoRequestType;
import com.evry.fs.payment.pms.GetProjectInfoResponseType;
import com.evry.fs.payment.pms.ProjectType;
import com.evry.fs.payment.pms.UpdateProjectRequestType;
import com.evry.fs.payment.pms.UpdateProjectResponseType;
import com.evry.fs.payment.pms.srv.model.AddProjectRequest;
import com.evry.fs.payment.pms.srv.model.AddProjectResponse;
import com.evry.fs.payment.pms.srv.model.DeleteProjectRequest;
import com.evry.fs.payment.pms.srv.model.DeleteProjectResponse;
import com.evry.fs.payment.pms.srv.model.GetAllProjectsResponse;
import com.evry.fs.payment.pms.srv.model.GetProjectInfoRequest;
import com.evry.fs.payment.pms.srv.model.GetProjectInfoResponse;
import com.evry.fs.payment.pms.srv.model.Project;
import com.evry.fs.payment.pms.srv.model.UpdateProjectRequest;
import com.evry.fs.payment.pms.srv.model.UpdateProjectResponse;

/**
 * 
 * @author venkata.kuppili
 *
 */
@Component("projectV19_1WsMapper")
public class ProjectV19_1WsMapper {

	public AddProjectRequest fromWsToDomain(AddProjectRequestType addProjectRequestType) {
		return AddProjectRequest.builder().projectName(addProjectRequestType.getProjectName())
				.projectStatus(addProjectRequestType.getProjectStatus())
				.estimatedHrs(addProjectRequestType.getEstimatedHrs()).loggedHrs(addProjectRequestType.getLoggedHrs())
				.remainingHrs(addProjectRequestType.getRemainingHrs()).build();
	}

	public AddProjectResponseType fromDomainToWs(AddProjectResponse addProjectResponse) {
		AddProjectResponseType addProjectResponseType = new AddProjectResponseType();
		addProjectResponseType.setFlag(addProjectResponse.isFlag());
		return addProjectResponseType;
	}

	public GetProjectInfoRequest fromWsToDomain(GetProjectInfoRequestType getProjectInfoRequestType) {

		return GetProjectInfoRequest.builder().projectId(getProjectInfoRequestType.getProjectId()).build();
	}

	public GetProjectInfoResponseType fromDomainToWs(GetProjectInfoResponse getProjectInfoResponse) {
		GetProjectInfoResponseType getProjectInfoResponseType = new GetProjectInfoResponseType();
		getProjectInfoResponseType.setProjectType(projectToProjectType(getProjectInfoResponse.getProject()));
		return getProjectInfoResponseType;
	}

	private ProjectType projectToProjectType(Project project) {
		ProjectType projectType = new ProjectType();
		projectType.setProjectId(project.getProjectId());
		projectType.setProjectName(project.getProjectName());
		projectType.setProjectStatus(project.getProjectStatus());
		projectType.setEstimatedHrs(project.getEstimatedHrs());
		projectType.setLoggedHrs(project.getLoggedHrs());
		projectType.setRemainingHrs(project.getRemainingHrs());
		return projectType;
	}

	public UpdateProjectRequest fromWsToDomain(UpdateProjectRequestType updateProjectRequestType) {
		return UpdateProjectRequest.builder().projectId(updateProjectRequestType.getProjectId())
				.projectName(updateProjectRequestType.getProjectName())
				.projectStatus(updateProjectRequestType.getProjectStatus())
				.estimatedHrs(updateProjectRequestType.getEstimatedHrs())
				.loggedHrs(updateProjectRequestType.getLoggedHrs())
				.remainingHrs(updateProjectRequestType.getRemainingHrs()).build();
	}

	public UpdateProjectResponseType fromDomainToWs(UpdateProjectResponse updateProjectResponse) {
		UpdateProjectResponseType updateProjectResponseType = new UpdateProjectResponseType();
		updateProjectResponseType.setFlag(updateProjectResponse.isFlag());
		return updateProjectResponseType;
	}

	public DeleteProjectRequest fromWsToDomain(DeleteProjectRequestType deleteProjectRequestType) {

		return DeleteProjectRequest.builder().projectId(deleteProjectRequestType.getProjectId()).build();
	}

	public DeleteProjectResponseType fromDomainToWs(DeleteProjectResponse deleteProjectResponse) {
		DeleteProjectResponseType deleteProjectResponseType = new DeleteProjectResponseType();
		deleteProjectResponseType.setFlag(deleteProjectResponse.isFlag());
		return deleteProjectResponseType;
	}

	public GetAllProjectsResponseType fromDomainToWs(GetAllProjectsResponse getAllProjectsResponse) {
		List<Project> projects = getAllProjectsResponse.getProjects();
		GetAllProjectsResponseType getAllProjectsResponseType = new GetAllProjectsResponseType();
		List<ProjectType> ProjectTypes = getAllProjectsResponseType.getProjectType();
		for (Project project : projects) {
			ProjectTypes.add(projectToProjectType(project));
		}

		return getAllProjectsResponseType;
	}
}
