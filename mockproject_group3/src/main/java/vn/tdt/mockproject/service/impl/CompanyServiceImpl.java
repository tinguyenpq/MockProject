/**
 * (c)Copyright 2015, WIN7X64. All rights reserved.
 */
package vn.tdt.mockproject.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vn.tdt.mockproject.entity.Company;
import vn.tdt.mockproject.repository.ICompanyRepository;
import vn.tdt.mockproject.repository.IOperations;
import vn.tdt.mockproject.service.AbstractService;
import vn.tdt.mockproject.service.ICompanyService;

/**
 * CompanyServiceImpl.java
 * @author WIN7X64
 * @since Aug 9, 2015
 */
@Service
@Transactional
public class CompanyServiceImpl extends AbstractService<Company> implements ICompanyService {

	@Autowired
	private ICompanyRepository dao;
	/* 
	 * @see vn.tdt.mockproject.service.AbstractService#getDao()
	 */
	@Override
	protected IOperations<Company> getDao() {
		return dao;
	}

}
