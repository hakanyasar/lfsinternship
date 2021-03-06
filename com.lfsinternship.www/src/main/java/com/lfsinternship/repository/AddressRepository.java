package com.lfsinternship.repository;

import java.util.List;

import com.lfsinternship.model.Address;

public interface AddressRepository {

	Address saveAddress(Address address);
	
	Address updateAddress(Address address);
	
	Address removeAddress(Address address);
	
	Address findById(Integer id);
	
	List<Address> findByUserId(Integer id);
	
	Address findWithInternshipById(Integer id);
	
	Address findWithUserDetailById(Integer id);
	
	Address findByIntershipId(Integer id);
	
}
