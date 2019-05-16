package com.evry.fs.payment.ems.srv.ws.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evry.fs.payment.ems.AddEmployeeRequestType;
import com.evry.fs.payment.ems.AddEmployeeResponseType;
import com.evry.fs.payment.ems.CheckLoginRequestType;
import com.evry.fs.payment.ems.CheckLoginResponseType;
import com.evry.fs.payment.ems.DeleteEmployeeRequestType;
import com.evry.fs.payment.ems.DeleteEmployeeResponseType;
import com.evry.fs.payment.ems.GetAllEmployeesInProjectRequestType;
import com.evry.fs.payment.ems.GetAllEmployeesInProjectResponseType;
import com.evry.fs.payment.ems.GetAllEmployeesRequestType;
import com.evry.fs.payment.ems.GetAllEmployeesResponseType;
import com.evry.fs.payment.ems.GetAllFreeResourcesRequestType;
import com.evry.fs.payment.ems.GetAllFreeResourcesResponseType;
import com.evry.fs.payment.ems.GetEmployeeInfoRequestType;
import com.evry.fs.payment.ems.GetEmployeeInfoResponseType;
import com.evry.fs.payment.ems.UpdateEmployeeRequestType;
import com.evry.fs.payment.ems.UpdateEmployeeResponseType;
import com.evry.fs.payment.ems.services.employeeservice_v19_1.EmployeeServiceV191;
import com.evry.fs.payment.ems.srv.model.AddEmployeeRequest;
import com.evry.fs.payment.ems.srv.model.AddEmployeeResponse;
import com.evry.fs.payment.ems.srv.model.CheckLoginRequest;
import com.evry.fs.payment.ems.srv.model.CheckLoginResponse;
import com.evry.fs.payment.ems.srv.model.GetAllEmployeesInProjectRequest;
import com.evry.fs.payment.ems.srv.model.GetAllEmployeesInProjectResponse;
import com.evry.fs.payment.ems.srv.model.GetAllEmployeesResponse;
import com.evry.fs.payment.ems.srv.model.GetAllFreeResourcesResponse;
import com.evry.fs.payment.ems.srv.model.GetEmployeeInfoResponse;
import com.evry.fs.payment.ems.srv.service.AddEmployee;
import com.evry.fs.payment.ems.srv.service.CheckLogin;
import com.evry.fs.payment.ems.srv.service.DeleteEmployee;
import com.evry.fs.payment.ems.srv.service.GetAllEmployees;
import com.evry.fs.payment.ems.srv.service.GetAllEmployeesInProject;
import com.evry.fs.payment.ems.srv.service.GetAllFreeResources;
import com.evry.fs.payment.ems.srv.service.GetEmployeeInfo;
import com.evry.fs.payment.ems.srv.service.UpdateEmployee;
import com.evry.fs.payment.ems.srv.service.mapper.EmployeeV19_1WsMapper;

@Service("employeeServiceV191")
public class EmployeeServiceV191Impl implements EmployeeServiceV191 {
	private final AddEmployee addEmployee;
	private final GetEmployeeInfo getEmployeeInfo;
	private final UpdateEmployee updateEmployee;
	private final DeleteEmployee deleteEmployee;
	private final GetAllEmployees getAllEmployees;
	private final CheckLogin checkLogin;
	private final GetAllEmployeesInProject getAllEmployeesInProject;
	private final GetAllFreeResources getAllFreeResources;
	private final EmployeeV19_1WsMapper employeeV19_1WsMapper;

