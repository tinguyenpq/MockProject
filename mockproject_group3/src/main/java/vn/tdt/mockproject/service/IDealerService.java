/**
 * (c)Copyright 2015, PhatVT. All rights reserved.
 */
package vn.tdt.mockproject.service;

import java.util.List;

import vn.tdt.mockproject.entity.Dealer;
import vn.tdt.mockproject.repository.IOperations;

/**
 * IDealerService.java
 * @author PhatVT
 * @since Aug 11, 2015
 */
public interface IDealerService extends IOperations<Dealer> {

	List<Dealer> findAllByAgreementId(int id);
}
