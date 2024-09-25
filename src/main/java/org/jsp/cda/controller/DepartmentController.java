package org.jsp.cda.controller;

import org.jsp.cda.entity.Department;
import org.jsp.cda.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
	
	@Autowired
	private DepartmentService service;
	
	@Operation(summary = "To create a Department", description = "This API will accept the RequestBody of Department entity and persist to the database table")
	@ApiResponses({@ApiResponse(responseCode = "200", description = "Department Saved Successfully"), @ApiResponse(responseCode = "400", description = "Unable to save Department")})
	@PostMapping
	public ResponseEntity<?> saveDepartment(@RequestBody Department department)
	{
		return service.saveDepartment(department);
	}
	
//	@GetMapping("/id/{id}")
//	public ResponseEntity<?> fetchDepartmentById(@PathVariable Long id)
//	{
//		return service.fetchDepartmentById(id);
//	}
}
