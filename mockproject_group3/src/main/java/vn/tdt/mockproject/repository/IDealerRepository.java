/**
 * (c)Copyright 2015, PhatVT. All rights reserved.
 */
package vn.tdt.mockproject.repository;

import java.util.List;

import vn.tdt.mockproject.entity.Dealer;

/**
 * IDealerRepository.java
 * @author PhatVT
 * @since Aug 11, 2015
 */
public interface IDealerRepository extends IOperations<Dealer> {

	List<Dealer> findAllByAgreementId(int id);
}
