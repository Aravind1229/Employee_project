package com.rest.empdata.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Employee {
@Id
@GeneratedValue
private Integer id;
@Column(nullable=false)
private String firstName;
private String lastName;
private Integer age;
private Integer salary;
private String designation;

public Employee() {
	super();
}
public Employee(String firstName, String lastName, Integer age, Integer salary, String designation) {
	super();
	this.firstName = firstName;
	this.lastName = lastName;
	this.age = age;
	this.salary = salary;
	this.designation = designation;
}
public String getFirstName() {
	return firstName;
}
public void setFirstName(String firstName) {
	this.firstName = firstName;
}
public String getLastName() {
	return lastName;
}
public void setLastName(String lastName) {
	this.lastName = lastName;
}
public Integer getAge() {
	return age;
}
public void setAge(Integer age) {
	this.age = age;
}
public Integer getSalary() {
	return salary;
}
public void setSalary(Integer salary) {
	this.salary = salary;
}
public String getDesignation() {
	return designation;
}
public void setDesignation(String designation) {
	this.designation = designation;
}
public Integer getId() {
	return id;
}
@Override
public String toString() {
	return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", age=" + age
			+ ", designation=" + designation + ", salary=" + salary + "]";
}
}
