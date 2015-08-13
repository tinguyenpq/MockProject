/**
 * (c)Copyright 2015, ThanhTien. All rights reserved.
 */
package vn.tdt.mockproject.repository.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import vn.tdt.mockproject.common.validator.form.CustomerSearchForm;
import vn.tdt.mockproject.controller.CustomerController;
import vn.tdt.mockproject.entity.RFONumber;
import vn.tdt.mockproject.entity.RFOUser;
import vn.tdt.mockproject.entity.common.AgreementInfo;
import vn.tdt.mockproject.repository.AbstractHibernateDao;
import vn.tdt.mockproject.repository.IRFONumberRepository;
import vn.tdt.mockproject.repository.IRFOUserRepository;

/**
 * RFOUserRepositoryImpl.java
 * 
 * @author ThanhTien
 * @since 08-08-2015
 */
@Repository
@Transactional
public class RFOUserRepositoryImpl extends AbstractHibernateDao<RFOUser>implements IRFOUserRepository {

	private static final Logger LOGGER = Logger.getLogger(RFOUserRepositoryImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	public RFOUserRepositoryImpl() {
		super();
		setClazz(RFOUser.class);
	}

	/*
	 * @see vn.tdt.mockproject.repository.IRFOUserRepository#findOne(java.lang.
	 * String)
	 */
	@Override
	public RFOUser findOne(String username) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(RFOUser.class, "user")
				.add(Restrictions.eq("user.username", username));
		RFOUser rFOUser = new RFOUser();
		try {
			rFOUser = (RFOUser) criteria.list().get(0);
		} catch (Exception e) {
		}
		return rFOUser;
	}

}
