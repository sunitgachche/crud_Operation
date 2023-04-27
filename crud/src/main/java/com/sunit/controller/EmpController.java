package com.sunit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sunit.entity.Employee;
import com.sunit.service.EmpService;

@RestController
public class EmpController {
	
	@Autowired
	private EmpService empService;
	
	@PostMapping("/emp/create")
	public ResponseEntity<Employee> createEmp(@RequestBody Employee employee){
		Employee savedEmployee = empService.createEmployee(employee);
		return new ResponseEntity<>(savedEmployee,HttpStatus.CREATED);
	
	}
	
	@GetMapping("/emp/{id}")
	public ResponseEntity<Employee> getEmpById(@PathVariable("id") Long empId){
		Employee empById = empService.getEmpById(empId);
		return new ResponseEntity<>(empById, HttpStatus.OK);
		
	}
	@GetMapping("/allemp")
	public ResponseEntity<List<Employee>> getAllEmp(){
		List<Employee> allEmployees = empService.getAllEmployees();
		return new ResponseEntity<>(allEmployees, HttpStatus.OK);
		
	}
	@PutMapping("/emp/{id}")
	public ResponseEntity<Employee> updateEmp(@PathVariable("id") Long empId, @RequestBody Employee employee ){
		
		employee.setId(empId);
		Employee updatedEmp = empService.updateEmp(employee);
		return new ResponseEntity<>(updatedEmp, HttpStatus.OK);
		
	}
	
	@DeleteMapping("/emp/{id}")
	public ResponseEntity<String> deleteEmp(@PathVariable("id") Long empId){
		empService.deleteEmp(empId);
		
		return new ResponseEntity<>("Employee deleted successfully..!" , HttpStatus.OK);
		
	}
	

}
