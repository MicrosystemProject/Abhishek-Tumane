package code.microsystem.repositroy;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import code.microsystem.entity.Employee;

public interface EmployeeRepositroy  extends JpaRepository <Employee,Integer> {
	
	
	@Query("from Employee e where e.fname=:name")
	Optional<Employee> findByFname(String name);	

	
   
}
