/**
 * (c)Copyright 2015, WIN7X64. All rights reserved.
 */
package vn.tdt.mockproject.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vn.tdt.mockproject.entity.CustomerType;
import vn.tdt.mockproject.repository.ICustomerTypeRepository;
import vn.tdt.mockproject.repository.IOperations;
import vn.tdt.mockproject.service.AbstractService;
import vn.tdt.mockproject.service.ICustomerTyperService;

/**
 * CustomerTypeServiceImpl.java
 * @author WIN7X64
 * @since Aug 8, 2015
 */
@Service
@Transactional
public class CustomerTypeServiceImpl extends AbstractService<CustomerType> implements ICustomerTyperService {
	
	@Autowired
	private ICustomerTypeRepository dao;

	/* 
	 * @see vn.tdt.mockproject.service.AbstractService#getDao()
	 */
	@Override
	protected IOperations<CustomerType> getDao() {
		return dao;
	}
	
}
