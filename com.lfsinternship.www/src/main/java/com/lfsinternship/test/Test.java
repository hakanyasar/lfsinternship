package com.lfsinternship.test;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.lfsinternship.model.Address;
import com.lfsinternship.model.Internship;
import com.lfsinternship.model.Location;
import com.lfsinternship.model.User;
import com.lfsinternship.model.UserDetail;
import com.lfsinternship.model.employer.Company;
import com.lfsinternship.model.employer.DepartmentOfCompany;
import com.lfsinternship.model.employer.Employee;
import com.lfsinternship.model.employer.Job;
import com.lfsinternship.model.intern.Cv;
import com.lfsinternship.model.intern.Experience;
import com.lfsinternship.model.intern.Position;
import com.lfsinternship.model.intern.Student;
import com.lfsinternship.model.intern.University;
import com.lfsinternship.repository.AddressRepository;
import com.lfsinternship.repository.CompanyRepository;
import com.lfsinternship.repository.CvRepository;
import com.lfsinternship.repository.DepartmentOfCompanyRepository;
import com.lfsinternship.repository.EmployeeRepository;
import com.lfsinternship.repository.ExperienceRepository;
import com.lfsinternship.repository.InternshipRepository;
import com.lfsinternship.repository.JobRepository;
import com.lfsinternship.repository.LocationRepository;
import com.lfsinternship.repository.PositionRepository;
import com.lfsinternship.repository.StudentRepository;
import com.lfsinternship.repository.UniversityRepository;
import com.lfsinternship.repository.UserDetailRepository;
import com.lfsinternship.repository.UserRepository;
import com.lfsinternship.repository.impl.AddressRepositoryImpl;
import com.lfsinternship.repository.impl.CompanyRepositoryImpl;
import com.lfsinternship.repository.impl.CvRepositoryImpl;
import com.lfsinternship.repository.impl.DepartmentOfCompanyRepositoryImpl;
import com.lfsinternship.repository.impl.EmployeeRepositoryImpl;
import com.lfsinternship.repository.impl.ExperienceRepositoryImpl;
import com.lfsinternship.repository.impl.InternshipRepositoryImpl;
import com.lfsinternship.repository.impl.JobRepositoryImpl;
import com.lfsinternship.repository.impl.LocationRepositoryImpl;
import com.lfsinternship.repository.impl.PositionRepositoryImpl;
import com.lfsinternship.repository.impl.StudentRepositoryImpl;
import com.lfsinternship.repository.impl.UniversityRepositoryImpl;
import com.lfsinternship.repository.impl.UserDetailRepositoryImpl;
import com.lfsinternship.repository.impl.UserRepositoryImpl;

public class Test {

	private static UserRepository userRepository = new UserRepositoryImpl();
	
	public static void main(String[] args) {
	
		insertData();
		
	}
	
	public static void insertData() {
		
		User user = new User("thomasShelby", "1234", new Date());
		User user1 = userRepository.saveUser(user);
		
		// test package has not finished yet I am gonna continue to this...
	}
	
	public static Date createDate(int day, int month, int year) {
		
		Calendar calendar = Calendar.getInstance();
		
		calendar.set(Calendar.DAY_OF_MONTH, day);
		calendar.set(Calendar.MONTH, month);
		calendar.set(Calendar.YEAR, year);
		
		return calendar.getTime();
		
	}
	
}
