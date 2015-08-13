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

import vn.tdt.mockproject.entity.AgreementStatus;
import vn.tdt.mockproject.entity.RFONumber;
import vn.tdt.mockproject.entity.common.CountStatusAgreement;
import vn.tdt.mockproject.repository.AbstractHibernateDao;
import vn.tdt.mockproject.repository.IAgreementStatusRepository;

/**
 * AgreementStatusRepositoryImpl.java
 * 
 * @author PhatVT
 * @since Aug 8, 2015
 */
@Repository
@Transactional
public class AgreementStatusRepositoryImpl extends AbstractHibernateDao<AgreementStatus>
		implements IAgreementStatusRepository {

	private static final Logger LOGGER = Logger.getLogger(RFONumberRepositoryImpl.class);
	@Autowired
	private SessionFactory sessionFactory;

	/**
	 * 
	 */
	public AgreementStatusRepositoryImpl() {
		super();
		setClazz(AgreementStatus.class);
	}

	/*
	 * @see vn.tdt.mockproject.repository.IAgreementStatusRepository#countAll()
	 */
	@Override
	public List<CountStatusAgreement> countAll() {
		LOGGER.info("LOGGER: findAll Count Status Agreement executed");

		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(AgreementStatus.class, "as");

		List<CountStatusAgreement> listCountStatusAgreement = new ArrayList<CountStatusAgreement>();
		

		return listCountStatusAgreement;
	}

}
