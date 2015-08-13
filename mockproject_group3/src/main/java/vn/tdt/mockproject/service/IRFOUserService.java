/**
 * (c)Copyright 2015, ThanhTien. All rights reserved.
 */
package vn.tdt.mockproject.service;

import vn.tdt.mockproject.entity.RFOUser;
import vn.tdt.mockproject.repository.IOperations;

/**
 * IRFOService.java
 * 
 * @author ThanhTien
 * @since 08-08-2015
 */
public interface IRFOUserService extends IOperations<RFOUser> {

	/**
	 * @param RFOUser
	 */
	RFOUser findOne(String username);

}