	@Autowired
	public EmployeeServiceV191Impl(AddEmployee addEmployee, GetEmployeeInfo getEmployeeInfo,
			UpdateEmployee updateEmployee, DeleteEmployee deleteEmployee, GetAllEmployees getAllEmployees,
			GetAllEmployeesInProject getAllEmployeesInProject, GetAllFreeResources getAllFreeResources,
			CheckLogin checkLogin, EmployeeV19_1WsMapper employeeV19_1WsMapper) {
		this.addEmployee = addEmployee;
		this.getEmployeeInfo = getEmployeeInfo;
		this.updateEmployee = updateEmployee;
		this.deleteEmployee = deleteEmployee;
		this.getAllEmployees = getAllEmployees;
		this.checkLogin = checkLogin;
		this.getAllEmployeesInProject = getAllEmployeesInProject;
		this.getAllFreeResources = getAllFreeResources;
		this.employeeV19_1WsMapper = employeeV19_1WsMapper;
	}

	@Override
	public GetEmployeeInfoResponseType getEmployeeInfo(GetEmployeeInfoRequestType getEmployeeInfoRequestType) {
		GetEmployeeInfoResponse getEmployeeInfoResponse = getEmployeeInfo
				.getEmployeeInfo(employeeV19_1WsMapper.fromWsToDomain(getEmployeeInfoRequestType));
		GetEmployeeInfoResponseType resp = employeeV19_1WsMapper.fromDomainToWs(getEmployeeInfoResponse);
		return resp;
	}

	@Override
	public DeleteEmployeeResponseType deleteEmployee(DeleteEmployeeRequestType deleteEmployeeRequestType) {
		return employeeV19_1WsMapper.fromDomainToWs(
				deleteEmployee.deleteEmployee(employeeV19_1WsMapper.fromWsToDomain(deleteEmployeeRequestType)));
	}

	@Override
	public AddEmployeeResponseType addEmployee(AddEmployeeRequestType addEmployeeRequestType) {
		AddEmployeeRequest addEmployeeRequest = employeeV19_1WsMapper.fromWsToDomain(addEmployeeRequestType);
		AddEmployeeResponse addEmployeeResponse = addEmployee.addEmployee(addEmployeeRequest);
		return employeeV19_1WsMapper.fromDomainToWs(addEmployeeResponse);
	}

	@Override
	public UpdateEmployeeResponseType updateEmployee(UpdateEmployeeRequestType updateEmployeeRequestType) {
		return employeeV19_1WsMapper.fromDomainToWs(
				updateEmployee.updateEmployee(employeeV19_1WsMapper.fromWsToDomain(updateEmployeeRequestType)));
	}

	@Override
	public GetAllEmployeesResponseType getAllEmployees(GetAllEmployeesRequestType getAllEmployeesRequestType) {
		GetAllEmployeesResponse getAllEmployeesResponse = getAllEmployees.getAllEmployees();
		return employeeV19_1WsMapper.fromDomainToWs(getAllEmployeesResponse);
	}

	@Override
	public CheckLoginResponseType checkLogin(CheckLoginRequestType checkLoginRequestType) {
		CheckLoginRequest checkLoginRequest = employeeV19_1WsMapper
				.loginRequestTypeToLoginRequest(checkLoginRequestType);
		CheckLoginResponse checkLoginResponse = checkLogin.checkLogin(checkLoginRequest);
		return employeeV19_1WsMapper.loginResponseTologinResponseType(checkLoginResponse);
	}

	@Override
	public GetAllEmployeesInProjectResponseType getAllEmployeesInProject(
			GetAllEmployeesInProjectRequestType getAllEmployeesInProjectRequestType) {
		GetAllEmployeesInProjectResponse getAllEmployeesInProjectResponse = getAllEmployeesInProject
				.getAllEmployeesInProject(employeeV19_1WsMapper.fromWsToDomain(getAllEmployeesInProjectRequestType));
		return employeeV19_1WsMapper.fromDomainToWs(getAllEmployeesInProjectResponse);
	}

	@Override
	public GetAllFreeResourcesResponseType getAllFreeResources(
			GetAllFreeResourcesRequestType getAllFreeResourcesRequestType) {
		GetAllFreeResourcesResponse getAllFreeResourcesResponse = getAllFreeResources.getAllFreeResources();
		return employeeV19_1WsMapper.fromDomainToWs(getAllFreeResourcesResponse);
	}
}
