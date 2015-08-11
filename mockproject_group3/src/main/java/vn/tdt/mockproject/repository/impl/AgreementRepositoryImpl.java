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
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import vn.tdt.mockproject.entity.Agreement;
import vn.tdt.mockproject.entity.common.AgreementInfo;
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
	public List<AgreementInfo> findAll(int cusTypeId, String cusName,
			String cusPostcode, int agrStatusId, Date startDate,
			Date endDate, int agrNumber) {
		
		Criteria cri = sessionFactory.getCurrentSession()
				.createCriteria(Agreement.class, "agr")
				.createAlias("agr.agreementStatus", "agrStatus");
				
		if (agrStatusId != 0) {
			cri.add(Restrictions.eq("agrStatus.agreementStatusId", agrStatusId));
		}
		
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
		
		cri.createAlias("rfo.company", "company");
		if (cusName != null && !"".equals(cusName)) {
			cri.add(Restrictions.like("company.companyName",
					cusName, MatchMode.ANYWHERE));
		}
		
		cri.createAlias("company.address", "address");
		if (cusPostcode != null && !"".equals(cusPostcode)) {
			cri.add(Restrictions.like("address.postCode",
					cusPostcode, MatchMode.ANYWHERE));
		}
		
		cri.setProjection(Projections.projectionList()
				.add(Projections.property("rfo.RFONumber").as("rFONumber"))
				.add(Projections.property("company.companyName").as("companyName"))
				.add(Projections.property("company.companyId").as("companyId"))
				.add(Projections.property("address.postCode").as("postCode"))
				.add(Projections.property("address.addressId").as("addressId"))
				.add(Projections.property("agr.startDate").as("startDate"))
				.add(Projections.property("agr.endDate").as("endDate"))
				.add(Projections.property("agr.agreementNumber").as("agreementNumber"))
				.add(Projections.property("agr.variantNumber").as("variantNumber"))
				.add(Projections.property("agrStatus.agreementStatusName").as("agreementStatusName")));
		
		cri.setResultTransformer(Transformers.aliasToBean(AgreementInfo.class));
		
		return cri.list();
	}

	/* 
	 * @see vn.tdt.mockproject.repository.IAgreementRepository#findByOne(int, int)
	 */
	@Override
	public Agreement findOne(int agrNumber, int variantNumber) {
		return (Agreement) sessionFactory.getCurrentSession()
				.createCriteria(Agreement.class)
				.add(Restrictions.eq("agreementNumber", agrNumber))
				.add(Restrictions.eq("variantNumber", variantNumber))
				.uniqueResult();
	}
	
}
