package com.rest.empdata.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rest.empdata.entity.Employee;

@Repository
public interface EmployeeRepository2 extends CrudRepository<Employee,Integer> {

	}

