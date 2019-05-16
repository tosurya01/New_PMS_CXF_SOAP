package com.evry.fs.payment.pms.srv.dao.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.evry.fs.payment.ems.srv.dao.entity.EmployeeEntity;

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
@Table(name = "PROJECT")
public class ProjectEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PROJECT_ID")
	private long projectId;
	@Column(name = "PROJECT_NAME")
	private String projectName;
	@Column(name = "PROJECT_STATUS")
	private String projectStatus;
	@Column(name = "ESTIMATED_HRS")
	private int estimatedHrs;
	@Column(name = "LOGGED_HRS")
	private int loggedHrs;
	@Column(name = "REMAINING_HRS")
	private int remainingHrs;
	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name = "PROJECT_ID")
	private Set<EmployeeEntity> employees;
}
