/**
 * (c)Copyright 2015, PhatVT. All rights reserved.
 */
package vn.tdt.mockproject.service;

import vn.tdt.mockproject.entity.CreditNodeText;
import vn.tdt.mockproject.repository.IOperations;

/**
 * ICreditNodeTextService.java
 * @author PhatVT
 * @since Aug 11, 2015
 */
public interface ICreditNodeTextService extends IOperations<CreditNodeText> {

	CreditNodeText findOneLatest(int id);
}
