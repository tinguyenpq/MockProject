/**
 * (c)Copyright 2015, ThanhTien. All rights reserved.
 */
package vn.tdt.mockproject.service;

import java.util.List;

import vn.tdt.mockproject.common.validator.form.CustomerSearchForm;
import vn.tdt.mockproject.entity.RFONumber;
import vn.tdt.mockproject.repository.IOperations;

/**
 * IRFOService.java
 * 
 * @author ThanhTien
 * @since 08-08-2015
 */
public interface IRFONumberService extends IOperations<RFONumber> {

	List<RFONumber> findAll(String cusName, String postCode, int cusTypeId);

	/**
	 * @param List<RFONumber>
	 */
	List<RFONumber> findAll(CustomerSearchForm customerSearchForm);

	/**
	 * @param Object
	 */
	RFONumber findOne(String rfoNumber);
	
	
}