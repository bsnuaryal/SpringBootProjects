package com.ems.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

@Entity
@Table(name = "EMPLOYEE_INFO")
@Data
public class EmployeeEntity {

	@Id
	@GenericGenerator(name = "myGenerator", strategy = "increment")
	@GeneratedValue(generator = "myGenerator", strategy = GenerationType.AUTO)
	@Column(name = "EMP_ID")
	private Integer id;
	@Column(name = "EMP_NAME")
	private String empName;
	@Column(name = "EMP_SALARY")
	private double empSalary;

}
