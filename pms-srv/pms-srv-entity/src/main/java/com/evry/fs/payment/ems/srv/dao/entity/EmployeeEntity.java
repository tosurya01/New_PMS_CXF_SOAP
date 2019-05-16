package com.evry.fs.payment.ems.srv.dao.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.evry.fs.payment.pms.srv.dao.entity.ProjectEntity;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @author venkata.kuppili
 *
 */

@Setter
@Getter

@Entity
@Table(name = "EMPLOYEE")
public class EmployeeEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "EMPLOYEE_ID")
	private long employeeId;
	@Column(name = "EMPLOYEE_NAME")
	private String employeeName;
	@Column(name = "LOCATION")
	private String location;
	@Column(name = "PASSWORD")
	private String password;
	@Column(name = "ACCESS")
	private int access;
	@Column(name = "PROJECT_ID")
	private long projectId;

}
