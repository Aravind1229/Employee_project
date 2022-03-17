package com.rest.empdata.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.rest.empdata.entity.Employee;
import com.rest.empdata.repository.EmployeeRepository;
@Controller
@ComponentScan(value="com.rest.empdata")
public class EmployeeController {
@Autowired
EmployeeRepository repository;
@GetMapping("/")
public String hello() {
	return "login";
}
@GetMapping("/users")
public Employee retrieveEmployeeById() {
	return repository.findById(1);
}
}
