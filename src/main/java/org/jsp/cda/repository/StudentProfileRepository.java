package org.jsp.cda.repository;

import org.jsp.cda.entity.Profile;
import org.jsp.cda.entity.StudentProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentProfileRepository extends JpaRepository<StudentProfile, Long>{

	Profile save(Profile p);

}
