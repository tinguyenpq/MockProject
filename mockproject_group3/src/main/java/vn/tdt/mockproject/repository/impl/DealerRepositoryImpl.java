/**
 * (c)Copyright 2015, PhatVT. All rights reserved.
 */
package vn.tdt.mockproject.repository.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import vn.tdt.mockproject.common.validator.form.DealerSearchForm;
import vn.tdt.mockproject.entity.Dealer;
import vn.tdt.mockproject.repository.AbstractHibernateDao;
import vn.tdt.mockproject.repository.IDealerRepository;

/**
 * DealerRepositoryImpl.java
 * 
 * @author PhatVT
 * @since Aug 11, 2015
 */
@Repository
@Transactional
public class DealerRepositoryImpl extends AbstractHibernateDao<Dealer>implements IDealerRepository {

	@Autowired
	private SessionFactory sessionFactory;

	public DealerRepositoryImpl() {
		super();
		setClazz(Dealer.class);
	}

	/*
	 * @see
	 * vn.tdt.mockproject.repository.IDealerRepository#findAllByAgreementId(int)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Dealer> findAllByAgreementId(int id) {
		return sessionFactory.getCurrentSession().createCriteria(Dealer.class, "dealer")
				.createAlias("dealer.agreementDealers", "agrDealer").createAlias("agrDealer.agreement", "agr")
				.add(Restrictions.eq("agr.agreementNumber", id)).list();
	}

	/*
	 * @see vn.tdt.mockproject.repository.IDealerRepository#findAll(vn.tdt.
	 * mockproject.common.validator.form.DealerSearchForm)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Dealer> findAll(DealerSearchForm dealerSearchForm) {
		return sessionFactory.getCurrentSession().createCriteria(Dealer.class, "dealer")
				.add(Restrictions.like("dealer.dealerCode", dealerSearchForm.getDealerCode(), MatchMode.ANYWHERE))
				.add(Restrictions.like("dealer.dealerName", dealerSearchForm.getDealerName(), MatchMode.ANYWHERE))
				.list();
	}

}
