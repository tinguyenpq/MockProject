/**
 * (c)Copyright 2015, ThanhTien. All rights reserved.
 */
package vn.tdt.mockproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vn.tdt.mockproject.entity.Agreement;
import vn.tdt.mockproject.repository.IGenericRepository;

/**
 * AgreementServiceImpl.java
 * 
 * @author ThanhTien
 * @since 08-08-2015
 */
@Service
@Transactional
public class AgreementServiceImpl implements IGenericService<Agreement> {

	@Autowired
	private IGenericRepository<Agreement> dao;

	/*
	 * @see vn.tdt.mockproject.service.IGenericService#findById(long)
	 */
	@Override
	public Agreement findById(long id) {
		if (id > 0) {
			return dao.findById(id);
		}
		return new Agreement();
	}

	/*
	 * @see vn.tdt.mockproject.service.IGenericService#findAll()
	 */
	@Override
	public List<Agreement> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * @see
	 * vn.tdt.mockproject.service.IGenericService#create(java.io.Serializable)
	 */
	@Override
	public void create(Agreement entity) {
		// TODO Auto-generated method stub

	}

	/*
	 * @see
	 * vn.tdt.mockproject.service.IGenericService#update(java.io.Serializable)
	 */
	@Override
	public Agreement update(Agreement entity) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * @see
	 * vn.tdt.mockproject.service.IGenericService#delete(java.io.Serializable)
	 */
	@Override
	public void delete(Agreement entity) {
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
