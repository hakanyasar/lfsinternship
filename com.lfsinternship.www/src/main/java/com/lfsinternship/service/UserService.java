package com.lfsinternship.service;

import java.util.List;

import com.lfsinternship.model.User;
import com.lfsinternship.model.UserInfo;

public interface UserService {

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
