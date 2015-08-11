/**
 * (c)Copyright 2015, PhatVT. All rights reserved.
 */
package vn.tdt.mockproject.repository.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import vn.tdt.mockproject.entity.Address;
import vn.tdt.mockproject.repository.AbstractHibernateDao;
import vn.tdt.mockproject.repository.IAddressRepository;

/**
 * AddressRepositoryImpl.java
 * @author PhatVT
 * @since Aug 11, 2015
 */
@Repository
@Transactional
public class AddressRepositoryImpl extends AbstractHibernateDao<Address> implements IAddressRepository {
	
	public AddressRepositoryImpl() {
		super();
		setClazz(Address.class);
	}

	
}
