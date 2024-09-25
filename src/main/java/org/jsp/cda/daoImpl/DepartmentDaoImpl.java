package org.jsp.cda.daoImpl;

import org.jsp.cda.dao.DepartmentDao;
import org.jsp.cda.entity.Department;
import org.jsp.cda.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DepartmentDaoImpl implements DepartmentDao {
	
	@Autowired
	private DepartmentRepository repository;

	@Override
	public Department saveDepartment(Department department) {
		return repository.save(department);
	}
}
