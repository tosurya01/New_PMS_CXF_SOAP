package com.evry.fs.payment.ems.srv.dao.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.evry.fs.payment.ems.srv.dao.entity.EmployeeEntity;
import com.evry.fs.payment.ems.srv.model.AddEmployeeRequest;
import com.evry.fs.payment.ems.srv.model.AddEmployeeResponse;
import com.evry.fs.payment.ems.srv.model.DeleteEmployeeResponse;
import com.evry.fs.payment.ems.srv.model.Employee;
import com.evry.fs.payment.ems.srv.model.GetAllEmployeesInProjectResponse;
import com.evry.fs.payment.ems.srv.model.GetAllEmployeesResponse;
import com.evry.fs.payment.ems.srv.model.GetAllFreeResourcesResponse;
import com.evry.fs.payment.ems.srv.model.GetEmployeeInfoResponse;
import com.evry.fs.payment.ems.srv.model.UpdateEmployeeResponse;

/**
 * 
 * @author venkata.kuppili
 *
 */
@Component("employeeDaoMapper")
public class EmployeeDaoMapper {

	public EmployeeEntity fromModelToEntity(AddEmployeeRequest addEmployeeRequest) {
		EmployeeEntity employeeEntity = new EmployeeEntity();
		employeeEntity.setEmployeeName(addEmployeeRequest.getEmployeeName());
		employeeEntity.setLocation(addEmployeeRequest.getLocation());
		employeeEntity.setPassword(addEmployeeRequest.getPassword());
		employeeEntity.setAccess(addEmployeeRequest.getAccess());
		employeeEntity.setProjectId(addEmployeeRequest.getProjectId());
		return employeeEntity;
	}

	public AddEmployeeResponse addEmployeeResponse(boolean flag) {
		return AddEmployeeResponse.builder().flag(flag).build();
	}

	public GetEmployeeInfoResponse fromEntityToModel(EmployeeEntity employeeEntity) {
		Employee employee = Employee.builder().employeeId(employeeEntity.getEmployeeId())
				.employeeName(employeeEntity.getEmployeeName()).location(employeeEntity.getLocation())
				.password(employeeEntity.getPassword()).access(employeeEntity.getAccess())
				.projectId(employeeEntity.getProjectId()).build();
		GetEmployeeInfoResponse response = GetEmployeeInfoResponse.builder().employee(employee).build();
		return response;
	}

	public UpdateEmployeeResponse updateEmployeeResponse(boolean flag) {
		return UpdateEmployeeResponse.builder().flag(flag).build();
	}

	public GetAllEmployeesResponse employeeEntityListToEmployeeList(List<EmployeeEntity> employeeEntityList) {
		List<Employee> employeeList = new ArrayList<Employee>();
		for (EmployeeEntity employeeEntity : employeeEntityList) {
			employeeList.add(fromEntityToModel2(employeeEntity));
		}
		return GetAllEmployeesResponse.builder().employeeList(employeeList).build();
	}

	public Employee fromEntityToModel2(EmployeeEntity employeeEntity) {
		return Employee.builder().employeeId(employeeEntity.getEmployeeId())
				.employeeName(employeeEntity.getEmployeeName()).location(employeeEntity.getLocation())
				.password(employeeEntity.getPassword()).access(employeeEntity.getAccess())
				.projectId(employeeEntity.getProjectId()).build();
	}

	public DeleteEmployeeResponse deleteEmployeeResponse(boolean flag) {
		return DeleteEmployeeResponse.builder().flag(flag).build();
	}

	public GetAllEmployeesInProjectResponse getAllEmployeesInProjectResponseMapper(
			List<EmployeeEntity> employeeEntityList) {
		List<Employee> employeeList = new ArrayList<Employee>();
		for (EmployeeEntity employeeEntity : employeeEntityList) {
			employeeList.add(fromEntityToModel2(employeeEntity));
		}
		return GetAllEmployeesInProjectResponse.builder().employeeList(employeeList).build();
	}

	public GetAllFreeResourcesResponse getAllFreeResourcesResponseMapper(List<EmployeeEntity> employeeEntityList) {
		List<Employee> employeeList = new ArrayList<Employee>();
		for (EmployeeEntity employeeEntity : employeeEntityList) {
			employeeList.add(fromEntityToModel2(employeeEntity));
		}
		return GetAllFreeResourcesResponse.builder().employeeList(employeeList).build();
	}
}
