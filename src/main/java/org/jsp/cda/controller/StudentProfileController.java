package org.jsp.cda.controller;

import org.jsp.cda.service.StudentProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/studentprofiles")
public class StudentProfileController {
	
	@Autowired
	private StudentProfileService service;
	
	@Operation(summary = "To create a StudentProfile", description = "This API will accept the RequestBody of StudentProfile entity and persist to the database table")
	@ApiResponses({@ApiResponse(responseCode = "200", description = "StudentProfile Saved Successfully"), @ApiResponse(responseCode = "400", description = "Unable to save StudentProfile")})
	@PostMapping
	public ResponseEntity<?> saveStudentProfile(@RequestParam(name = "id") long id, @RequestParam(name="file") MultipartFile file)
	{
		return service.saveStudentProfile(id, file);
	}
}
