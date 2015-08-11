/**
 * (c)Copyright 2015, ThanhTien. All rights reserved.
 */
package vn.tdt.mockproject.repository;

import java.util.Date;
import java.util.List;

import vn.tdt.mockproject.entity.Agreement;
import vn.tdt.mockproject.entity.common.AgreementInfo;

/**
 * IAgreementRepository.java
 * @author ThanhTien
 * @since 08-08-2015
 */
public interface IAgreementRepository extends IOperations<Agreement> {

	List<AgreementInfo> findAll(int cusTypeId, String cusName,
			String cusPostcode, int agrStatusId, Date startDate,
			Date endDate, int agrNumber);
	
	Agreement findOne(int agrNumber, int variantNumber);
}