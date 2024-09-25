package org.jsp.cda.repository;

import org.jsp.cda.entity.FacultyProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.multipart.MultipartFile;

public interface FacultyProfileRepository extends JpaRepository<FacultyProfile, Long> {

}
