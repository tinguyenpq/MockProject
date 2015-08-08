/**
 * (c)Copyright 2015, ThanhTien. All rights reserved.
 */
package vn.tdt.mockproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vn.tdt.mockproject.entity.RFONumber;
import vn.tdt.mockproject.repository.IGenericRepository;

/**
 * RFONumberServiceImpl.java
 * 
 * @author ThanhTien
 * @since 08-08-2015
 */
@Service
@Transactional
public class RFONumberServiceImpl implements IGenericService<RFONumber> {

	@Autowired
	private IGenericRepository<RFONumber> dao;

	/*
	 * @see vn.tdt.mockproject.service.IGenericService#findById(long)
	 */
	@Override
	public RFONumber findById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * @see vn.tdt.mockproject.service.IGenericService#findAll()
	 */
	@Override
	public List<RFONumber> findAll() {
		return dao.findAll();
	}

	/*
	 * @see
	 * vn.tdt.mockproject.service.IGenericService#create(java.io.Serializable)
	 */
	@Override
	public void create(RFONumber entity) {
		// TODO Auto-generated method stub

	}

	/*
	 * @see
	 * vn.tdt.mockproject.service.IGenericService#update(java.io.Serializable)
	 */
	@Override
	public RFONumber update(RFONumber entity) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * @see
	 * vn.tdt.mockproject.service.IGenericService#delete(java.io.Serializable)
	 */
	@Override
	public void delete(RFONumber entity) {
		// TODO Auto-generated method stub

	}

	/*
	 * @see vn.tdt.mockproject.service.IGenericService#deleteById(long)
	 */
	@Override
	public void deleteById(long id) {
		// TODO Auto-generated method stub

	}

}
