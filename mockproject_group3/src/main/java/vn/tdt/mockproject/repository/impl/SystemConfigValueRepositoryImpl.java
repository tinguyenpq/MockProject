/**
 * (c)Copyright 2015, PhatVT. All rights reserved.
 */
package vn.tdt.mockproject.repository.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import vn.tdt.mockproject.entity.RFONumber;
import vn.tdt.mockproject.entity.SystemConfigValue;
import vn.tdt.mockproject.entity.Volume;
import vn.tdt.mockproject.repository.AbstractHibernateDao;
import vn.tdt.mockproject.repository.ISystemConfigValueRepository;
import vn.tdt.mockproject.repository.IVolumeRepository;

/**
 * SystemConfigValueRepositoryImpl.java
 * 
 * @author ThanhTien
 * @since Aug 11, 2015
 */
@Repository
@Transactional
public class SystemConfigValueRepositoryImpl extends AbstractHibernateDao<SystemConfigValue>
		implements ISystemConfigValueRepository {
	private static final Logger LOGGER = Logger.getLogger(RFONumberRepositoryImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	public SystemConfigValueRepositoryImpl() {
		super();
		setClazz(SystemConfigValue.class);
	}

	/*
	 * @see
	 * vn.tdt.mockproject.repository.ISystemConfigValueRepository#finAll(int)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<SystemConfigValue> finAll(int id) {
		LOGGER.info("LOGGER: findAll SystemConfigValue with id = " + id);

		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(SystemConfigValue.class, "sysConfigValue")
				.createAlias("sysConfigValue.systemConfig", "systemConfig")
				.add(Restrictions.eq("systemConfig.systemConfigId", id));

		List<SystemConfigValue> listSystemConfigValue = new ArrayList<SystemConfigValue>();
		listSystemConfigValue = criteria.list();

		
		return listSystemConfigValue;
	}

}
