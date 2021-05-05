package com.example.demo.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.EmployeeRepository;
import com.example.demo.controller.custom.exception.BusinessException;
import com.example.demo.entity.Employee;

@Service
public class EmployeeService implements EmployeeServiceInterface {
	
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Employee addEmployee(Employee employee) {
		
		if(employee.getName().isEmpty() || employee.getName().length() == 0) {
			throw new BusinessException("601","Please send proper name, its blank");
		}
		try {
			Employee savedEmployee = employeeRepository.save(employee);
			return savedEmployee;
		} catch(IllegalArgumentException e) {
			throw new BusinessException("602","Given employee entity is null " + e.getMessage());
		} catch(Exception e) {
			throw new BusinessException("603", "Something went wrong in the Service layer while saving employee " + e.getMessage());
		}
	}

	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> empList = null;
		try {
			empList = employeeRepository.findAll();
		} catch(Exception e) {
			throw new BusinessException("605", "Something went wrong in the Service layer while fetching employee list " + e.getMessage());
		}
		if(empList.isEmpty()) {
			throw new BusinessException("604", "List is empty");
		}
		return empList;
	}

	@Override
	public Employee getEmpById(Long empidL) {
		try {
			return employeeRepository.findById(empidL).get();
		} catch(IllegalArgumentException e) {
			throw new BusinessException("606","Given employee id is null, please send some id to be searched " + e.getMessage());
		} catch(NoSuchElementException e) {
			throw new BusinessException("607","Given employee id does not exist in DB " + e.getMessage());
		}
			
		
	}

	@Override
	public void deleteEmpById(Long empidL) {
		try {
			employeeRepository.deleteById(empidL);		
		} catch(IllegalArgumentException e) {
			throw new BusinessException("608","Given employee id is null, please send some id to be searched " + e.getMessage());
		}
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		Employee updatedEmployee = employeeRepository.save(employee);
		return updatedEmployee;
	}
	
	
	
	
	
}
