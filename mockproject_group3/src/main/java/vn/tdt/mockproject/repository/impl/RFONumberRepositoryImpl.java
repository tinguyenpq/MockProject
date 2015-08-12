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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import vn.tdt.mockproject.common.validator.form.CustomerSearchForm;
import vn.tdt.mockproject.controller.CustomerController;
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
public class RFONumberRepositoryImpl extends AbstractHibernateDao<RFONumber>implements IRFONumberRepository {

	private static final Logger LOGGER = Logger.getLogger(RFONumberRepositoryImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	public RFONumberRepositoryImpl() {
		super();
		setClazz(RFONumber.class);
	}

	/*
	 * @see
	 * vn.tdt.mockproject.repository.IRFONumberRepository#findAll(java.lang.
	 * String, java.lang.String, int)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<RFONumber> findAll(String cusName, String postCode, int cusTypeId) {
		Criteria a = sessionFactory.getCurrentSession().createCriteria(RFONumber.class, "rfo")
				.createAlias("rfo.customerType", "customerType").createAlias("rfo.company", "company")
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

	/*
	 * @see vn.tdt.mockproject.repository.IRFONumberRepository#findAll(vn.tdt.
	 * mockproject.common.validator.form.CustomerSearchForm)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<RFONumber> findAll(CustomerSearchForm customerSearchForm) {

		
		LOGGER.info("LOGGER: findAll Customer executed");
		List<RFONumber> listRFONumber = sessionFactory.getCurrentSession().createCriteria(RFONumber.class, "rfo")
				.createAlias("rfo.customerType", "cus")
				.createAlias("rfo.company", "com")
				.createAlias("rfo.company.address", "add")
				.add(Restrictions.like("rfo.RFONumber", "'%" + customerSearchForm.getrFONumber() + "%'"))
				.add(Restrictions.like("cus.customerTypeName", customerSearchForm.getCustomerType()))
				.add(Restrictions.like("rfo.RFOName", "'%" + customerSearchForm.getrFOName() + "%'"))
				.add(Restrictions.like("add.postCode", "'%" + customerSearchForm.getPostCode() + "%'"))
				.add(Restrictions.like("com.businessArea", customerSearchForm.getBusinessArea()))
				.add(Restrictions.like("com.sector", "'%" + customerSearchForm.getRegion() + "%'")).list();
		for (RFONumber rfoNumber : listRFONumber) {
			System.out.println(rfoNumber.toString());
		}
		return listRFONumber;
	}

}
