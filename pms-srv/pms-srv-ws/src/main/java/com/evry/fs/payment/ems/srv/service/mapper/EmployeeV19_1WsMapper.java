package com.evry.fs.payment.ems.srv.service.mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import com.evry.fs.payment.ems.AddEmployeeRequestType;
import com.evry.fs.payment.ems.AddEmployeeResponseType;
import com.evry.fs.payment.ems.CheckLoginRequestType;
import com.evry.fs.payment.ems.CheckLoginResponseType;
import com.evry.fs.payment.ems.DeleteEmployeeRequestType;
import com.evry.fs.payment.ems.DeleteEmployeeResponseType;
import com.evry.fs.payment.ems.EmployeeType;
import com.evry.fs.payment.ems.GetAllEmployeesInProjectRequestType;
import com.evry.fs.payment.ems.GetAllEmployeesInProjectResponseType;
import com.evry.fs.payment.ems.GetAllEmployeesResponseType;
import com.evry.fs.payment.ems.GetAllFreeResourcesResponseType;
import com.evry.fs.payment.ems.GetEmployeeInfoRequestType;
import com.evry.fs.payment.ems.GetEmployeeInfoResponseType;
import com.evry.fs.payment.ems.UpdateEmployeeRequestType;
import com.evry.fs.payment.ems.UpdateEmployeeResponseType;
import com.evry.fs.payment.ems.srv.model.AddEmployeeRequest;
import com.evry.fs.payment.ems.srv.model.AddEmployeeResponse;
import com.evry.fs.payment.ems.srv.model.CheckLoginRequest;
import com.evry.fs.payment.ems.srv.model.CheckLoginResponse;
import com.evry.fs.payment.ems.srv.model.DeleteEmployeeRequest;
import com.evry.fs.payment.ems.srv.model.DeleteEmployeeResponse;
import com.evry.fs.payment.ems.srv.model.Employee;
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
@Component("employeeV19_1WsMapper")
public class EmployeeV19_1WsMapper {

	public AddEmployeeRequest fromWsToDomain(AddEmployeeRequestType addEmployeeRequestType) {
		return AddEmployeeRequest.builder().employeeName(addEmployeeRequestType.getEmployeeName())
				.location(addEmployeeRequestType.getLocation()).password(addEmployeeRequestType.getPassword())
				.projectId(addEmployeeRequestType.getProjectId()).access(addEmployeeRequestType.getAccess()).build();
	}

	public AddEmployeeResponseType fromDomainToWs(AddEmployeeResponse addEmployeeResponse) {
		AddEmployeeResponseType addEmployeeResponseType = new AddEmployeeResponseType();
		addEmployeeResponseType.setFlag(addEmployeeResponse.isFlag());
		return addEmployeeResponseType;
	}

	public GetEmployeeInfoRequest fromWsToDomain(GetEmployeeInfoRequestType getEmployeeInfoRequestType) {

		return GetEmployeeInfoRequest.builder().employeeId(getEmployeeInfoRequestType.getEmployeeId()).build();
	}

	public GetEmployeeInfoResponseType fromDomainToWs(GetEmployeeInfoResponse getEmployeeInfoResponse) {
		GetEmployeeInfoResponseType getEmployeeInfoResponseType = new GetEmployeeInfoResponseType();
		getEmployeeInfoResponseType.setEmployeeType(employeeToEmployeeType(getEmployeeInfoResponse.getEmployee()));
		return getEmployeeInfoResponseType;
	}

	private EmployeeType employeeToEmployeeType(Employee employee) {
		EmployeeType employeeType = new EmployeeType();
		employeeType.setEmployeeId(employee.getEmployeeId());
		employeeType.setEmployeeName(employee.getEmployeeName());
		employeeType.setLocation(employee.getLocation());
		employeeType.setPassword(employee.getPassword());
		employeeType.setAccess(employee.getAccess());
		employeeType.setProjectId(employee.getProjectId());
		return employeeType;
	}

