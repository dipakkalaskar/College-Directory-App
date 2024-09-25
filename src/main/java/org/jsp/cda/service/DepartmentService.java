package org.jsp.cda.service;

import org.jsp.cda.entity.Department;
import org.springframework.http.ResponseEntity;

public interface DepartmentService {

	ResponseEntity<?> saveDepartment(Department department);
}
