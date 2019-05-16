package com.evry.fs.payment.pms.srv.dao.internal;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.evry.fs.payment.pms.srv.dao.ProjectDao;
import com.evry.fs.payment.pms.srv.dao.entity.ProjectEntity;
import com.evry.fs.payment.pms.srv.dao.mapper.ProjectDaoMapper;
import com.evry.fs.payment.pms.srv.model.AddProjectRequest;
import com.evry.fs.payment.pms.srv.model.AddProjectResponse;
import com.evry.fs.payment.pms.srv.model.DeleteProjectRequest;
import com.evry.fs.payment.pms.srv.model.DeleteProjectResponse;
import com.evry.fs.payment.pms.srv.model.GetAllProjectsResponse;
import com.evry.fs.payment.pms.srv.model.GetProjectInfoRequest;
import com.evry.fs.payment.pms.srv.model.GetProjectInfoResponse;
import com.evry.fs.payment.pms.srv.model.UpdateProjectRequest;
import com.evry.fs.payment.pms.srv.model.UpdateProjectResponse;

/**
 * 
 * @author venkata.kuppili
 *
 */
@Repository("projectDao")
public class ProjectDaoImpl implements ProjectDao {
	@PersistenceContext
	EntityManager entityManager;
	private final ProjectDaoMapper projectDaoMapper;

	/**
	 * 
	 * @param projectDaoMapper
	 */
	@Autowired
	public ProjectDaoImpl(final ProjectDaoMapper projectDaoMapper) {
		this.projectDaoMapper = projectDaoMapper;
	}

	@Transactional
	public AddProjectResponse addProject(AddProjectRequest addProjectRequest) {
		boolean flag = false;
		ProjectEntity projectEntity = projectDaoMapper.fromModelToEntity(addProjectRequest);
		if (!entityManager.contains(projectEntity)) {
			entityManager.persist(projectEntity);
			flag = true;
		}
		return projectDaoMapper.addProjectResponse(flag);
	}

	public GetProjectInfoResponse getProjectInfo(GetProjectInfoRequest getProjectInfoRequest) {
		ProjectEntity projectEntity = entityManager.find(ProjectEntity.class, getProjectInfoRequest.getProjectId());
		return projectDaoMapper.fromEntityToModel(projectEntity);
	}

	@Transactional
	public UpdateProjectResponse updateProject(UpdateProjectRequest updateProjectRequest) {
		boolean flag = false;
		ProjectEntity projectEntity = entityManager.find(ProjectEntity.class, updateProjectRequest.getProjectId());
		if (updateProjectRequest != null && entityManager.contains(projectEntity)) {
			if (!"".equals(updateProjectRequest.getProjectName())) {
				projectEntity.setProjectName(updateProjectRequest.getProjectName());
			}
			if (!"".equals(updateProjectRequest.getProjectStatus())) {
				projectEntity.setProjectStatus(updateProjectRequest.getProjectStatus());
			}
			if (updateProjectRequest.getEstimatedHrs() != 0) {
				projectEntity.setEstimatedHrs(updateProjectRequest.getEstimatedHrs());
			}
			if (updateProjectRequest.getLoggedHrs() != 0) {
				projectEntity.setLoggedHrs(updateProjectRequest.getLoggedHrs());
			}
			if (updateProjectRequest.getRemainingHrs() != 0) {
				projectEntity.setRemainingHrs(updateProjectRequest.getRemainingHrs());
			}
			entityManager.merge(projectEntity);
			flag = true;
		}
		return projectDaoMapper.updateProjectResponse(flag);
	}

	public GetAllProjectsResponse getAllProjects() {
		Query query = entityManager.createQuery("FROM ProjectEntity");
		return projectDaoMapper.projectEntityListToProjectList(query.getResultList());
	}

	@Transactional
	public DeleteProjectResponse deleteProject(final DeleteProjectRequest deleteProjectRequest) {
		boolean flag = false;
		ProjectEntity projectEntity = entityManager.find(ProjectEntity.class, deleteProjectRequest.getProjectId());
		if (null != projectEntity) {
			entityManager
					.createQuery(
							"UPDATE EmployeeEntity e SET e.projectId =:projectId WHERE e.projectId =:deleteProjectId")
					.setParameter("projectId", 3245L)
					.setParameter("deleteProjectId", deleteProjectRequest.getProjectId()).executeUpdate();
			entityManager.remove(projectEntity);
			flag = true;
		}
		return projectDaoMapper.deleteProjectResponse(flag);
	}

}