	public UpdateEmployeeRequest fromWsToDomain(UpdateEmployeeRequestType updateEmployeeRequestType) {
		return UpdateEmployeeRequest.builder().employeeId(updateEmployeeRequestType.getEmployeeId())
				.employeeName(updateEmployeeRequestType.getEmployeeName())
				.location(updateEmployeeRequestType.getLocation()).password(updateEmployeeRequestType.getPassword())
				.projectId(updateEmployeeRequestType.getProjectId()).access(updateEmployeeRequestType.getAccess())
				.build();
	}

	public UpdateEmployeeResponseType fromDomainToWs(UpdateEmployeeResponse updateEmployeeResponse) {
		UpdateEmployeeResponseType updateEmployeeResponseType = new UpdateEmployeeResponseType();
		updateEmployeeResponseType.setFlag(updateEmployeeResponse.isFlag());
		return updateEmployeeResponseType;
	}

	public DeleteEmployeeRequest fromWsToDomain(DeleteEmployeeRequestType deleteEmployeeRequestType) {

		return DeleteEmployeeRequest.builder().employeeId(deleteEmployeeRequestType.getEmployeeId()).build();
	}

	public DeleteEmployeeResponseType fromDomainToWs(DeleteEmployeeResponse deleteEmployeeResponse) {
		DeleteEmployeeResponseType deleteEmployeeResponseType = new DeleteEmployeeResponseType();
		deleteEmployeeResponseType.setFlag(deleteEmployeeResponse.isFlag());
		return deleteEmployeeResponseType;
	}

	public GetAllEmployeesResponseType fromDomainToWs(GetAllEmployeesResponse getAllEmployeesResponse) {
		List<Employee> employeeList = getAllEmployeesResponse.getEmployeeList();
		GetAllEmployeesResponseType getAllEmployeesResponseType = new GetAllEmployeesResponseType();
		List<EmployeeType> employeeTypeList = getAllEmployeesResponseType.getEmployeeType();
		for (Employee employee : employeeList) {
			employeeTypeList.add(employeeToEmployeeType(employee));
		}

		return getAllEmployeesResponseType;
	}

	public CheckLoginRequest loginRequestTypeToLoginRequest(CheckLoginRequestType checkLoginRequestType) {

		return CheckLoginRequest.builder().employeeId(checkLoginRequestType.getEmployeeId())
				.password(checkLoginRequestType.getPassword()).build();
	}

	public CheckLoginResponseType loginResponseTologinResponseType(CheckLoginResponse checkLoginResponse) {
		CheckLoginResponseType checkLoginResponseType = new CheckLoginResponseType();
		checkLoginResponseType.setAccess(checkLoginResponse.getAccess());
		return checkLoginResponseType;
	}

	public GetAllEmployeesInProjectRequest fromWsToDomain(
			GetAllEmployeesInProjectRequestType getAllEmployeesInProjectRequestType) {

		return GetAllEmployeesInProjectRequest.builder().projectId(getAllEmployeesInProjectRequestType.getProjectId())
				.build();
	}

	public GetAllEmployeesInProjectResponseType fromDomainToWs(
			GetAllEmployeesInProjectResponse getAllEmployeesInProjectResponse) {
		List<Employee> employeeList = getAllEmployeesInProjectResponse.getEmployeeList();
		GetAllEmployeesInProjectResponseType getAllEmployeesInProjectResponseType = new GetAllEmployeesInProjectResponseType();
		List<EmployeeType> employeeTypeList = getAllEmployeesInProjectResponseType.getEmployeeType();
		for (Employee employee : employeeList) {
			employeeTypeList.add(employeeToEmployeeType(employee));
		}

		return getAllEmployeesInProjectResponseType;
	}

	public GetAllFreeResourcesResponseType fromDomainToWs(GetAllFreeResourcesResponse getAllFreeResourcesResponse) {
		List<Employee> employeeList = getAllFreeResourcesResponse.getEmployeeList();
		GetAllFreeResourcesResponseType getAllFreeResourcesResponseType = new GetAllFreeResourcesResponseType();
		List<EmployeeType> employeeTypeList = getAllFreeResourcesResponseType.getEmployeeType();
		for (Employee employee : employeeList) {
			employeeTypeList.add(employeeToEmployeeType(employee));
		}

		return getAllFreeResourcesResponseType;
	}
}
