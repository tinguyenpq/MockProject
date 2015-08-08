/**
 * (c)Copyright 2015, PhatVT. All rights reserved.
 */
package vn.tdt.mockproject.repository.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import vn.tdt.mockproject.entity.CustomerType;
import vn.tdt.mockproject.repository.AbstractHibernateDao;
import vn.tdt.mockproject.repository.ICustomerTypeRepository;

/**
 * CustomerTypeRepositoryImpl.java
 * @author PhatVT
 * @since Aug 8, 2015
 */
@Repository
@Transactional
public class CustomerTypeRepositoryImpl extends AbstractHibernateDao<CustomerType> implements ICustomerTypeRepository {

	/**
	 * 
	 */
	public CustomerTypeRepositoryImpl() {
		setClazz(CustomerType.class);
	}

	
}
