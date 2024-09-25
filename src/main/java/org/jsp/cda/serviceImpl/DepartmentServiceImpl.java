package org.jsp.cda.serviceImpl;

import org.jsp.cda.dao.DepartmentDao;
import org.jsp.cda.entity.Department;
import org.jsp.cda.responsestructure.ResponseStructure;
import org.jsp.cda.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImpl implements DepartmentService {
	
	@Autowired
	private DepartmentDao dao;

	@Override
	public ResponseEntity<?> saveDepartment(Department department) {
		Department dbDepartment = dao.saveDepartment(department);
		
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value()).message("Department Saved Successfully").body(dbDepartment).build());
	}
}
