package com.evry.fs.payment.ems.srv.dao.mapper;

import static com.evry.fs.payment.ems.srv.testdata.EmployeeTestDataConstants.ACCESS;
import static com.evry.fs.payment.ems.srv.testdata.EmployeeTestDataConstants.EMPLOYEE_ID;
import static com.evry.fs.payment.ems.srv.testdata.EmployeeTestDataConstants.EMPLOYEE_NAME;
import static com.evry.fs.payment.ems.srv.testdata.EmployeeTestDataConstants.LOCATION;
import static com.evry.fs.payment.ems.srv.testdata.EmployeeTestDataConstants.PASSWORD;
import static com.evry.fs.payment.ems.srv.testdata.EmployeeTestDataConstants.PROJECT_ID;
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

import com.evry.fs.payment.ems.srv.dao.entity.EmployeeEntity;
import com.evry.fs.payment.ems.srv.model.AddEmployeeRequest;
import com.evry.fs.payment.ems.srv.model.AddEmployeeResponse;
import com.evry.fs.payment.ems.srv.model.DeleteEmployeeResponse;
import com.evry.fs.payment.ems.srv.model.Employee;
import com.evry.fs.payment.ems.srv.model.GetAllEmployeesResponse;
import com.evry.fs.payment.ems.srv.model.GetEmployeeInfoResponse;
import com.evry.fs.payment.ems.srv.model.UpdateEmployeeResponse;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeDaoMapperTest {
	@InjectMocks
	private static EmployeeDaoMapper mapper;

	@Test
	public void testFromModelToEntity() {
		EmployeeEntity employeeEntity = mapper
				.fromModelToEntity(AddEmployeeRequest.builder().employeeName(EMPLOYEE_NAME).access(ACCESS)
						.location(LOCATION).password(PASSWORD).projectId(PROJECT_ID).build());
		assertThat(employeeEntity.getEmployeeName(), is(equalTo(EMPLOYEE_NAME)));
		assertThat(employeeEntity.getAccess(), is(equalTo(ACCESS)));
		assertThat(employeeEntity.getLocation(), is(equalTo(LOCATION)));
		assertThat(employeeEntity.getPassword(), is(equalTo(PASSWORD)));
		assertThat(employeeEntity.getProjectId(), is(equalTo(PROJECT_ID)));
	}

	@Test
	public void testAddEmployeeResponse() {
		AddEmployeeResponse addProjectResponse = mapper.addEmployeeResponse(TRUE);
		assertThat(addProjectResponse.isFlag(), is(equalTo(TRUE)));
	}

	@Test
	public void testFromEntityToModel() {
		EmployeeEntity employeeEntity = new EmployeeEntity();
		employeeEntity.setEmployeeId(EMPLOYEE_ID);
		employeeEntity.setEmployeeName(EMPLOYEE_NAME);
		employeeEntity.setLocation(LOCATION);
		employeeEntity.setPassword(PASSWORD);
		employeeEntity.setAccess(ACCESS);
		employeeEntity.setProjectId(PROJECT_ID);
		GetEmployeeInfoResponse getEmployeeInfoResponse = mapper.fromEntityToModel(employeeEntity);
		Employee employee = getEmployeeInfoResponse.getEmployee();
		assertThat(employee.getEmployeeId(), is(equalTo(EMPLOYEE_ID)));
		assertThat(employee.getEmployeeName(), is(equalTo(EMPLOYEE_NAME)));
		assertThat(employee.getAccess(), is(equalTo(ACCESS)));
		assertThat(employee.getLocation(), is(equalTo(LOCATION)));
		assertThat(employee.getPassword(), is(equalTo(PASSWORD)));
		assertThat(employee.getProjectId(), is(equalTo(PROJECT_ID)));
	}

	@Test
	public void testUpdateEmployeeResponse() {
		UpdateEmployeeResponse updateEmployeeResponse = mapper.updateEmployeeResponse(TRUE);
		assertThat(updateEmployeeResponse.isFlag(), is(equalTo(TRUE)));
	}

	@Test
	public void testEmployeeEntityListToEmployeeList() {
		List<EmployeeEntity> employeeEntityList = new ArrayList<EmployeeEntity>();
		EmployeeEntity employeeEntity = new EmployeeEntity();
		employeeEntity.setEmployeeId(EMPLOYEE_ID);
		employeeEntity.setEmployeeName(EMPLOYEE_NAME);
		employeeEntity.setLocation(LOCATION);
		employeeEntity.setPassword(PASSWORD);
		employeeEntity.setAccess(ACCESS);
		employeeEntity.setProjectId(PROJECT_ID);
		employeeEntityList.add(employeeEntity);
		GetAllEmployeesResponse getAllEmployeesResponse = mapper.employeeEntityListToEmployeeList(employeeEntityList);
		Employee employee = getAllEmployeesResponse.getEmployeeList().get(0);
		assertThat(employee.getEmployeeId(), is(equalTo(EMPLOYEE_ID)));
		assertThat(employee.getEmployeeName(), is(equalTo(EMPLOYEE_NAME)));
		assertThat(employee.getAccess(), is(equalTo(ACCESS)));
		assertThat(employee.getLocation(), is(equalTo(LOCATION)));
		assertThat(employee.getPassword(), is(equalTo(PASSWORD)));
		assertThat(employee.getProjectId(), is(equalTo(PROJECT_ID)));
	}

	@Test
	public void testFromEntityToModel2() {
		EmployeeEntity employeeEntity = new EmployeeEntity();
		employeeEntity.setEmployeeId(EMPLOYEE_ID);
		employeeEntity.setEmployeeName(EMPLOYEE_NAME);
		employeeEntity.setLocation(LOCATION);
		employeeEntity.setPassword(PASSWORD);
		employeeEntity.setAccess(ACCESS);
		employeeEntity.setProjectId(PROJECT_ID);
		Employee employee = mapper.fromEntityToModel2(employeeEntity);
		assertThat(employee.getEmployeeId(), is(equalTo(EMPLOYEE_ID)));
		assertThat(employee.getEmployeeName(), is(equalTo(EMPLOYEE_NAME)));
		assertThat(employee.getAccess(), is(equalTo(ACCESS)));
		assertThat(employee.getLocation(), is(equalTo(LOCATION)));
		assertThat(employee.getPassword(), is(equalTo(PASSWORD)));
		assertThat(employee.getProjectId(), is(equalTo(PROJECT_ID)));
	}

	@Test
	public void testDeleteEmployeeResponse() {
		DeleteEmployeeResponse deleteEmployeeResponse = mapper.deleteEmployeeResponse(TRUE);
		assertThat(deleteEmployeeResponse.isFlag(), is(equalTo(TRUE)));
	}

}
