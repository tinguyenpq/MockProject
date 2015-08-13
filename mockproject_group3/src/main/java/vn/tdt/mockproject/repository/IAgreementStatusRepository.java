/**
 * (c)Copyright 2015, PhatVT. All rights reserved.
 */
package vn.tdt.mockproject.repository;

import java.util.List;

import vn.tdt.mockproject.entity.AgreementStatus;
import vn.tdt.mockproject.entity.common.CountStatusAgreement;

/**
 * IAgreementStatusRepository.java
 * @author PhatVT
 * @since Aug 8, 2015
 */
public interface IAgreementStatusRepository extends IOperations<AgreementStatus> {

	/**
	 * @param List<CountStatusAgreement>
	 */
	List<CountStatusAgreement> countAll();

}
