package org.jsp.cda.controller;

import org.jsp.cda.entity.Course;
import org.jsp.cda.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/courses")
public class CourseController {
	
	@Autowired
	private CourseService service;
	
	@Operation(summary = "To create a Course", description = "This API will accept the RequestBody of Course entity and persist to the database table")
	@ApiResponses({@ApiResponse(responseCode = "200", description = "Course Saved Successfully"), @ApiResponse(responseCode = "400", description = "Unable to save Course")})
	@PostMapping
	public ResponseEntity<?> saveCourse(@RequestBody Course course)
	{
		return service.saveCourse(course);
	}
}
