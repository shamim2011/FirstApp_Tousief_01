package com.mycomp.firstApp.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@GetMapping
	public String getEmployee() {
		return "get Employee data";
	}
	@PostMapping
	public String createEmployee(@RequestBody String reqBody) {
		// Create employee and return id
		return "create Employee data";
	}
	@GetMapping("/id")
	public String getEmployeeById(@PathVariable String id) {
		// read id, get employee from db and return
		return "return Employee data from db";
	}
	@PutMapping("/id")
	public String updateEmployeeById(@PathVariable String id,@RequestBody String reqBody) {
		// read id, get employee from db and update it
		return "update Employee data from db";
	}
	@PatchMapping("/id")
	public String patchUpdateEmployeeById(@PathVariable String id,@RequestBody String reqBody) {
		// read id, get employee from db and update it
		return "Partially update Employee data from db";
	}
	@DeleteMapping("/id")
	public String deleteEmployeeById(@PathVariable String id) {
		// read id, get employee from db and return
		return "delete Employee data from db";
	}
	@PostMapping("/{id}/takeLeave")
	public String takeLeave(@PathVariable String id,@RequestBody String reqBody) {
		// Create employee and return id
		return "Employee take Leave";
	}
}
