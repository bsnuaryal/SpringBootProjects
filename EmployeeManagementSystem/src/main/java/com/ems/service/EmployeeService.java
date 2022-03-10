package com.ems.service;

import java.util.List;

import com.ems.model.EmployeeModel;

public interface EmployeeService {

	public boolean saveEmployee(EmployeeModel employee);

	public List<EmployeeModel> viewAllEmployees();

	public boolean updateEmployee(EmployeeModel emp);

	public void deleteEmployee(Integer id);

	public EmployeeModel getEmployeeById(Integer id);
}
