/**
 * (c)Copyright 2015, ThanhTien. All rights reserved.
 */
package vn.tdt.mockproject.repository.impl;



import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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
public class RFONumberRepositoryImpl extends AbstractHibernateDao<RFONumber> implements IRFONumberRepository {

	public RFONumberRepositoryImpl() {
		super();
        setClazz(RFONumber.class);
	}
	
}
