/**
 * (c)Copyright 2015, ThanhTien. All rights reserved.
 */
package vn.tdt.mockproject.repository.impl;



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
import vn.tdt.mockproject.repository.AbstractHibernateDao;
import vn.tdt.mockproject.repository.IRFONumberRepository;

/**
 * RFONumberRepositoryImpl.java
 * 
 * @author ThanhTien
 * @since 08-08-2015
 */
@Repository
@Transactional
public class RFONumberRepositoryImpl extends AbstractHibernateDao<RFONumber> implements IRFONumberRepository {

	@Autowired
    private SessionFactory sessionFactory;
	
	public RFONumberRepositoryImpl() {
		super();
        setClazz(RFONumber.class);
	}

	/* 
	 * @see vn.tdt.mockproject.repository.IRFONumberRepository#findAll(java.lang.String, java.lang.String, int)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<RFONumber> findAll(String cusName, String postCode, int cusTypeId) {
		Criteria a = sessionFactory
				.getCurrentSession()
				.createCriteria(RFONumber.class, "rfo")
				.createAlias("rfo.customerType", "customerType")
				.createAlias("rfo.company", "company")
				.createAlias("company.address", "address")
				.add(Restrictions.eq("customerType.customerTypeId", cusTypeId))
				.add(Restrictions.like("company.companyName", cusName, MatchMode.ANYWHERE))
				.add(Restrictions.like("address.postCode", postCode, MatchMode.ANYWHERE));
		
		List<RFONumber> rs = a.list();
		
		for (RFONumber num : rs) {
			System.out.println(num.getRFONumber());
		}
		return null;
	}

	
	
	
	
	
	
	
	
	
	
}
