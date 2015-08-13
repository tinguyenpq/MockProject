/**
 * (c)Copyright 2015, PhatVT. All rights reserved.
 */
package vn.tdt.mockproject.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vn.tdt.mockproject.entity.SystemConfigValue;
import vn.tdt.mockproject.repository.IOperations;
import vn.tdt.mockproject.repository.ISystemConfigValueRepository;
import vn.tdt.mockproject.repository.IVolumeRepository;
import vn.tdt.mockproject.service.AbstractService;
import vn.tdt.mockproject.service.ISystemConfigValueService;
import vn.tdt.mockproject.service.IVolumeService;

/**
 * SystemConfigValueServiceImpl.java
 * @author ThanhTien
 * @since Aug 11, 2015
 */
@Service
@Transactional
public class SystemConfigValueServiceImpl extends AbstractService<SystemConfigValue> implements ISystemConfigValueService {

	@Autowired
	private ISystemConfigValueRepository dao;
	
	/* 
	 * @see vn.tdt.mockproject.service.AbstractService#getDao()
	 */
	@Override
	protected IOperations<SystemConfigValue> getDao() {
		return dao;
	}

	/* 
	 * @see vn.tdt.mockproject.service.ISystemConfigValueService#findAll(int)
	 */
	@Override
	public List<SystemConfigValue> findAll(int id) {
		return dao.finAll(id);
	}

}
