package com.example.Company.companyApp.repository;

import com.example.Company.companyApp.model.Employee;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface EmployeeRepository extends CrudRepository<Employee,Long> {

}
