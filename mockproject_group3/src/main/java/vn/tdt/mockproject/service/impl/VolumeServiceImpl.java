/**
 * (c)Copyright 2015, PhatVT. All rights reserved.
 */
package vn.tdt.mockproject.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vn.tdt.mockproject.entity.Volume;
import vn.tdt.mockproject.repository.IOperations;
import vn.tdt.mockproject.repository.IVolumeRepository;
import vn.tdt.mockproject.service.AbstractService;
import vn.tdt.mockproject.service.IVolumeService;

/**
 * VolumeServiceImpl.java
 * @author PhatVT
 * @since Aug 11, 2015
 */
@Service
@Transactional
public class VolumeServiceImpl extends AbstractService<Volume> implements IVolumeService {

	@Autowired
	private IVolumeRepository dao;
	
	/* 
	 * @see vn.tdt.mockproject.service.AbstractService#getDao()
	 */
	@Override
	protected IOperations<Volume> getDao() {
		return dao;
	}

}
