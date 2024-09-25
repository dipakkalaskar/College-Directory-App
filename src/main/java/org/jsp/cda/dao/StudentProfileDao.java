package org.jsp.cda.dao;

import java.util.List;
import java.util.Optional;

import org.jsp.cda.entity.Profile;
import org.jsp.cda.entity.StudentProfile;
import org.jsp.cda.entity.User;

public interface StudentProfileDao {

	Optional<User> getUserById(long id);

	Profile saveProfile(Profile p);

	void updateStudentProfile(StudentProfile studentProfile);

   StudentProfile saveProfile(StudentProfile studentProfile);

   List<StudentProfile> findAllStudents();

}
