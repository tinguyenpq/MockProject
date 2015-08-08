/**
 * (c)Copyright 2015, ThanhTien. All rights reserved.
 */
package vn.tdt.mockproject.repository;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import vn.tdt.mockproject.entity.Agreement;

/**
 * AgreementRepositoryImpl.java
 * 
 * @author ThanhTien
 * @since 08-08-2015
 */
@Repository
@Transactional
public class AgreementRepositoryImpl extends AbstractRepository<Agreement>implements IGenericRepository<Agreement> {

	private static final Logger LOGGER = Logger.getLogger(AgreementRepositoryImpl.class);

	public AgreementRepositoryImpl() {
		setClazz(Agreement.class);
	}

}
