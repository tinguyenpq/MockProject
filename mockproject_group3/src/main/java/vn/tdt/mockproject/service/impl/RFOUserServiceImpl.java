/**
 * (c)Copyright 2015, ThanhTien. All rights reserved.
 */
package vn.tdt.mockproject.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vn.tdt.mockproject.common.validator.form.CustomerSearchForm;
import vn.tdt.mockproject.entity.RFONumber;
import vn.tdt.mockproject.entity.RFOUser;
import vn.tdt.mockproject.repository.IOperations;
import vn.tdt.mockproject.repository.IRFONumberRepository;
import vn.tdt.mockproject.repository.IRFOUserRepository;
import vn.tdt.mockproject.service.AbstractService;
import vn.tdt.mockproject.service.IRFONumberService;
import vn.tdt.mockproject.service.IRFOUserService;

/**
 * RFONumberServiceImpl.java
 * 
 * @author ThanhTien
 * @since 08-08-2015
 */
@Service
@Transactional
public class RFOUserServiceImpl extends AbstractService<RFOUser>implements IRFOUserService {

	@Autowired
	private IRFOUserRepository dao;

	public RFOUserServiceImpl() {
		super();
	}

	/* 
	 * @see vn.tdt.mockproject.service.IRFOUserService#findOne(java.lang.String)
	 */
	@Override
	public RFOUser findOne(String username) {
		return dao.findOne(username);
	}

	/* 
	 * @see vn.tdt.mockproject.service.AbstractService#getDao()
	 */
	@Override
	protected IOperations<RFOUser> getDao() {
		// TODO Auto-generated method stub
		return dao;
	}

	
	


}
