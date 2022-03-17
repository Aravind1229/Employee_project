package com.rest.empdata.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rest.empdata.entity.Employee;
import com.rest.empdata.repository.EmployeeRepository;
@Controller
@ComponentScan(value="com.rest.empdata")
public class EmployeeController {
@Autowired
EmployeeRepository repository;
@GetMapping("/")
public String login() {
	return "login.html";
}
@GetMapping(value="/create")
public String create() {
	return "createEmployee.jsp";
}
@RequestMapping(value="/search")
public String display() {
	return "search.jsp";
}
@RequestMapping(value="/createemployee",method = RequestMethod.POST)
public String createEmployee(@RequestParam String firstname,@RequestParam String lastname,@RequestParam Integer age,@RequestParam String designation,@RequestParam Integer salary,ModelMap model) {
	repository.insertEmployee(firstname,lastname,age,designation,salary);
	model.put("message","User is inserted");
	return "createEmployee.jsp";
}
@RequestMapping(value="/searchemployee")
public String findEmployee(@RequestParam Integer id,ModelMap model) {
	Employee employee = repository.findById(id);
	if(employee==null) {
		model.put("message","User not found");
		return "search.jsp";
	}
	else {
	model.put("id",employee.getId());
	model.put("firstname", employee.getFirstName());
	model.put("lastname", employee.getLastName());
	model.put("age", employee.getSalary());
	model.put("salary", employee.getAge());
	model.put("designation",employee.getDesignation());
	return "details.jsp";
	}
	
}
}
