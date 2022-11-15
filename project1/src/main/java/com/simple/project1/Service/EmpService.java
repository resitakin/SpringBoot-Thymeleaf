package com.simple.project1.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simple.project1.Repository.EmpRepository;
import com.simple.project1.model.Employee;

@Service
public class EmpService implements IEmpService{
	
	@Autowired private EmpRepository empRepo;
	@Override
	public List<Employee> getAllEmployee() {
		
		return empRepo.findAll();
	}

	@Override
	public void save(Employee employee) {
		empRepo.save(employee);
		
	}

	@Override
	public Employee getById(Long id) {
		 Optional<Employee> optional = empRepo.findById(id);
	        Employee employee = null;
	        if (optional.isPresent()) 
	            employee = optional.get();
	        
	        else 
	            throw new RuntimeException("Employee not found for id : " + id);
	        
	        return employee;
	
	}

	@Override
	public void deleteViaId(long id) {
		empRepo.deleteById(id);
		
	}
	

}
