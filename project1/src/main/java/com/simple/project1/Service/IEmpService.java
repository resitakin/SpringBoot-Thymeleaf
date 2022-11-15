package com.simple.project1.Service;

import java.util.List;

import com.simple.project1.model.Employee;

public interface IEmpService {
	
	List<Employee> getAllEmployee();
	void save(Employee employee);
	Employee getById(Long id);
	void deleteViaId(long id);
	

}
