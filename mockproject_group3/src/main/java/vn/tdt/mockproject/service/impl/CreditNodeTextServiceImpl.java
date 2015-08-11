/**
 * (c)Copyright 2015, PhatVT. All rights reserved.
 */
package vn.tdt.mockproject.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vn.tdt.mockproject.entity.CreditNodeText;
import vn.tdt.mockproject.repository.ICreditNodeTextRepository;
import vn.tdt.mockproject.repository.IOperations;
import vn.tdt.mockproject.service.AbstractService;
import vn.tdt.mockproject.service.ICreditNodeTextService;

/**
 * CreditNodeTextServiceImpl.java
 * @author PhatVT
 * @since Aug 11, 2015
 */
@Service
@Transactional
public class CreditNodeTextServiceImpl extends AbstractService<CreditNodeText> implements ICreditNodeTextService {

	@Autowired
	private ICreditNodeTextRepository dao;
	/* 
	 * @see vn.tdt.mockproject.service.AbstractService#getDao()
	 */
	@Override
	protected IOperations<CreditNodeText> getDao() {
		return dao;
	}
	/* 
	 * @see vn.tdt.mockproject.service.ICreditNodeTextService#findOneLatest(int)
	 */
	@Override
	public CreditNodeText findOneLatest(int id) {
		return dao.findOneLatest(id);
	}

}
