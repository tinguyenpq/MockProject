/**
 * (c)Copyright 2015, ThanhTien. All rights reserved.
 */
package vn.tdt.mockproject.repository;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import vn.tdt.mockproject.entity.RFONumber;

/**
 * RFONumberRepositoryImpl.java
 * 
 * @author ThanhTien
 * @since 08-08-2015
 */
@Repository
@Transactional
public class RFONumberRepositoryImpl extends AbstractRepository<RFONumber>implements IGenericRepository<RFONumber> {
	private static final Logger LOGGER = Logger.getLogger(RFONumberRepositoryImpl.class);

	public RFONumberRepositoryImpl() {
		setClazz(RFONumber.class);
	}
	
}
