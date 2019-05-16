package com.evry.fs.payment.pms.srv.dao;

import static com.evry.fs.payment.pms.srv.testdata.ProjectTestDataConstants.ESTIMATED_HRS;
import static com.evry.fs.payment.pms.srv.testdata.ProjectTestDataConstants.FALSE;
import static com.evry.fs.payment.pms.srv.testdata.ProjectTestDataConstants.LOGGED_HRS;
import static com.evry.fs.payment.pms.srv.testdata.ProjectTestDataConstants.PROJECT_ID;
import static com.evry.fs.payment.pms.srv.testdata.ProjectTestDataConstants.PROJECT_NAME;
import static com.evry.fs.payment.pms.srv.testdata.ProjectTestDataConstants.PROJECT_STATUS;
import static com.evry.fs.payment.pms.srv.testdata.ProjectTestDataConstants.REMAINING_HRS;
import static com.evry.fs.payment.pms.srv.testdata.ProjectTestDataConstants.TRUE;
import static com.evry.fs.payment.pms.srv.testdata.ProjectTestDataConstants.WRONG_PROJECT_ID;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.evry.fs.payment.pms.srv.model.DeleteProjectRequest;
import com.evry.fs.payment.pms.srv.model.DeleteProjectResponse;
import com.evry.fs.payment.pms.srv.model.GetAllProjectsResponse;
import com.evry.fs.payment.pms.srv.model.GetProjectInfoRequest;
import com.evry.fs.payment.pms.srv.model.GetProjectInfoResponse;
import com.evry.fs.payment.pms.srv.model.Project;
import com.evry.fs.payment.pms.srv.model.UpdateProjectRequest;
import com.evry.fs.payment.pms.srv.model.UpdateProjectResponse;

@RunWith(SpringRunner.class)
@ContextConfiguration(locations = { "classpath:META-INF/spring/testApplicationContext.xml" })
public class ProjectDaoTest {
	@Inject
	ProjectDao projectDao;

	@Test
	public void testGetProjectInfo() {
		GetProjectInfoResponse getProjectInfoResponse = projectDao
				.getProjectInfo(GetProjectInfoRequest.builder().projectId(PROJECT_ID).build());
		Project project = getProjectInfoResponse.getProject();
		assertThat(project.getProjectId(), is(equalTo(PROJECT_ID)));
		assertThat(project.getProjectName(), is(equalTo(PROJECT_NAME)));
		assertThat(project.getProjectStatus(), is(equalTo(PROJECT_STATUS)));
		assertThat(project.getEstimatedHrs(), is(equalTo(ESTIMATED_HRS)));
		assertThat(project.getLoggedHrs(), is(equalTo(LOGGED_HRS)));
		assertThat(project.getRemainingHrs(), is(equalTo(REMAINING_HRS)));

	}

	@Test
	public void testUpdateProject() {

		UpdateProjectResponse updateProjectResponse = projectDao.updateProject(UpdateProjectRequest.builder()
				.projectId(PROJECT_ID).projectName(PROJECT_NAME).projectStatus(PROJECT_STATUS)
				.estimatedHrs(ESTIMATED_HRS).loggedHrs(LOGGED_HRS).remainingHrs(REMAINING_HRS).build());
		assertThat(updateProjectResponse.isFlag(), is(equalTo(TRUE)));
	}

	@Test
	public void testGetAllProjects() {
		GetAllProjectsResponse getAllProjectsResponse = projectDao.getAllProjects();
		Project project = getAllProjectsResponse.getProjects().get(0);
		assertThat(project.getProjectId(), is(equalTo(PROJECT_ID)));
		assertThat(project.getProjectName(), is(equalTo(PROJECT_NAME)));
		assertThat(project.getProjectStatus(), is(equalTo(PROJECT_STATUS)));
		assertThat(project.getEstimatedHrs(), is(equalTo(ESTIMATED_HRS)));
		assertThat(project.getLoggedHrs(), is(equalTo(LOGGED_HRS)));
		assertThat(project.getRemainingHrs(), is(equalTo(REMAINING_HRS)));
	}

	@Test
	public void testDeleteProject() {
		DeleteProjectResponse deleteProjectResponse = projectDao
				.deleteProject(DeleteProjectRequest.builder().projectId(WRONG_PROJECT_ID).build());
		assertThat(deleteProjectResponse.isFlag(), is(equalTo(FALSE)));
	}
//	@Test
//	public void testAddProject() {
//		AddProjectResponse addProjectResponse = projectDao
//				.addProject(AddProjectRequest.builder().projectName(PROJECT_NAME).projectStatus(PROJECT_STATUS)
//						.estimatedHrs(ESTIMATED_HRS).loggedHrs(LOGGED_HRS).remainingHrs(REMAINING_HRS).build());
//		assertThat(addProjectResponse.isFlag(), is(equalTo(TRUE)));
//	}
}
