/**
 * (c)Copyright 2015, PhatVT. All rights reserved.
 */
package vn.tdt.mockproject.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vn.tdt.mockproject.entity.Address;
import vn.tdt.mockproject.repository.IAddressRepository;
import vn.tdt.mockproject.repository.IOperations;
import vn.tdt.mockproject.service.AbstractService;
import vn.tdt.mockproject.service.IAddressService;

/**
 * AddressServiceImpl.java
 * @author PhatVT
 * @since Aug 11, 2015
 */
@Service
@Transactional
public class AddressServiceImpl extends AbstractService<Address> implements IAddressService {
	
	@Autowired
	private IAddressRepository dao;

	/* 
	 * @see vn.tdt.mockproject.service.AbstractService#getDao()
	 */
	@Override
	protected IOperations<Address> getDao() {
		return dao;
	}

}
