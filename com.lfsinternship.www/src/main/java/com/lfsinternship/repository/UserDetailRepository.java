package com.lfsinternship.repository;

import com.lfsinternship.model.UserDetail;
import com.lfsinternship.model.UserInfo;

public interface UserDetailRepository {

	UserDetail saveUserDetail(UserDetail userDetail);
	
	UserDetail updateUserDetail(UserDetail userDetail);
	
	UserDetail removeUserDetail(UserDetail userDetail);
	
	UserDetail findById(Integer id);
	
	UserDetail findByUserName(String name);
	
	UserDetail findWithAddressByUserName(String name);
	
	UserDetail findWithInternshipsByUserName(String name);
	
	UserDetail findWithUniversityByUserName(String name);
	
	UserDetail findWithLocationByUserName(String name);
	
	UserInfo findUserInfoByCompanyId(Integer id);
	
	UserInfo findUserInfoByStudentId(Integer id);
}
