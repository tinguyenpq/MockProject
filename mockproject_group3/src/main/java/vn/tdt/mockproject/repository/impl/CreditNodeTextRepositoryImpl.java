/**
 * (c)Copyright 2015, PhatVT. All rights reserved.
 */
package vn.tdt.mockproject.repository.impl;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import vn.tdt.mockproject.entity.CreditNodeText;
import vn.tdt.mockproject.repository.AbstractHibernateDao;
import vn.tdt.mockproject.repository.ICreditNodeTextRepository;

/**
 * CreditNodeTextRepositoryImpl.java
 * @author PhatVT
 * @since Aug 11, 2015
 */
@Repository
@Transactional
public class CreditNodeTextRepositoryImpl extends AbstractHibernateDao<CreditNodeText> implements ICreditNodeTextRepository {

	@Autowired
	private SessionFactory sessionFactory;
	
	public CreditNodeTextRepositoryImpl() {
		super();
		setClazz(CreditNodeText.class);
	}

	/* 
	 * @see vn.tdt.mockproject.repository.ICreditNodeTextRepository#findOneLatest(int)
	 */
	@Override
	public CreditNodeText findOneLatest(int id) {
		CreditNodeText rs = null;
		try {
			rs = (CreditNodeText) sessionFactory.getCurrentSession()
					.createCriteria(CreditNodeText.class, "c")
					.createAlias("c.agreement", "agreement")
					.add(Restrictions.eq("agreement.agreementNumber", id))
					.addOrder(Order.desc("c.dateTime"))
					.list().get(0);
		} catch (IndexOutOfBoundsException ex) {
			ex.printStackTrace();
		}
		return rs;
	}

	
}
