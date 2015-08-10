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
import vn.tdt.mockproject.repository.IOperations;
import vn.tdt.mockproject.repository.IRFONumberRepository;
import vn.tdt.mockproject.service.AbstractService;
import vn.tdt.mockproject.service.IRFONumberService;

/**
 * RFONumberServiceImpl.java
 * 
 * @author ThanhTien
 * @since 08-08-2015
 */
@Service
@Transactional
public class RFONumberServiceImpl extends AbstractService<RFONumber>implements IRFONumberService {

	@Autowired
	private IRFONumberRepository dao;

	public RFONumberServiceImpl() {
		super();
	}

	// API
	/*
	 * @see vn.tdt.mockproject.service.AbstractService#getDao()
	 */
	@Override
	protected IOperations<RFONumber> getDao() {
		return dao;
	}

	/*
	 * @see
	 * vn.tdt.mockproject.service.IRFONumberService#findAll(java.lang.String,
	 * java.lang.String, int)
	 */
	@Override
	public List<RFONumber> findAll(String cusName, String postCode, int cusTypeId) {
		return dao.findAll(cusName, postCode, cusTypeId);
	}

	/*
	 * @see
	 * vn.tdt.mockproject.service.IRFONumberService#findAll(vn.tdt.mockproject.
	 * common.validator.form.CustomerSearchForm)
	 */
	@Override
	public List<RFONumber> findAll(CustomerSearchForm customerSearchForm) {
		return dao.findAll(customerSearchForm);
	}



}
