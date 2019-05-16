package com.evry.fs.payment.ems.srv.dao;

import static com.evry.fs.payment.ems.srv.testdata.EmployeeTestDataConstants.ACCESS;
import static com.evry.fs.payment.ems.srv.testdata.EmployeeTestDataConstants.EMPLOYEE_ID;
import static com.evry.fs.payment.ems.srv.testdata.EmployeeTestDataConstants.EMPLOYEE_NAME;
import static com.evry.fs.payment.ems.srv.testdata.EmployeeTestDataConstants.LOCATION;
import static com.evry.fs.payment.ems.srv.testdata.EmployeeTestDataConstants.PASSWORD;
import static com.evry.fs.payment.ems.srv.testdata.EmployeeTestDataConstants.PROJECT_ID;
import static com.evry.fs.payment.ems.srv.testdata.EmployeeTestDataConstants.WRONG_EMPLOYEE_ID;
import static com.evry.fs.payment.pms.srv.testdata.ProjectTestDataConstants.FALSE;
import static com.evry.fs.payment.pms.srv.testdata.ProjectTestDataConstants.TRUE;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.evry.fs.payment.ems.srv.model.CheckLoginRequest;
import com.evry.fs.payment.ems.srv.model.CheckLoginResponse;
import com.evry.fs.payment.ems.srv.model.DeleteEmployeeRequest;
import com.evry.fs.payment.ems.srv.model.DeleteEmployeeResponse;
import com.evry.fs.payment.ems.srv.model.Employee;
import com.evry.fs.payment.ems.srv.model.GetAllEmployeesResponse;
import com.evry.fs.payment.ems.srv.model.GetEmployeeInfoRequest;
import com.evry.fs.payment.ems.srv.model.GetEmployeeInfoResponse;
import com.evry.fs.payment.ems.srv.model.UpdateEmployeeRequest;
import com.evry.fs.payment.ems.srv.model.UpdateEmployeeResponse;

@RunWith(SpringRunner.class)
@ContextConfiguration(locations = { "classpath:META-INF/spring/testApplicationContext.xml" })
public class EmployeeDaoTest {
	@Inject
	EmployeeDao employeeDao;
	@Test
	public void testGetEmployeeInfo() {
		GetEmployeeInfoResponse getEmployeeInfoResponse = employeeDao
				.getEmployeeInfo(GetEmployeeInfoRequest.builder().employeeId(EMPLOYEE_ID).build());
		Employee employee = getEmployeeInfoResponse.getEmployee();
		assertThat(employee.getEmployeeId(), is(equalTo(EMPLOYEE_ID)));
		assertThat(employee.getEmployeeName(), is(equalTo(EMPLOYEE_NAME)));
		assertThat(employee.getAccess(), is(equalTo(ACCESS)));
		assertThat(employee.getLocation(), is(equalTo(LOCATION)));
		assertThat(employee.getPassword(), is(equalTo(PASSWORD)));
		assertThat(employee.getProjectId(), is(equalTo(PROJECT_ID)));
	}

	@Test
	public void testUpdateEmployee() {
		UpdateEmployeeResponse updateEmployeeResponse = employeeDao
				.updateEmployee(UpdateEmployeeRequest.builder().employeeId(EMPLOYEE_ID).employeeName(EMPLOYEE_NAME)
						.access(ACCESS).location(LOCATION).password(PASSWORD).projectId(PROJECT_ID).build());
		assertThat(updateEmployeeResponse.isFlag(), is(equalTo(TRUE)));
	}

	@Test
	public void testGetAllEmployees() {
		GetAllEmployeesResponse getAllEmployeesResponse = employeeDao.getAllEmployees();
		Employee employee = getAllEmployeesResponse.getEmployeeList().get(0);
		assertThat(employee.getEmployeeId(), is(equalTo(EMPLOYEE_ID)));
		assertThat(employee.getEmployeeName(), is(equalTo(EMPLOYEE_NAME)));
		assertThat(employee.getAccess(), is(equalTo(ACCESS)));
		assertThat(employee.getLocation(), is(equalTo(LOCATION)));
		assertThat(employee.getPassword(), is(equalTo(PASSWORD)));
		assertThat(employee.getProjectId(), is(equalTo(PROJECT_ID)));
	}

	@Test
	public void testDeleteEmployee() {
		DeleteEmployeeResponse deleteEmployeeResponse = employeeDao
				.deleteEmployee(DeleteEmployeeRequest.builder().employeeId(WRONG_EMPLOYEE_ID).build());
		assertThat(deleteEmployeeResponse.isFlag(), is(equalTo(FALSE)));
	}

	@Test
	public void testCheckLogin() {
		CheckLoginResponse checkLoginResponse = employeeDao
				.checkLogin(CheckLoginRequest.builder().employeeId(EMPLOYEE_ID).password(PASSWORD).build());
		assertThat(checkLoginResponse.getAccess(), is(equalTo(ACCESS)));
	}
//	@Test
//	public void testAddEmployee() {
//		AddEmployeeResponse addEmployeeResponse = employeeDao
//				.addEmployee(AddEmployeeRequest.builder().employeeName(EMPLOYEE_NAME).access(ACCESS).location(LOCATION)
//						.password(PASSWORD).projectId(PROJECT_ID).build());
//		assertThat(addEmployeeResponse.isFlag(), is(equalTo(TRUE)));
//	}
}
