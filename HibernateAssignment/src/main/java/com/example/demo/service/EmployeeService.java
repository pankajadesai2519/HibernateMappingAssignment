package com.example.demo.service;

import java.util.ArrayList;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.EmployeeNotFoundException;
import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;

@Transactional
@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	public List<Employee> getAllEmployees(){
		List<Employee> employeeList=employeeRepository.findAll();
		
		if(employeeList.size()>0) 
		{
			return employeeList;
		}
		else 
		{
			return new ArrayList<Employee>();
		}
	}
	
	public Employee getEmployeeById(int id) throws EmployeeNotFoundException
	{
		Optional<Employee> employee=employeeRepository.findById(id);
		
		if(employee.isPresent())
		{
			return employee.get();
		}
		else 
		{
			throw new EmployeeNotFoundException("No student record exist for given id");
		}
	}
	public List<Employee> getEmployeeOrderBySalary()
	{
		List<Employee> employee=employeeRepository.findByOrderBySalaryAsc();
		return employee;
		
	}
	
	
	public void deleteStudentById(int id) throws EmployeeNotFoundException
	{
		Optional<Employee> employee=employeeRepository.findById(id);
		
		if(employee.isPresent()) 
		{
			employeeRepository.deleteById(id);
		}
		else 
		{
			throw new EmployeeNotFoundException("No student record exist for given id");
		}
	}
}
	
	                 
