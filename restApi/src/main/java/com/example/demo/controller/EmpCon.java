package com.example.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.Employee;
import com.example.demo.service.EmpService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class EmpCon {

	@Autowired
	EmpService service;

	@PostMapping(value = "employee/save",consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Employee> store(@RequestBody Employee emp) {
		Employee em = service.save(emp);
		return new ResponseEntity<Employee>(em, HttpStatus.OK);
	}

	//@GetMapping(value = "employee/getAll",produces = MediaType.APPLICATION_ATOM_XML_VALUE)
	@GetMapping(value = "employee/getAll",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Employee>> getAll() {
		List<Employee> emp = service.getAllEmp();
		return new ResponseEntity<List<Employee>>(emp, HttpStatus.OK);
	}

	@DeleteMapping(value = "employee/delete/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> deleteEmp(@PathVariable int id) {
		String string = service.deleteEmployee(id);
		return new ResponseEntity<String>(string, HttpStatus.OK);
	}

	@PutMapping(value = "employee/up",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Employee> empUp(@RequestBody Employee emp) {
		service.updateEmp(emp);
		return new ResponseEntity<Employee>(emp, HttpStatus.OK);
	}

	@GetMapping(value = "employee/{name}",produces =  MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Employee>> getByEmpName(@PathVariable String name) {
		List<Employee> emp = service.getByName(name);
		return new ResponseEntity<List<Employee>>(emp, HttpStatus.OK);
	}

	@GetMapping(value = "employee/designation/{designation}",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Employee>> getByEmpDesig(@PathVariable String designation) {
		List<Employee> emp = service.getByDesig(designation);
		System.out.println(emp);
		return new ResponseEntity<List<Employee>>(emp, HttpStatus.OK);
	}
}

// create -- post -- save
// reade -- get  -- retrive
// update -- put -- update
//delete  -- delete