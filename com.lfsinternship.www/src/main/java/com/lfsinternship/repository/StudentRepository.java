package com.lfsinternship.repository;

import java.util.List;

import com.lfsinternship.model.intern.Student;

public interface StudentRepository {

	Student saveStudent(Student student);
	
	Student updateStudent(Student student);
	
	Student removeStudent(Student student);
	
	Student findById(Integer id);
	
	Student findByCvId(Integer id);
	
	List<Student> findUniversityId(Integer id);
	
	List<String> findStudentsNameWithExperienceName(String name);
	
	List<String> findStudentsNameWithExperienceNameByStudentId(Integer id);
	
}
