package com.evry.fs.payment.ems.srv.dao;

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

public interface EmployeeDao {
	/**
	 * 
	 * @param addEmployeeRequest
	 * @return
	 */
	public AddEmployeeResponse addEmployee(final AddEmployeeRequest addEmployeeRequest);

	/**
	 * 
	 * @param getEmployeeInfoRequest
	 * @return
	 */
	public GetEmployeeInfoResponse getEmployeeInfo(final GetEmployeeInfoRequest getEmployeeInfoRequest);

	/**
	 * 
	 * @param updateEmployeeRequest
	 * @return
	 */
	public UpdateEmployeeResponse updateEmployee(final UpdateEmployeeRequest updateEmployeeRequest);

	/**
	 * 
	 * @param getAllEmployeesRequest
	 * @return
	 */
	public GetAllEmployeesResponse getAllEmployees();

	/**
	 * 
	 * @param deleteEmployeesRequest
	 * @return
	 */
	public DeleteEmployeeResponse deleteEmployee(final DeleteEmployeeRequest deleteEmployeesRequest);

	public CheckLoginResponse checkLogin(CheckLoginRequest checkLoginRequest);

	public GetAllEmployeesInProjectResponse getAllEmployeesInProject(
			GetAllEmployeesInProjectRequest getAllEmployeesInProjectRequest);

	public GetAllFreeResourcesResponse getAllFreeResources();
}
