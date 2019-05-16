package com.evry.fs.payment.ems.services.employeeservice_v19_1;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;

/**
 * This class was generated by Apache CXF 3.0.2
 * 2019-05-15T15:10:19.535+05:30
 * Generated source version: 3.0.2
 * 
 */
@WebService(targetNamespace = "http://evry.com/fs/payment/ems/services/EmployeeService_V19_1/", name = "EmployeeService_V19_1")
@XmlSeeAlso({com.evry.fs.payment.ems.ObjectFactory.class})
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
public interface EmployeeServiceV191 {

    @WebMethod(action = "http://evry.com/fs/payment/ems/services/EmployeeService_V19_1/getEmployeesInfo")
    @WebResult(name = "getEmployeeInfoResponseType", targetNamespace = "http://evry.com/fs/payment/ems", partName = "parameters")
    public com.evry.fs.payment.ems.GetEmployeeInfoResponseType getEmployeeInfo(
        @WebParam(partName = "parameters", name = "getEmployeeInfoRequestType", targetNamespace = "http://evry.com/fs/payment/ems")
        com.evry.fs.payment.ems.GetEmployeeInfoRequestType parameters
    );

    @WebMethod(action = "http://evry.com/fs/payment/ems/services/EmployeeService_V19_1/deleteEmployee")
    @WebResult(name = "deleteEmployeeResponseType", targetNamespace = "http://evry.com/fs/payment/ems", partName = "parameters")
    public com.evry.fs.payment.ems.DeleteEmployeeResponseType deleteEmployee(
        @WebParam(partName = "parameters", name = "deleteEmployeeRequestType", targetNamespace = "http://evry.com/fs/payment/ems")
        com.evry.fs.payment.ems.DeleteEmployeeRequestType parameters
    );

    @WebMethod(action = "http://evry.com/fs/payment/ems/services/EmployeeService_V19_1/checkLogin")
    @WebResult(name = "checkLoginResponseType", targetNamespace = "http://evry.com/fs/payment/ems", partName = "parameters")
    public com.evry.fs.payment.ems.CheckLoginResponseType checkLogin(
        @WebParam(partName = "parameters", name = "checkLoginRequestType", targetNamespace = "http://evry.com/fs/payment/ems")
        com.evry.fs.payment.ems.CheckLoginRequestType parameters
    );

    @WebMethod(action = "http://evry.com/fs/payment/ems/services/EmployeeService_V19_1/getAllEmployeesInProject")
    @WebResult(name = "getAllEmployeesInProjectResponseType", targetNamespace = "http://evry.com/fs/payment/ems", partName = "parameters")
    public com.evry.fs.payment.ems.GetAllEmployeesInProjectResponseType getAllEmployeesInProject(
        @WebParam(partName = "parameters", name = "getAllEmployeesInProjectRequestType", targetNamespace = "http://evry.com/fs/payment/ems")
        com.evry.fs.payment.ems.GetAllEmployeesInProjectRequestType parameters
    );

    @WebMethod(action = "http://evry.com/fs/payment/ems/services/EmployeeService_V19_1/addEmployee")
    @WebResult(name = "addEmployeeResponseType", targetNamespace = "http://evry.com/fs/payment/ems", partName = "parameters")
    public com.evry.fs.payment.ems.AddEmployeeResponseType addEmployee(
        @WebParam(partName = "parameters", name = "addEmployeeRequestType", targetNamespace = "http://evry.com/fs/payment/ems")
        com.evry.fs.payment.ems.AddEmployeeRequestType parameters
    );

    @WebMethod(action = "http://evry.com/fs/payment/ems/services/EmployeeService_V19_1/getAllEmployees")
    @WebResult(name = "getAllEmployeesResponseType", targetNamespace = "http://evry.com/fs/payment/ems", partName = "parameters")
    public com.evry.fs.payment.ems.GetAllEmployeesResponseType getAllEmployees(
        @WebParam(partName = "parameters", name = "getAllEmployeesRequestType", targetNamespace = "http://evry.com/fs/payment/ems")
        com.evry.fs.payment.ems.GetAllEmployeesRequestType parameters
    );

    @WebMethod(action = "http://evry.com/fs/payment/ems/services/EmployeeService_V19_1/getAllFreeResources")
    @WebResult(name = "getAllFreeResourcesResponseType", targetNamespace = "http://evry.com/fs/payment/ems", partName = "parameters")
    public com.evry.fs.payment.ems.GetAllFreeResourcesResponseType getAllFreeResources(
        @WebParam(partName = "parameters", name = "getAllFreeResourcesRequestType", targetNamespace = "http://evry.com/fs/payment/ems")
        com.evry.fs.payment.ems.GetAllFreeResourcesRequestType parameters
    );

    @WebMethod(action = "http://evry.com/fs/payment/ems/services/EmployeeService_V19_1/updateEmployee")
    @WebResult(name = "updateEmployeeResponseType", targetNamespace = "http://evry.com/fs/payment/ems", partName = "parameters")
    public com.evry.fs.payment.ems.UpdateEmployeeResponseType updateEmployee(
        @WebParam(partName = "parameters", name = "updateEmployeeRequestType", targetNamespace = "http://evry.com/fs/payment/ems")
        com.evry.fs.payment.ems.UpdateEmployeeRequestType parameters
    );
}
