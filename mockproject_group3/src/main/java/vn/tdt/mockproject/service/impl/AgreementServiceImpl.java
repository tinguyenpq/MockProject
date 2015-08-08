/**
 * (c)Copyright 2015, ThanhTien. All rights reserved.
 */
package vn.tdt.mockproject.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vn.tdt.mockproject.entity.Agreement;
import vn.tdt.mockproject.repository.IAgreementRepository;
import vn.tdt.mockproject.repository.IOperations;
import vn.tdt.mockproject.service.AbstractService;
import vn.tdt.mockproject.service.IAgreementService;

/**
 * RFONumberServiceImpl.java
 * @author ThanhTien
 * @since 08-08-2015
 */
@Service
@Transactional
public class AgreementServiceImpl extends AbstractService<Agreement>implements IAgreementService{
	@Autowired
    private IAgreementRepository dao;

    public AgreementServiceImpl() {
        super();
    }

    // API
	/* 
	 * @see vn.tdt.mockproject.service.AbstractService#getDao()
	 */
	@Override
	protected IOperations<Agreement> getDao() {
		 return dao;
	}

	/* 
	 * @see vn.tdt.mockproject.service.IAgreementService#findAll(int, java.lang.String, java.lang.String, int, java.util.Date, java.util.Date, int)
	 */
	@Override
	public List<Agreement> findAll(int cusTypeId, String cusName,
			String cusPostcode, int agrStatusId, Date startDate,
			Date endDate, int agrNumber) {
		return dao.findAll(cusTypeId, cusName,
				cusPostcode, agrStatusId,
				startDate, endDate, agrNumber);
	}
	

}
