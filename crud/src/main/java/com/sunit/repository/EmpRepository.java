package com.sunit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sunit.entity.Employee;
@Repository
public interface EmpRepository extends JpaRepository<Employee, Long> {

}
