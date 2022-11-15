package com.simple.project1.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
 
import com.simple.project1.model.Employee;
 
@Repository
public interface EmpRepository extends JpaRepository<Employee,Long> {

	

}
