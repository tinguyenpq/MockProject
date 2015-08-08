/**
 * (c)Copyright 2015, PhatVT. All rights reserved.
 */
package vn.tdt.mockproject.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vn.tdt.mockproject.entity.AgreementStatus;
import vn.tdt.mockproject.repository.IAgreementStatusRepository;
import vn.tdt.mockproject.repository.IOperations;
import vn.tdt.mockproject.service.AbstractService;
import vn.tdt.mockproject.service.IAgreementStatusService;

/**
 * AgreementStatusServiceImpl.java
 * @author PhatVT
 * @since Aug 8, 2015
 */
@Service
@Transactional
public class AgreementStatusServiceImpl extends AbstractService<AgreementStatus> implements IAgreementStatusService {
	
	@Autowired
	private IAgreementStatusRepository dao;

	/* 
	 * @see vn.tdt.mockproject.service.AbstractService#getDao()
	 */
	@Override
	protected IOperations<AgreementStatus> getDao() {
		return dao;
	}

}
