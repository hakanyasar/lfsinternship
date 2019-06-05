package com.lfsinternship.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.RollbackException;
import javax.persistence.TypedQuery;

import com.lfsinternship.entityFactory.EntityFactory;
import com.lfsinternship.entityFactoryImpl.EntityFactoryImpl;
import com.lfsinternship.model.intern.Student;
import com.lfsinternship.repository.StudentRepository;

public class StudentRepositoryImpl implements StudentRepository{

	private EntityFactory entityFactory = new EntityFactoryImpl();
	
	private EntityManager entityManager = entityFactory.getEntityManager();
	
	private EntityTransaction transaction = entityFactory.getEntityTransaction();

	@Override
	public Student saveStudent(Student student) {

		try {
			
			this.transaction.begin();
			
			this.entityManager.persist(student);
			
			this.transaction.commit();
			
		} catch (RuntimeException e) {
			
			System.out.println("error: " + e);
			
			try {
				this.transaction.rollback();
				
			} catch (RollbackException e2) {
				System.out.println("error: " + e2);
			}
			
		}
		
		return student;
	}

	@Override
	public Student updateStudent(Student student) {

		try {
			
			this.transaction.begin();
			
			this.entityManager.merge(student);
			
			this.transaction.commit();
			
		} catch (RuntimeException e) {
			
			System.out.println("error: " + e);
			
			try {
				this.transaction.rollback();
				
			} catch (RollbackException e2) {
				System.out.println("error: " + e2);
			}
			
		}
		
		return student;
	}

	@Override
	public Student removeStudent(Student student) {

		try {
			
			if(this.entityManager.contains(student)) {
				this.entityManager.remove(student);
			}else {
				Student tempStudent = this.findById(student.getStudentId());
				this.entityManager.remove(tempStudent);
			}
			
		} catch (RuntimeException e) {
			
			System.out.println("error: " + e);
			
			try {
				this.transaction.rollback();
				
			} catch (RollbackException e2) {
				System.out.println("error: " + e2);
			}
		}
		
		return student;
	}

	@Override
	public Student findById(Integer id) {

		Student student = null;
		
		try {
			
			TypedQuery<Student> typedQuery = this.entityManager.createNamedQuery("Student.findById", Student.class);
			typedQuery.setParameter("studentId", id);
			
			student = typedQuery.getSingleResult();
			
		} catch (NoResultException e) {
			System.out.println("error: " + e);
		}
		
		return student;
	}

	@Override
	public Student findByCvId(Integer id) {

		Student student = null;
		
		try {
			
			TypedQuery<Student> typedQuery = this.entityManager.createNamedQuery("Student.findByCvId", Student.class);
			typedQuery.setParameter("cvId", id);
			
			student = typedQuery.getSingleResult();
			
		} catch (NoResultException e) {
			System.out.println("error: " + e);
		}
		
		return student;
	}

	@Override
	public List<Student> findUniversityId(Integer id) {

		List<Student> students = null;
		
		try {
			
			TypedQuery<Student> typedQuery = this.entityManager.createNamedQuery("Student.findUniversityId", Student.class);
			typedQuery.setParameter("universityId", id);
			
			students = typedQuery.getResultList();
			
		} catch (NoResultException e) {
			System.out.println("error: " + e);
		}
		
		return students;
	}

	@Override
	public List<String> findStudentsNameWithExperienceName(String name) {

		List<String> students = null;
		
		try {
			
			TypedQuery<String> typedQuery = this.entityManager.createNamedQuery("Student.findStudentsNameWithExperienceName", String.class);
			
			students = typedQuery.getResultList();
			
		} catch (NoResultException e) {
			System.out.println("error: " + e);
		}
		
		return students;
	}

	@Override
	public List<String> findStudentsNameWithExperienceNameByStudentId(Integer id) {

		List<String> students = null;
		
		try {
			
			TypedQuery<String> typedQuery = this.entityManager.createNamedQuery("Student.findStudentsNameWithExperienceNameByStudentId", String.class);
			typedQuery.setParameter("studentId", id);
			
			students = typedQuery.getResultList();
			
		} catch (NoResultException e) {
			System.out.println("error: " + e);
		}
		
		return students;
	}
	
	
}
