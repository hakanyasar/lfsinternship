package com.lfsinternship.service.impl;

import com.lfsinternship.model.UserDetail;
import com.lfsinternship.model.UserInfo;
import com.lfsinternship.repository.UserDetailRepository;
import com.lfsinternship.repository.impl.UserDetailRepositoryImpl;
import com.lfsinternship.service.UserDetailService;

public class UserDetailServiceImpl implements UserDetailService{

	private UserDetailRepository userDetailRepository = new UserDetailRepositoryImpl();

	@Override
	public UserDetail saveUserDetail(UserDetail userDetail) {

		UserDetail tempUserDetail = this.userDetailRepository.saveUserDetail(userDetail);
		
		return tempUserDetail;
	}

	@Override
	public UserDetail updateUserDetail(UserDetail userDetail) {

		UserDetail tempUserDetail = this.userDetailRepository.updateUserDetail(userDetail);
		
		return tempUserDetail;
	}

	@Override
	public UserDetail removeUserDetail(UserDetail userDetail) {

		UserDetail tempUserDetail = this.userDetailRepository.removeUserDetail(userDetail);
		
		return tempUserDetail;
	}

	@Override
	public UserDetail findById(Integer id) {

		UserDetail tempUserDetail = this.userDetailRepository.findById(id);
		
		return tempUserDetail;
	}

	@Override
	public UserDetail findByUserName(String name) {

		UserDetail tempUserDetail = this.userDetailRepository.findByUserName(name);
		
		return tempUserDetail;
	}

	@Override
	public UserDetail findWithAddressByUserName(String name) {

		UserDetail tempUserDetail = this.userDetailRepository.findWithAddressByUserName(name);
		
		return tempUserDetail;
	}

	@Override
	public UserDetail findWithInternshipsByUserName(String name) {

		UserDetail tempUserDetail = this.userDetailRepository.findWithInternshipsByUserName(name);
		
		return tempUserDetail;
	}

	@Override
	public UserDetail findWithUniversityByUserName(String name) {

		UserDetail tempUserDetail = this.userDetailRepository.findWithUniversityByUserName(name);
		
		return tempUserDetail;
	}

	@Override
	public UserDetail findWithLocationByUserName(String name) {

		UserDetail tempUserDetail = this.userDetailRepository.findWithLocationByUserName(name);
		
		return tempUserDetail;
	}

	@Override
	public UserInfo findUserInfoByCompanyId(Integer id) {

		UserInfo tempUserInfo = this.userDetailRepository.findUserInfoByCompanyId(id);
		
		return tempUserInfo;
	}

	@Override
	public UserInfo findUserInfoByStudentId(Integer id) {

		UserInfo tempUserInfo = this.userDetailRepository.findUserInfoByStudentId(id);
		
		return tempUserInfo;
	}
	
	
}
