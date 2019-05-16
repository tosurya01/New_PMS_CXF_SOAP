package com.evry.fs.payment.ems.srv.dao.internal;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.evry.fs.payment.ems.srv.dao.EmployeeDao;
import com.evry.fs.payment.ems.srv.dao.entity.EmployeeEntity;
import com.evry.fs.payment.ems.srv.dao.mapper.EmployeeDaoMapper;
import com.evry.fs.payment.ems.srv.model.AddEmployeeRequest;
import com.evry.fs.payment.ems.srv.model.AddEmployeeResponse;
import com.evry.fs.payment.ems.srv.model.CheckLoginRequest;
import com.evry.fs.payment.ems.srv.model.CheckLoginResponse;
import com.evry.fs.payment.ems.srv.model.DeleteEmployeeRequest;
import com.evry.fs.payment.ems.srv.model.DeleteEmployeeResponse;
import com.evry.fs.payment.ems.srv.model.GetAllEmployeesInProjectRequest;
import com.evry.fs.payment.ems.srv.model.GetAllEmployeesInProjectResponse;
import com.evry.fs.payment.ems.srv.model.GetAllEmployeesResponse;
import com.evry.fs.payment.ems.srv.model.GetAllFreeResourcesResponse;
import com.evry.fs.payment.ems.srv.model.GetEmployeeInfoRequest;
import com.evry.fs.payment.ems.srv.model.GetEmployeeInfoResponse;
import com.evry.fs.payment.ems.srv.model.UpdateEmployeeRequest;
import com.evry.fs.payment.ems.srv.model.UpdateEmployeeResponse;

/**
 * 
 * @author venkata.kuppili
 *
 */
@Repository("employeeDao")
public class EmployeeDaoImpl implements EmployeeDao {
	@PersistenceContext
	EntityManager entityManager;
	private final EmployeeDaoMapper employeeDaoMapper;

	/**
	 * 
	 * @param EmployeeDaoMapper
	 */
	@Autowired
	public EmployeeDaoImpl(final EmployeeDaoMapper employeeDaoMapper) {
		this.employeeDaoMapper = employeeDaoMapper;
	}

	@Transactional
	public AddEmployeeResponse addEmployee(AddEmployeeRequest addEmployeeRequest) {
		boolean flag = false;
		EmployeeEntity employeeEntity = employeeDaoMapper.fromModelToEntity(addEmployeeRequest);
		if (!entityManager.contains(employeeEntity)) {
			entityManager.persist(employeeEntity);
			flag = true;
		}
		return employeeDaoMapper.addEmployeeResponse(flag);
	}

	public GetEmployeeInfoResponse getEmployeeInfo(GetEmployeeInfoRequest getEmployeeInfoRequest) {
		EmployeeEntity employeeEntity = entityManager.find(EmployeeEntity.class,
				getEmployeeInfoRequest.getEmployeeId());
		return employeeDaoMapper.fromEntityToModel(employeeEntity);
	}

	@Transactional
	public UpdateEmployeeResponse updateEmployee(UpdateEmployeeRequest updateEmployeeRequest) {
		boolean flag = false;
		EmployeeEntity employeeEntity = entityManager.find(EmployeeEntity.class, updateEmployeeRequest.getEmployeeId());
		if (updateEmployeeRequest != null && entityManager.contains(employeeEntity)) {
			if (!"".equals(updateEmployeeRequest.getEmployeeName())) {
				employeeEntity.setEmployeeName(updateEmployeeRequest.getEmployeeName());
			}
			if (!"".equals(updateEmployeeRequest.getLocation())) {
				employeeEntity.setLocation(updateEmployeeRequest.getLocation());
			}
			if (!"".equals(updateEmployeeRequest.getPassword())) {
				employeeEntity.setPassword(updateEmployeeRequest.getPassword());
			}
			employeeEntity.setAccess(updateEmployeeRequest.getAccess());
			if (updateEmployeeRequest.getProjectId() != 0L) {
				employeeEntity.setProjectId(updateEmployeeRequest.getProjectId());
			}
			entityManager.merge(employeeEntity);
			flag = true;
		}
		return employeeDaoMapper.updateEmployeeResponse(flag);
	}

	public GetAllEmployeesResponse getAllEmployees() {
		Query query = entityManager.createQuery("FROM EmployeeEntity");
		return employeeDaoMapper.employeeEntityListToEmployeeList(query.getResultList());
	}

	@Transactional
	public DeleteEmployeeResponse deleteEmployee(final DeleteEmployeeRequest deleteEmployeeRequest) {
		boolean flag = false;
		EmployeeEntity employeeEntity = entityManager.find(EmployeeEntity.class, deleteEmployeeRequest.getEmployeeId());
		if (null != employeeEntity) {
			entityManager.remove(employeeEntity);
			flag = true;
		}
		return employeeDaoMapper.deleteEmployeeResponse(flag);
	}

	@Override
	public CheckLoginResponse checkLogin(CheckLoginRequest checkLoginRequest) {
		int access;
		try {
			Query query = entityManager.createQuery(
					"SELECT e.access FROM EmployeeEntity e WHERE e.employeeId =:employeeId and e.password =:password")
					.setParameter("employeeId", checkLoginRequest.getEmployeeId())
					.setParameter("password", checkLoginRequest.getPassword());
			access = Integer.parseInt(String.valueOf(query.getResultList().get(0)));
		} catch (Exception e) {
			access = 2;
		}
		return CheckLoginResponse.builder().access(access).build();
	}

	@Override
	public GetAllEmployeesInProjectResponse getAllEmployeesInProject(
			GetAllEmployeesInProjectRequest getAllEmployeesInProjectRequest) {
		Query query = entityManager.createQuery("FROM EmployeeEntity e WHERE e.projectId =:projectId")
				.setParameter("projectId", getAllEmployeesInProjectRequest.getProjectId());

		return employeeDaoMapper.getAllEmployeesInProjectResponseMapper(query.getResultList());
	}

	@Override
	public GetAllFreeResourcesResponse getAllFreeResources() {
		Query query = entityManager.createQuery("FROM EmployeeEntity e WHERE e.projectId = 3245");
		return employeeDaoMapper.getAllFreeResourcesResponseMapper(query.getResultList());
	}

}
