package org.jsp.cda.daoImpl;

import java.util.List;
import java.util.Optional;

import org.jsp.cda.dao.StudentProfileDao;
import org.jsp.cda.entity.Profile;
import org.jsp.cda.entity.StudentProfile;
import org.jsp.cda.entity.User;
import org.jsp.cda.repository.StudentProfileRepository;
import org.jsp.cda.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class StudentProfileDaoImpl implements StudentProfileDao {
	
	@Autowired
	private StudentProfileRepository repository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public Optional<User> getUserById(long id) {
		return userRepository.findById(id);
	}

	@Override
	public Profile saveProfile(Profile p) {
		return repository.save(p);
	}

	@Override
	public void updateStudentProfile(StudentProfile studentProfile) {
		
		repository.save(studentProfile);	
	}

	@Override
	public StudentProfile saveProfile(StudentProfile studentProfile) {
		
		return repository.save(studentProfile);
		
	}

	@Override
	public List<StudentProfile> findAllStudents() {
		return repository.findAll();
	}
}
