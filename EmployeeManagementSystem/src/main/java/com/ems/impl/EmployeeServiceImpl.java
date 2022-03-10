package com.ems.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.ems.entity.EmployeeEntity;
import com.ems.model.EmployeeModel;
import com.ems.repos.EmployeeRepo;
import com.ems.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepo employeeDao;

	@Override
	public boolean saveEmployee(EmployeeModel employee) {
		// TODO Auto-generated method stub
		EmployeeEntity empEntity = new EmployeeEntity();

		BeanUtils.copyProperties(employee, empEntity);
		EmployeeEntity savedEmployee = employeeDao.save(empEntity);

		return savedEmployee.getId() != null;
		// return empEntity.getId()!=0;
	}

	@Override
	public List<EmployeeModel> viewAllEmployees() {
		// TODO Auto-generated method stub
		List<EmployeeEntity> employeesList = employeeDao.findAll();
		List<EmployeeModel> employees = new ArrayList<EmployeeModel>();

		employeesList.forEach(employee -> {
			EmployeeModel emp = new EmployeeModel();
			BeanUtils.copyProperties(employee, emp);
			employees.add(emp);
		});
		return employees;
	}

	@Override
	public boolean updateEmployee(EmployeeModel emp) {
		// TODO Auto-generated method stub
		Optional<EmployeeEntity> employee = employeeDao.findById(emp.getId());
		EmployeeEntity empEntity = employee.get();
		return employeeDao.save(empEntity) != null;
	}

	@Override
	public void deleteEmployee(Integer id) {
		// TODO Auto-generated method stub
		employeeDao.deleteById(id);
	}

	@Override
	public EmployeeModel getEmployeeById(Integer id) {
		// TODO Auto-generated method stub
		Optional<EmployeeEntity> employee = employeeDao.findById(id);
		EmployeeEntity empEntity = employee.get();
		EmployeeModel employeeInfoCarrier = new EmployeeModel();
		BeanUtils.copyProperties(empEntity, employeeInfoCarrier);
		return employeeInfoCarrier;
	}

}
