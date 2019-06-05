package com.lfsinternship.service.impl;

import java.util.List;

import com.lfsinternship.model.intern.Student;
import com.lfsinternship.repository.StudentRepository;
import com.lfsinternship.repository.impl.StudentRepositoryImpl;
import com.lfsinternship.service.StudentService;

public class StudentServiceImpl implements StudentService{

	private StudentRepository studentRepository = new StudentRepositoryImpl();

	@Override
	public Student saveStudent(Student student) {

		Student tempStudent = this.studentRepository.saveStudent(student);
		
		return tempStudent;
	}

	@Override
	public Student updateStudent(Student student) {

		Student tempStudent = this.studentRepository.updateStudent(student);
		
		return tempStudent;
	}

	@Override
	public Student removeStudent(Student student) {

		Student tempStudent = this.studentRepository.removeStudent(student);
		
		return tempStudent;
	}

	@Override
	public Student findById(Integer id) {

		Student tempStudent = this.studentRepository.findById(id);
		
		return tempStudent;
	}

	@Override
	public Student findByCvId(Integer id) {

		Student tempStudent = this.studentRepository.findByCvId(id);
		
		return tempStudent;
	}

	@Override
	public List<Student> findUniversityId(Integer id) {

		List<Student> tempStudents = this.studentRepository.findUniversityId(id);
		
		return tempStudents;
	}

	@Override
	public List<String> findStudentsNameWithExperienceName(String name) {

		List<String> tempStudents = this.studentRepository.findStudentsNameWithExperienceName(name);
		
		return tempStudents;
	}

	@Override
	public List<String> findStudentsNameWithExperienceNameByStudentId(Integer id) {

		List<String> tempStudents = this.studentRepository.findStudentsNameWithExperienceNameByStudentId(id);
		
		return tempStudents;
	}
	
	
}
