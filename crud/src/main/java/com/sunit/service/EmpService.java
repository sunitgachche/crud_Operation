package com.sunit.service;

import java.util.List;

import com.sunit.entity.Employee;

public interface EmpService {
	
	Employee createEmployee(Employee employee);

    Employee getEmpById(Long empId);

    List<Employee> getAllEmployees();

    Employee updateEmp(Employee employee);

    void deleteEmp(Long empId);

	

}
