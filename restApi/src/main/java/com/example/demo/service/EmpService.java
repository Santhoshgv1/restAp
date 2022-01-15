package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Employee;
import com.example.demo.repo.JpaRepo;

@Service
public class EmpService {

	@Autowired
	JpaRepo repo;

	public Employee save(Employee emp) {
		Employee em = repo.save(emp);
		return em;
	}

	public List<Employee> getAllEmp() {
		List<Employee> emp = repo.findAll();
		return emp;
	}

	public String deleteEmployee(int id) {
		repo.deleteById(id);
		return "employee deleted" + id;
	}

	public Employee updateEmp(Employee emp) {
		repo.save(emp);
		return emp;
	}

	public List<Employee> getByName(String name) {
		List<Employee> emp = repo.findByName(name);
		return emp;
	}

	public List<Employee> getByDesig(String deisgnation) {
		List<Employee> emp = repo.findByDesignation(deisgnation);
		return emp;
	}
	
}
