/**
 * (c)Copyright 2015, ThanhTien. All rights reserved.
 */
package vn.tdt.mockproject.repository.impl;



import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import vn.tdt.mockproject.entity.Agreement;
import vn.tdt.mockproject.repository.AbstractHibernateDao;
import vn.tdt.mockproject.repository.IAgreementRepository;

/**
 * RFONumberRepositoryImpl.java
 * 
 * @author ThanhTien
 * @since 08-08-2015
 */
@Repository
@Transactional
public class AgreementRepositoryImpl extends AbstractHibernateDao<Agreement> implements IAgreementRepository {
	
	@Autowired
    private SessionFactory sessionFactory;
	
	public AgreementRepositoryImpl() {
		super();
        setClazz(Agreement.class);
	}

	/* 
	 * @see vn.tdt.mockproject.repository.IAgreementRepository#findAll(int, java.lang.String, java.lang.String, int, java.lang.String, java.lang.String, int)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Agreement> findAll(int cusTypeId, String cusName,
			String cusPostcode, int agrStatusId, Date startDate,
			Date endDate, int agrNumber) {
		
		Criteria cri = sessionFactory.getCurrentSession()
				.createCriteria(Agreement.class, "agr")
				.createAlias("agr.agreementStatus", "agrStatus")
				.add(Restrictions.eq("agrStatus.agreementStatusId", agrStatusId));
		
		if (agrNumber != 0) {
			cri.add(Restrictions.eq("agr.agreementNumber", agrNumber));
		}
		
		if (startDate != null) {
			cri.add(Restrictions.gt("agr.startDate", startDate));
		}
		
		if (endDate != null) {
			cri.add(Restrictions.lt("agr.endDate", endDate));
		}
		
		cri.createAlias("agr.agreementRFOs", "agrRFO")
		.createAlias("agrRFO.RFONumber", "rfo")
		.createAlias("rfo.customerType", "customerType")
		.add(Restrictions.eq("customerType.customerTypeId", cusTypeId));
		
		if (cusName != null && !"".equals(cusName)) {
			cri.createAlias("rfo.company", "company")
			.add(Restrictions.like("company.companyName", cusName, MatchMode.ANYWHERE));
		}
		
		if (cusPostcode != null && !"".equals(cusPostcode)) {
			cri.createAlias("company.address", "address")
			.add(Restrictions.like("address.postCode", cusPostcode, MatchMode.ANYWHERE));
		}
		
		return cri.list();
	}
	
}
