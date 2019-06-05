package com.lfsinternship.service.impl;

import java.util.List;

import com.lfsinternship.model.Address;
import com.lfsinternship.repository.AddressRepository;
import com.lfsinternship.repository.impl.AddressRepositoryImpl;
import com.lfsinternship.service.AddressService;

public class AddressServiceImpl implements AddressService{

	private AddressRepository addressRepository = new  AddressRepositoryImpl();

	@Override
	public Address saveAddress(Address address) {

		Address tempAddress = this.addressRepository.saveAddress(address);
		
		return tempAddress;
	}

	@Override
	public Address updateAddress(Address address) {

		Address tempAddress = this.addressRepository.updateAddress(address);
		
		return tempAddress;
	}

	@Override
	public Address removeAddress(Address address) {

		Address tempAddress = this.addressRepository.removeAddress(address);
		
		return tempAddress;
	}

	@Override
	public Address findById(Integer id) {

		Address tempAddress = this.addressRepository.findById(id);
		
		return tempAddress;
	}

	@Override
	public List<Address> findByUserId(Integer id) {

		List<Address> tempAddresses = this.addressRepository.findByUserId(id);
		
		return tempAddresses;
	}

	@Override
	public Address findWithInternshipById(Integer id) {

		Address tempAddress = this.addressRepository.findWithInternshipById(id);
		
		return tempAddress;
	}

	@Override
	public Address findWithUserDetailById(Integer id) {

		Address tempAddress = this.addressRepository.findWithUserDetailById(id);
		
		return tempAddress;
	}

	@Override
	public Address findByIntershipId(Integer id) {

		Address tempAddress = this.addressRepository.findByIntershipId(id);
		
		return tempAddress;
	}
	
	
	
}
