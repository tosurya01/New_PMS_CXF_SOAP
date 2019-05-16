package com.evry.fs.payment.pms.srv.dao.mapper;

import static com.evry.fs.payment.pms.srv.testdata.ProjectTestDataConstants.ESTIMATED_HRS;
import static com.evry.fs.payment.pms.srv.testdata.ProjectTestDataConstants.LOGGED_HRS;
import static com.evry.fs.payment.pms.srv.testdata.ProjectTestDataConstants.PROJECT_ID;
import static com.evry.fs.payment.pms.srv.testdata.ProjectTestDataConstants.PROJECT_NAME;
import static com.evry.fs.payment.pms.srv.testdata.ProjectTestDataConstants.PROJECT_STATUS;
import static com.evry.fs.payment.pms.srv.testdata.ProjectTestDataConstants.REMAINING_HRS;
import static com.evry.fs.payment.pms.srv.testdata.ProjectTestDataConstants.TRUE;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import com.evry.fs.payment.pms.srv.dao.entity.ProjectEntity;
import com.evry.fs.payment.pms.srv.model.AddProjectRequest;
import com.evry.fs.payment.pms.srv.model.AddProjectResponse;
import com.evry.fs.payment.pms.srv.model.DeleteProjectResponse;
import com.evry.fs.payment.pms.srv.model.GetAllProjectsResponse;
import com.evry.fs.payment.pms.srv.model.GetProjectInfoResponse;
import com.evry.fs.payment.pms.srv.model.Project;
import com.evry.fs.payment.pms.srv.model.UpdateProjectResponse;

@RunWith(MockitoJUnitRunner.class)
public class ProjectDaoMapperTest {
	@InjectMocks
	private static ProjectDaoMapper mapper;

	@Test
	public void testFromModelToEntity() {
		ProjectEntity projectEntity = mapper
				.fromModelToEntity(AddProjectRequest.builder().projectName(PROJECT_NAME).projectStatus(PROJECT_STATUS)
						.estimatedHrs(ESTIMATED_HRS).loggedHrs(LOGGED_HRS).remainingHrs(REMAINING_HRS).build());
		assertThat(projectEntity.getProjectName(), is(equalTo(PROJECT_NAME)));
		assertThat(projectEntity.getProjectStatus(), is(equalTo(PROJECT_STATUS)));
		assertThat(projectEntity.getEstimatedHrs(), is(equalTo(ESTIMATED_HRS)));
		assertThat(projectEntity.getLoggedHrs(), is(equalTo(LOGGED_HRS)));
		assertThat(projectEntity.getRemainingHrs(), is(equalTo(REMAINING_HRS)));
	}

	@Test
	public void testAddProjectResponse() {
		AddProjectResponse addProjectResponse = mapper.addProjectResponse(TRUE);
		assertThat(addProjectResponse.isFlag(), is(equalTo(TRUE)));
	}

	@Test
	public void testFromEntityToModel() {
		ProjectEntity projectEntity = new ProjectEntity();
		projectEntity.setProjectId(PROJECT_ID);
		projectEntity.setProjectName(PROJECT_NAME);
		projectEntity.setProjectStatus(PROJECT_STATUS);
		projectEntity.setEstimatedHrs(ESTIMATED_HRS);
		projectEntity.setLoggedHrs(LOGGED_HRS);
		projectEntity.setRemainingHrs(REMAINING_HRS);
		GetProjectInfoResponse getProjectInfoResponse = mapper.fromEntityToModel(projectEntity);
		Project projectDetails = getProjectInfoResponse.getProject();
		assertThat(projectDetails.getProjectId(), is(equalTo(PROJECT_ID)));
		assertThat(projectDetails.getProjectName(), is(equalTo(PROJECT_NAME)));
		assertThat(projectDetails.getProjectStatus(), is(equalTo(PROJECT_STATUS)));
		assertThat(projectDetails.getEstimatedHrs(), is(equalTo(ESTIMATED_HRS)));
		assertThat(projectDetails.getLoggedHrs(), is(equalTo(LOGGED_HRS)));
		assertThat(projectDetails.getRemainingHrs(), is(equalTo(REMAINING_HRS)));
	}

	@Test
	public void testUpdateProjectResponse() {
		UpdateProjectResponse updateProjectResponse = mapper.updateProjectResponse(TRUE);
		assertThat(updateProjectResponse.isFlag(), is(equalTo(TRUE)));
	}

	@Test
	public void testProjectEntityListToProjectList() {
		List<ProjectEntity> projectEntityList = new ArrayList<ProjectEntity>();
		ProjectEntity projectEntity = new ProjectEntity();
		projectEntity.setProjectId(PROJECT_ID);
		projectEntity.setProjectName(PROJECT_NAME);
		projectEntity.setProjectStatus(PROJECT_STATUS);
		projectEntity.setEstimatedHrs(ESTIMATED_HRS);
		projectEntity.setLoggedHrs(LOGGED_HRS);
		projectEntity.setRemainingHrs(REMAINING_HRS);
		projectEntityList.add(projectEntity);
		GetAllProjectsResponse getAllProjectsResponse = mapper.projectEntityListToProjectList(projectEntityList);
		Project project = getAllProjectsResponse.getProjects().get(0);
		assertThat(project.getProjectId(), is(equalTo(PROJECT_ID)));
		assertThat(project.getProjectName(), is(equalTo(PROJECT_NAME)));
		assertThat(project.getProjectStatus(), is(equalTo(PROJECT_STATUS)));
		assertThat(project.getEstimatedHrs(), is(equalTo(ESTIMATED_HRS)));
		assertThat(project.getLoggedHrs(), is(equalTo(LOGGED_HRS)));
		assertThat(project.getRemainingHrs(), is(equalTo(REMAINING_HRS)));
	}

	@Test
	public void testFromEntityToModel2() {
		ProjectEntity projectEntity = new ProjectEntity();
		projectEntity.setProjectId(PROJECT_ID);
		projectEntity.setProjectName(PROJECT_NAME);
		projectEntity.setProjectStatus(PROJECT_STATUS);
		projectEntity.setEstimatedHrs(ESTIMATED_HRS);
		projectEntity.setLoggedHrs(LOGGED_HRS);
		projectEntity.setRemainingHrs(REMAINING_HRS);
		Project project = mapper.fromEntityToModel2(projectEntity);
		assertThat(project.getProjectId(), is(equalTo(PROJECT_ID)));
		assertThat(project.getProjectName(), is(equalTo(PROJECT_NAME)));
		assertThat(project.getProjectStatus(), is(equalTo(PROJECT_STATUS)));
		assertThat(project.getEstimatedHrs(), is(equalTo(ESTIMATED_HRS)));
		assertThat(project.getLoggedHrs(), is(equalTo(LOGGED_HRS)));
		assertThat(project.getRemainingHrs(), is(equalTo(REMAINING_HRS)));
	}

	@Test
	public void testDeleteProjectResponse() {
		DeleteProjectResponse deleteProjectResponse = mapper.deleteProjectResponse(TRUE);
		assertThat(deleteProjectResponse.isFlag(), is(equalTo(TRUE)));
	}

}
