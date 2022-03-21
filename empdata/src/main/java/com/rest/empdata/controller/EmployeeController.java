package com.rest.empdata.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.rest.empdata.entity.Employee;
import com.rest.empdata.repository.EmployeeRepository;
@Controller
@ComponentScan(value="com.rest.empdata")
public class EmployeeController {
@Autowired
EmployeeRepository repository;
@GetMapping("/")
public String home() {
	return "home";
}
@GetMapping("/user/loginuser")
public String loginuser() {
	return "loginUser";
}
@GetMapping("/login")
public String login() {
	return "login";
}
@GetMapping(value="/admin/create")
public String create() {
	return "createEmployee";
}
@RequestMapping(value="/search")
public String search() {
	return "search";
}
@RequestMapping(value="/admin/update")
public String update() {
	return "updateEmployee";
}
@RequestMapping(value="/admin/delete")
public String delete() {
	return "deleteEmployee";
}
@RequestMapping(value="/admin/salaryupdate")
public String salaryUpdate() {
	return "updateSalary";
}
@RequestMapping(value="/admin/ageupdate")
public String ageUpdate() {
	return "updateAge";
}
@RequestMapping(value="/admin/designationupdate")
public String designationUpdate() {
	return "updateDesignation";
}
@RequestMapping(value="/admin/firstnameupdate")
public String firstnameUpdate() {
	return "updateFirstName";
}
@RequestMapping(value="/admin/lastnameupdate")
public String lastnameUpdate() {
	return "updateLastName";
}
@RequestMapping(path= "/admin/details")
public String getAllEmployees(Model model) 
{		
	List<Employee> list =repository.getAllEmployees();

	model.addAttribute("employees", list);
	
	return "list";
}
@RequestMapping(value="/admin/createemployee",method = RequestMethod.POST)
public String createEmployee(@RequestParam String firstname,@RequestParam String lastname,
		@RequestParam Integer age,@RequestParam Integer salary,
		@RequestParam String designation,@RequestParam String password,ModelMap model) {
	
	String passwordstatus="dummy";
	repository.insertEmployee(firstname,lastname,age,salary,designation,password,passwordstatus);
	model.put("message","Employee is Added");
	return "createEmployee";
}
@RequestMapping(value="/searchemployee")
public String searchEmployee(@RequestParam Integer id,ModelMap model) {
	Employee employee = repository.findById(id);
	if(employee==null) {
		model.put("message","Employee not found");
		return "search";
	}
	else {
	model.put("id",employee.getId());
	model.put("firstname", employee.getFirstName());
	model.put("lastname", employee.getLastName());
	model.put("age", employee.getAge());
	model.put("salary", employee.getSalary());
	model.put("designation",employee.getDesignation());
	return "details";
	}
	
}
@RequestMapping(value="/admin/updatesalary")
public String updateSalary(@RequestParam Integer id,@RequestParam Integer salary,ModelMap model) {
	Employee employee = repository.findById(id);
	if(employee==null) {
		model.put("message1","Employee not found");
		return "updateSalary";
	}
	else {
	repository.updateSalary(id,salary);
	model.put("message","Employee salary is updated");
	return "updateSalary";
	}
}
@RequestMapping(value="/admin/updateage")
public String updateAge(@RequestParam Integer id,@RequestParam Integer age,ModelMap model) {
	Employee employee = repository.findById(id);
	if(employee==null) {
		model.put("message1","Employee not found");
		return "updateAge";
	}
	else {
	repository.updateAge(id, age);
	model.put("message","Employee Age is updated");
	return "updateAge";
	}
}
@RequestMapping(value="/admin/updatedesignation")
public String updateDesignation(@RequestParam Integer id,@RequestParam String designation,ModelMap model) {
	Employee employee = repository.findById(id);
	if(employee==null) {
		model.put("message1","Employee not found");
		return "updateDesignation";
	}
	else {
	repository.updateDesignation(id, designation);
	model.put("message","Employee Designation is updated");
	return "updateDesignation";
	}
}
@RequestMapping(value="/admin/updatefirstname")
public String updateFirstName(@RequestParam Integer id,@RequestParam String firstname,ModelMap model) {
	Employee employee = repository.findById(id);
	if(employee==null) {
		model.put("message1","Employee not found");
		return "updateFirstName";
	}
	else {
	repository.updateFirstName(id, firstname);
	model.put("message","Employee First Name is updated");
	return "updateFirstName";
	}
}
@RequestMapping(value="/admin/updatelastname")
public String updateLastName(@RequestParam Integer id,@RequestParam String lastname,ModelMap model) {
	Employee employee = repository.findById(id);
	if(employee==null) {
		model.put("message1","Employee not found");
		return "updateLastName";
	}
	else {
	repository.updateLastName(id, lastname);
	model.put("message","Employee Last Name is updated");
	return "updateLastName";
	}
}
@RequestMapping(value="/admin/deleteemployee")
public String deleteEmployee(@RequestParam Integer id,ModelMap model) {
	Employee employee = repository.findById(id);
	if(employee==null) {
		model.put("message1","Employee not found");
		return "deleteEmployee";
	}
	else {
	repository.deleteById(id);
	model.put("message","Employee is deleted");
	return "deleteEmployee";
	}
}
@GetMapping("/admin")
public String adminHome() {
	return "adminHome";
}
@RequestMapping(value="/user",method=RequestMethod.POST)
public String userLogin(@RequestParam Integer id,@RequestParam String password,ModelMap model) {
	Employee employee = repository.findById(id);
	if(employee==null) {
		model.put("errormessage","Employee Not Found");
		return "loginuser";
	}
	else if(employee.getPasswordStatus().equals("dummy")) {
		return "changePassword";
	}
	else if(!((id==(employee.getId()))&&((password.equals(employee.getPassword()))))) {
		model.put("errormessage","Invalid Credentials");
		return "loginuser";
	}
		else {
		model.put("id",employee.getId());
		model.put("firstname", employee.getFirstName());
		model.put("lastname", employee.getLastName());
		model.put("age", employee.getAge());
		model.put("salary", employee.getSalary());
		model.put("designation",employee.getDesignation());
		return "details2";
	}
}
@RequestMapping(value="/user/change",method=RequestMethod.POST)
public String changeUserPassword(@RequestParam Integer id,@RequestParam String oldpassword,@RequestParam String newpassword,ModelMap model) {
	Employee employee = repository.findById(id);
	if(!((id==(employee.getId()))&&((oldpassword.equals(employee.getPassword()))))) {
		model.put("message1","Invalid Credentials");
		return "changePassword";
	}
	else {
		repository.changePassword(id, newpassword);
		model.put("message","Password Changed");
		return "changePassword";
	}
}
}
