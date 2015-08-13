/**
 * (c)Copyright 2015, PhatVT. All rights reserved.
 */
package vn.tdt.mockproject.service;

import java.util.List;

import vn.tdt.mockproject.entity.AgreementStatus;
import vn.tdt.mockproject.entity.common.CountStatusAgreement;
import vn.tdt.mockproject.repository.IOperations;

/**
 * IAgreementStatusService.java
 * @author PhatVT
 * @since Aug 8, 2015
 */
public interface IAgreementStatusService extends IOperations<AgreementStatus>{

	/**
	 * @param Object
	 */
	List<CountStatusAgreement> countAll();

}
