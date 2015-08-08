/**
 * (c)Copyright 2015, PhatVT. All rights reserved.
 */
package vn.tdt.mockproject.repository.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import vn.tdt.mockproject.entity.AgreementStatus;
import vn.tdt.mockproject.repository.AbstractHibernateDao;
import vn.tdt.mockproject.repository.IAgreementStatusRepository;

/**
 * AgreementStatusRepositoryImpl.java
 * @author PhatVT
 * @since Aug 8, 2015
 */
@Repository
@Transactional
public class AgreementStatusRepositoryImpl extends AbstractHibernateDao<AgreementStatus> implements IAgreementStatusRepository {

	/**
	 * 
	 */
	public AgreementStatusRepositoryImpl() {
		super();
		setClazz(AgreementStatus.class);
	}

	
	
}
