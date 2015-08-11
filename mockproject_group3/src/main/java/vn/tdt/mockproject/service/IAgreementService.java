/**
 * (c)Copyright 2015, ThanhTien. All rights reserved.
 */
package vn.tdt.mockproject.service;

import java.util.Date;
import java.util.List;

import vn.tdt.mockproject.entity.Agreement;
import vn.tdt.mockproject.entity.common.AgreementInfo;
import vn.tdt.mockproject.repository.IOperations;

/**
 * IRFOService.java
 * 
 * @author ThanhTien
 * @since 08-08-2015
 */
public interface IAgreementService extends IOperations<Agreement> {
	
	List<AgreementInfo> findAll(int cusTypeId, String cusName,
			String cusPostcode, int agrStatusId, Date startDate,
			Date endDate, int agrNumber);
}