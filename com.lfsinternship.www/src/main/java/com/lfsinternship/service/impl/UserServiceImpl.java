package com.lfsinternship.service.impl;

import java.util.List;

import com.lfsinternship.model.User;
import com.lfsinternship.model.UserInfo;
import com.lfsinternship.repository.UserRepository;
import com.lfsinternship.repository.impl.UserRepositoryImpl;
import com.lfsinternship.service.UserService;

public class UserServiceImpl implements UserService{
	
	private UserRepository userRepository = new UserRepositoryImpl();

	@Override
	public User saveUser(User user) {

		User tempUser = this.userRepository.saveUser(user);
		
		return tempUser;
	}

	@Override
	public User updateUser(User user) {

		User tempUser = this.userRepository.updateUser(user);
		
		return tempUser;
	}

	@Override
	public User removeUser(User user) {

		User tempUser = this.userRepository.removeUser(user);
		
		return tempUser;
	}

	@Override
	public User findById(Integer id) {

		User tempUser = this.userRepository.findById(id);
		
		return tempUser;
	}

	@Override
	public User findByUserName(String name) {

		User tempUser = this.userRepository.findByUserName(name);
		
		return tempUser;
	}

	@Override
	public User findWithUserDetailsByUserName(String name) {

		User tempUser = this.userRepository.findWithUserDetailsByUserName(name);
		
		return tempUser;
	}

	@Override
	public int findUsersCount() {

		int countUser = this.userRepository.findUsersCount();
		
		return countUser;
	}

	@Override
	public List<User> findAllUsers() {

		List<User> tempUsers = this.userRepository.findAllUsers();
		
		return tempUsers;
	}

	@Override
	public UserInfo findUserInfoByUserName(String name) {

		UserInfo tempUserInfo = this.userRepository.findUserInfoByUserName(name);
		
		return tempUserInfo;
	}
	

}
