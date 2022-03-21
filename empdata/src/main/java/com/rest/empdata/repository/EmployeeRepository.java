package com.rest.empdata.repository;

import java.util.ArrayList;
import java.util.List;

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
@Autowired
EmployeeRepository2 repository;
public Employee insertEmployee(String firstName,String lastName,Integer age,Integer salary,String designation,String password,String passwordStatus) {
	Employee employee=new Employee(firstName,lastName,age,salary,designation, password, passwordStatus);
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
public void updateSalary (Integer id,Integer salary) {
	Employee employee =findById(id);
	employee.setSalary(salary);
	em.merge(employee);
}
public void updateAge (Integer id,Integer age) {
	Employee employee =findById(id);
	employee.setAge(age);
	em.merge(employee);
}
public void updateDesignation (Integer id,String Designation) {
	Employee employee =findById(id);
	employee.setDesignation(Designation);
	em.merge(employee);
}
public void updateFirstName (Integer id,String firstname) {
	Employee employee =findById(id);
	employee.setFirstName(firstname);
	em.merge(employee);
}
public void updateLastName (Integer id,String lastname) {
	Employee employee =findById(id);
	employee.setLastName(lastname);
	em.merge(employee);
}
public List<Employee> getAllEmployees()
{
	List<Employee> result = (List<Employee>) repository.findAll();
	if(result.size() > 0) {
		return result;
	} else {
		return new ArrayList<Employee>();
	}
}
public void changePassword(Integer id,String Password) {
	Employee employee = findById(id);
	employee.setPassword(Password);
	employee.setPasswordStatus("original");
	em.merge(employee);
}
}
