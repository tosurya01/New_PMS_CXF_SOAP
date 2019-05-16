package com.evry.fs.payment.pms.srv.dao.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.evry.fs.payment.pms.srv.dao.entity.ProjectEntity;
import com.evry.fs.payment.pms.srv.model.AddProjectRequest;
import com.evry.fs.payment.pms.srv.model.AddProjectResponse;
import com.evry.fs.payment.pms.srv.model.DeleteProjectResponse;
import com.evry.fs.payment.pms.srv.model.GetAllProjectsResponse;
import com.evry.fs.payment.pms.srv.model.GetProjectInfoResponse;
import com.evry.fs.payment.pms.srv.model.Project;
import com.evry.fs.payment.pms.srv.model.UpdateProjectResponse;

/**
 * 
 * @author venkata.kuppili
 *
 */
@Component("projectDaoMapper")
public class ProjectDaoMapper {

	public ProjectEntity fromModelToEntity(AddProjectRequest addProjectRequest) {
		ProjectEntity projectEntity = new ProjectEntity();
		projectEntity.setProjectName(addProjectRequest.getProjectName());
		projectEntity.setProjectStatus(addProjectRequest.getProjectStatus());
		projectEntity.setEstimatedHrs(addProjectRequest.getEstimatedHrs());
		projectEntity.setLoggedHrs(addProjectRequest.getLoggedHrs());
		projectEntity.setRemainingHrs(addProjectRequest.getRemainingHrs());
		return projectEntity;
	}

	public AddProjectResponse addProjectResponse(boolean flag) {
		return AddProjectResponse.builder().flag(flag).build();
	}

	public GetProjectInfoResponse fromEntityToModel(ProjectEntity projectEntity) {
		Project project = Project.builder().projectId(projectEntity.getProjectId())
				.projectName(projectEntity.getProjectName())
				.projectStatus(projectEntity.getProjectStatus())
				.estimatedHrs(projectEntity.getEstimatedHrs()).loggedHrs(projectEntity.getLoggedHrs())
				.remainingHrs(projectEntity.getRemainingHrs()).build();
		GetProjectInfoResponse response = GetProjectInfoResponse.builder().project(project).build();
		return response;
	}

	public UpdateProjectResponse updateProjectResponse(boolean flag) {
		return UpdateProjectResponse.builder().flag(flag).build();
	}

	public GetAllProjectsResponse projectEntityListToProjectList(
			List<ProjectEntity> projectEntityList) {
		List<Project> projects = new ArrayList<Project>();
		for (ProjectEntity projectEntity : projectEntityList) {
			projects.add(fromEntityToModel2(projectEntity));
		}
		return GetAllProjectsResponse.builder().projects(projects).build();
	}

	public Project fromEntityToModel2(ProjectEntity projectEntity) {
		return Project.builder().projectId(projectEntity.getProjectId())
				.projectName(projectEntity.getProjectName())
				.projectStatus(projectEntity.getProjectStatus())
				.estimatedHrs(projectEntity.getEstimatedHrs()).loggedHrs(projectEntity.getLoggedHrs())
				.remainingHrs(projectEntity.getRemainingHrs()).build();
	}

	public DeleteProjectResponse deleteProjectResponse(boolean flag) {
		return DeleteProjectResponse.builder().flag(flag).build();
	}
}
