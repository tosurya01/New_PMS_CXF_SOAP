package com.evry.fs.payment.pms.srv.service.mapper;

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

@RunWith(MockitoJUnitRunner.class)
public class ProjectV19_1WsMapperTest {
	@InjectMocks
	private static ProjectV19_1WsMapper mapper;

	@Test
	public void testFromWsToDomainAddProjectRequestType() {
		AddProjectRequestType addProjectRequestType = new AddProjectRequestType();
		addProjectRequestType.setProjectName(PROJECT_NAME);
		addProjectRequestType.setProjectStatus(PROJECT_STATUS);
		addProjectRequestType.setEstimatedHrs(ESTIMATED_HRS);
		addProjectRequestType.setLoggedHrs(LOGGED_HRS);
		addProjectRequestType.setRemainingHrs(REMAINING_HRS);
		AddProjectRequest addProjectRequest = mapper.fromWsToDomain(addProjectRequestType);
		assertThat(addProjectRequest.getProjectName(), is(equalTo(PROJECT_NAME)));
		assertThat(addProjectRequest.getProjectStatus(), is(equalTo(PROJECT_STATUS)));
		assertThat(addProjectRequest.getEstimatedHrs(), is(equalTo(ESTIMATED_HRS)));
		assertThat(addProjectRequest.getLoggedHrs(), is(equalTo(LOGGED_HRS)));
		assertThat(addProjectRequest.getRemainingHrs(), is(equalTo(REMAINING_HRS)));
	}

	@Test
	public void testFromDomainToWsAddProjectResponse() {
		AddProjectResponseType addProjectResponseType = mapper
				.fromDomainToWs(AddProjectResponse.builder().flag(TRUE).build());
		assertThat(addProjectResponseType.isFlag(), is(equalTo(TRUE)));
	}

	@Test
	public void testFromWsToDomainGetProjectInfoRequestType() {
		GetProjectInfoRequestType getProjectInfoRequestType = new GetProjectInfoRequestType();
		getProjectInfoRequestType.setProjectId(PROJECT_ID);
		GetProjectInfoRequest getProjectInfoRequest = mapper.fromWsToDomain(getProjectInfoRequestType);
		assertThat(getProjectInfoRequest.getProjectId(), is(equalTo(PROJECT_ID)));

	}

	@Test
	public void testFromDomainToWsGetProjectInfoResponse() {
		GetProjectInfoResponseType getProjectInfoResponseType = mapper.fromDomainToWs(GetProjectInfoResponse.builder()
				.project(Project.builder().projectId(PROJECT_ID).projectName(PROJECT_NAME).projectStatus(PROJECT_STATUS)
						.estimatedHrs(ESTIMATED_HRS).loggedHrs(LOGGED_HRS).remainingHrs(REMAINING_HRS).build())
				.build());
		ProjectType projectType = getProjectInfoResponseType.getProjectType();
		assertThat(projectType.getProjectId(), is(equalTo(PROJECT_ID)));
		assertThat(projectType.getProjectName(), is(equalTo(PROJECT_NAME)));
		assertThat(projectType.getProjectStatus(), is(equalTo(PROJECT_STATUS)));
		assertThat(projectType.getEstimatedHrs(), is(equalTo(ESTIMATED_HRS)));
		assertThat(projectType.getLoggedHrs(), is(equalTo(LOGGED_HRS)));
		assertThat(projectType.getRemainingHrs(), is(equalTo(REMAINING_HRS)));
	}

	@Test
	public void testFromWsToDomainUpdateProjectRequestType() {
		UpdateProjectRequestType updateProjectRequestType = new UpdateProjectRequestType();
		updateProjectRequestType.setProjectId(PROJECT_ID);
		updateProjectRequestType.setProjectName(PROJECT_NAME);
		updateProjectRequestType.setProjectStatus(PROJECT_STATUS);
		updateProjectRequestType.setEstimatedHrs(ESTIMATED_HRS);
		updateProjectRequestType.setLoggedHrs(LOGGED_HRS);
		updateProjectRequestType.setRemainingHrs(REMAINING_HRS);
		UpdateProjectRequest updateProjectRequest = mapper.fromWsToDomain(updateProjectRequestType);
		assertThat(updateProjectRequest.getProjectId(), is(equalTo(PROJECT_ID)));
		assertThat(updateProjectRequest.getProjectName(), is(equalTo(PROJECT_NAME)));
		assertThat(updateProjectRequest.getProjectStatus(), is(equalTo(PROJECT_STATUS)));
		assertThat(updateProjectRequest.getEstimatedHrs(), is(equalTo(ESTIMATED_HRS)));
		assertThat(updateProjectRequest.getLoggedHrs(), is(equalTo(LOGGED_HRS)));
		assertThat(updateProjectRequest.getRemainingHrs(), is(equalTo(REMAINING_HRS)));
	}

	@Test
	public void testFromDomainToWsUpdateProjectResponse() {
		UpdateProjectResponseType updateProjectResponseType = mapper
				.fromDomainToWs(UpdateProjectResponse.builder().flag(TRUE).build());
		assertThat(updateProjectResponseType.isFlag(), is(equalTo(TRUE)));
	}

	@Test
	public void testFromWsToDomainDeleteProjectRequestType() {
		DeleteProjectRequestType deleteProjectRequestType = new DeleteProjectRequestType();
		deleteProjectRequestType.setProjectId(PROJECT_ID);
		DeleteProjectRequest deleteProjectRequest = mapper.fromWsToDomain(deleteProjectRequestType);
		assertThat(deleteProjectRequest.getProjectId(), is(equalTo(PROJECT_ID)));
	}

	@Test
	public void testFromDomainToWsDeleteProjectResponse() {
		DeleteProjectResponseType deleteProjectResponseType = mapper
				.fromDomainToWs(DeleteProjectResponse.builder().flag(TRUE).build());
		assertThat(deleteProjectResponseType.isFlag(), is(equalTo(TRUE)));
	}

	@Test
	public void testFromDomainToWsGetAllProjectsResponse() {
		List<Project> projects = new ArrayList<Project>();
		projects.add(Project.builder().projectId(PROJECT_ID).projectName(PROJECT_NAME).projectStatus(PROJECT_STATUS)
				.estimatedHrs(ESTIMATED_HRS).loggedHrs(LOGGED_HRS).remainingHrs(REMAINING_HRS).build());
		GetAllProjectsResponseType getAllProjectsResponseType = mapper
				.fromDomainToWs(GetAllProjectsResponse.builder().projects(projects).build());
		ProjectType projectType = getAllProjectsResponseType.getProjectType().get(0);
		assertThat(projectType.getProjectId(), is(equalTo(PROJECT_ID)));
		assertThat(projectType.getProjectName(), is(equalTo(PROJECT_NAME)));
		assertThat(projectType.getProjectStatus(), is(equalTo(PROJECT_STATUS)));
		assertThat(projectType.getEstimatedHrs(), is(equalTo(ESTIMATED_HRS)));
		assertThat(projectType.getLoggedHrs(), is(equalTo(LOGGED_HRS)));
		assertThat(projectType.getRemainingHrs(), is(equalTo(REMAINING_HRS)));
	}

}
