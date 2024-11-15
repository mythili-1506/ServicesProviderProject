package com.cloute.employeemaster.emprepository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cloute.employeemaster.empentity.Employee;

@Repository
public interface EmpRepository extends JpaRepository<Employee, Long>{

	Optional<Employee> findByEmployeeId(long employeeId);

	List<Employee> findByEmpStatus(int i);

}
