/**
 * (c)Copyright 2015, PhatVT. All rights reserved.
 */
package vn.tdt.mockproject.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vn.tdt.mockproject.entity.Dealer;
import vn.tdt.mockproject.repository.IDealerRepository;
import vn.tdt.mockproject.repository.IOperations;
import vn.tdt.mockproject.service.AbstractService;
import vn.tdt.mockproject.service.IDealerService;

/**
 * DealerServiceImpl.java
 * @author PhatVT
 * @since Aug 11, 2015
 */
@Service
@Transactional
public class DealerServiceImpl extends AbstractService<Dealer> implements IDealerService {

	@Autowired
	private IDealerRepository dao;
	/* 
	 * @see vn.tdt.mockproject.service.AbstractService#getDao()
	 */
	@Override
	protected IOperations<Dealer> getDao() {
		return dao;
	}
	/* 
	 * @see vn.tdt.mockproject.service.IDealerService#findAllByAgreementId(int)
	 */
	@Override
	public List<Dealer> findAllByAgreementId(int id) {
		return dao.findAllByAgreementId(id);
	}

}
