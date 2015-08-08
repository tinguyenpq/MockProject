/**
 * (c)Copyright 2015, ThanhTien. All rights reserved.
 */
package vn.tdt.mockproject.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vn.tdt.mockproject.entity.RFONumber;
import vn.tdt.mockproject.repository.IOperations;
import vn.tdt.mockproject.repository.IRFONumberRepository;
import vn.tdt.mockproject.service.AbstractService;
import vn.tdt.mockproject.service.IRFONumberService;

/**
 * RFONumberServiceImpl.java
 * @author ThanhTien
 * @since 08-08-2015
 */
@Service
@Transactional
public class RFONumberServiceImpl extends AbstractService<RFONumber>implements IRFONumberService{
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
	

}
