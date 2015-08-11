/**
 * (c)Copyright 2015, PhatVT. All rights reserved.
 */
package vn.tdt.mockproject.repository.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import vn.tdt.mockproject.entity.Volume;
import vn.tdt.mockproject.repository.AbstractHibernateDao;
import vn.tdt.mockproject.repository.IVolumeRepository;

/**
 * VolumeRepositoryImpl.java
 * @author PhatVT
 * @since Aug 11, 2015
 */
@Repository
@Transactional
public class VolumeRepositoryImpl extends AbstractHibernateDao<Volume> implements IVolumeRepository {

	public VolumeRepositoryImpl() {
		super();
		setClazz(Volume.class);
	}

	
}
