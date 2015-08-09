/**
 * (c)Copyright 2015, WIN7X64. All rights reserved.
 */
package vn.tdt.mockproject.repository.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import vn.tdt.mockproject.entity.Company;
import vn.tdt.mockproject.repository.AbstractHibernateDao;
import vn.tdt.mockproject.repository.ICompanyRepository;

/**
 * CompanyRepositoryImpl.java
 * @author WIN7X64
 * @since Aug 9, 2015
 */
@Repository
@Transactional
public class CompanyRepositoryImpl extends AbstractHibernateDao<Company> implements ICompanyRepository {

	public CompanyRepositoryImpl() {
		super();
		setClazz(Company.class);
	}

	
}
