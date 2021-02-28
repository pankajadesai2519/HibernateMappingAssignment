package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;


@RestController
@RequestMapping("/employees")
public class EmployeeController {

@Autowired
	private EmployeeService service;

/*Note: Please insert data manually in the databases*/

/*This get request retrieve list of employees*/
@GetMapping(path="/",produces="application/json")
	public ResponseEntity<List<Employee>> getAllEmployees(){
		List<Employee> list=service.getAllEmployees();
		return new ResponseEntity<List<Employee>>(list,HttpStatus.OK);	
	}

/*This get request retrieve list of employees based on ascending order of salary*/
@GetMapping(path="/orderBy/",produces="application/json")
public ResponseEntity<List<Employee>> getEmployeeOrderBySalary(){
	List<Employee> list=service.getEmployeeOrderBySalary();
	return new ResponseEntity<List<Employee>>(list,HttpStatus.OK);	
}

/*This get request retrieve employee by id*/
@GetMapping(path="/{id}",produces="application/json")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") int id){
		Employee entity=service.getEmployeeById(id);
		return new ResponseEntity<Employee>(entity,HttpStatus.OK);
	}
	
/*This delete request remove employee by id*/
	@DeleteMapping(path="/{id}")
	public HttpStatus deleteEmployeeById(@PathVariable("id") int id){
		service.deleteStudentById(id);
		return HttpStatus.FORBIDDEN;
	}
}
