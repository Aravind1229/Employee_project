package com.rest.empdata.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rest.empdata.entity.Employee;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class EmployeeRepository {
@Autowired
EntityManager em;
public Employee insertEmployee(String firstName,String lastName,Integer age,Integer salary,String designation) {
	Employee employee=new Employee(firstName,lastName,age,salary,designation);
	em.persist(employee);
	return employee;
}
public Employee findById(Integer id) {
	Employee employee = em.find(Employee.class,id);
	return employee;
}
public void deleteById(Integer id) {
	Employee employee=findById(id);
	em.remove(employee);
}
public void updateEmployee(Integer id,Integer salary) {
	Employee employee =findById(id);
	employee.setSalary(salary);
	em.merge(employee);
}
}
