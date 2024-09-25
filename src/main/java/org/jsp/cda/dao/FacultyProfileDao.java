package org.jsp.cda.dao;

import java.util.List;

import org.jsp.cda.entity.FacultyProfile;
import org.springframework.web.multipart.MultipartFile;

public interface FacultyProfileDao {

	FacultyProfile saveFacultyProfile(FacultyProfile facultyProfile);

	List<FacultyProfile> findAllFaculties();

}
