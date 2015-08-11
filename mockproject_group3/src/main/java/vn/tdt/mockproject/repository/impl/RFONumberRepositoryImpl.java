/**
 * (c)Copyright 2015, ThanhTien. All rights reserved.
 */
package vn.tdt.mockproject.repository.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import vn.tdt.mockproject.common.validator.form.CustomerSearchForm;
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

		StringBuilder queryBuilder = new StringBuilder();

		queryBuilder.append(
				"SELECT rfo.r_f_o_number, rfo.r_f_o_name, rfo.customer_type_id, rfo.company_id, rfo.created_date, rfo.updated_date ");
		queryBuilder.append(" FROM r_f_o_number rfo ");
		queryBuilder.append(" INNER JOIN customer_type cus ");
		queryBuilder.append(" ON rfo.customer_type_id =  cus.customer_type_id ");
		queryBuilder.append(" INNER JOIN company com ");
		queryBuilder.append(" ON rfo.company_id = com.company_id ");
		queryBuilder.append(" INNER JOIN address adr ");
		queryBuilder.append(" ON com.address_id = adr.address_id ");

		queryBuilder.append(" WHERE ");
		queryBuilder.append(" r_F_O_Number like '%" + customerSearchForm.getrFONumber() + "%' AND ");
		queryBuilder.append(" customer_type_name like '%" + customerSearchForm.getCustomerType() + "%' AND ");
		queryBuilder.append(" r_F_O_Name like '%" + customerSearchForm.getrFOName() + "%' AND ");
		queryBuilder.append(" post_code like '%" + customerSearchForm.getPostCode() + "%' AND ");
		queryBuilder.append(" business_area like '%" + customerSearchForm.getBusinessArea() + "%' AND ");
		queryBuilder.append(" sector like '%" + customerSearchForm.getRegion() + "%'");

		Query query = this.getCurrentSession().createQuery(queryBuilder.toString());
		// query.setParameter("customerSearchForm", customerSearchForm);
		List<RFONumber> listRFONumber = new ArrayList<RFONumber>();

		listRFONumber = (List<RFONumber>) query.list();

		return listRFONumber;
	}

}
