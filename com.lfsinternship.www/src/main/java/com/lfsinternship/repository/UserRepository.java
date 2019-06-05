package com.lfsinternship.repository;

import java.util.List;

import com.lfsinternship.model.User;
import com.lfsinternship.model.UserInfo;

public interface UserRepository {

	User saveUser(User user);
	
	User updateUser(User user);
	
	User removeUser(User user);
	
	User findById(Integer id);
	
	User findByUserName(String name);
	
	User findWithUserDetailsByUserName(String name);
	
	int findUsersCount();
	
	List<User> findAllUsers();
	
	UserInfo findUserInfoByUserName(String name);
	
}
