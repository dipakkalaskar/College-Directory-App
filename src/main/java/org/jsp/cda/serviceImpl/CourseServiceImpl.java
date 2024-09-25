package org.jsp.cda.serviceImpl;

import org.jsp.cda.dao.CourseDao;
import org.jsp.cda.entity.Course;
import org.jsp.cda.responsestructure.ResponseStructure;
import org.jsp.cda.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CourseServiceImpl implements CourseService {
	
	@Autowired
	private CourseDao dao;

	@Override
	public ResponseEntity<?> saveCourse(Course course) {
		Course dbCourse = dao.saveCourse(course);
		
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value()).message("Course Saved Successfully").body(dbCourse).build());
	}
}
