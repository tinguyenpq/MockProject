/**
 * (c)Copyright 2015, PhatVT. All rights reserved.
 */
package vn.tdt.mockproject.repository;

import vn.tdt.mockproject.entity.CreditNodeText;

/**
 * ICreditNodeTextRepository.java
 * @author PhatVT
 * @since Aug 11, 2015
 */
public interface ICreditNodeTextRepository extends IOperations<CreditNodeText> {

	CreditNodeText findOneLatest(int id);
}
