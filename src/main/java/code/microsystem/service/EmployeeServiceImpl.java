package code.microsystem.service;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import code.microsystem.entity.Employee;
import code.microsystem.exception.ResourceNotFoundException;
import code.microsystem.repositroy.EmployeeRepositroy;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	

	@Autowired
	EmployeeRepositroy employeeRepositroy;

	@Override
	public Employee addNewEMp(Employee employee) {
		
		return employeeRepositroy.save(employee);
	}

	@Override
	public List<Employee> getAllEmployee() {
		return employeeRepositroy.findAll();
	}

	@Override
	public Optional<Employee> findById(int id) {
		
		return employeeRepositroy.findById(id);
	}

	@Override
	public Optional<Employee> findByFname(String name) {
		
		return employeeRepositroy.findByFname(name);
	}

	@Override
	public Employee editEmp(int id, Employee employee) {
		
		Employee emp=employeeRepositroy.findById(id)
				.orElseThrow(()->new ResourceNotFoundException("Employee doenot exits"+id));
		emp.setId(id);
		emp.setFname(employee.getFname());
		emp.setEmail(employee.getEmail());
		emp.setPassword(employee.getPassword());
		
		
		return employeeRepositroy.save(emp);
	}

	@Override
	public void deleteEmp(Employee emp) {
		
		employeeRepositroy.delete(emp);
		
	}

	

	
	}


	

	
	 
	
	
	
