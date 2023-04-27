package com.sunit.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunit.entity.Employee;
import com.sunit.repository.EmpRepository;

@Service

public class EmpServiceImpl implements EmpService{
	
	@Autowired
	private EmpRepository empRepository;

	@Override
	public Employee createEmployee(Employee employee) {
		
		return empRepository.save(employee);
	}

	@Override
	public Employee getEmpById(Long empId) {
		Optional<Employee> findById = empRepository.findById(empId);
		return findById.get();
	}

	@Override
	public List<Employee> getAllEmployees() {
		
		return empRepository.findAll();
	}

	@Override
	public Employee updateEmp(Employee employee) {
		Employee empExist = empRepository.findById(employee.getId()).get();
		empExist.setFirstName(employee.getFirstName());
		empExist.setLastName(employee.getLastName());
		empExist.setEmail(employee.getEmail());
		empExist.setAge(employee.getAge());
		Employee updatedEmp = empRepository.save(empExist);
		return updatedEmp;
	}

	@Override
	public void deleteEmp(Long empId) {
	empRepository.deleteById(empId);
		
	}
	
}