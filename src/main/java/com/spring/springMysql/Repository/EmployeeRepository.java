package com.spring.springMysql.Repository;

import com.spring.springMysql.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository  extends JpaRepository<Employee,Integer> {
}
