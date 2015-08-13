/**
 * (c)Copyright 2015, ThanhTien. All rights reserved.
 */
package vn.tdt.mockproject.repository;


import vn.tdt.mockproject.entity.RFOUser;

/**
 * IRFONumberRepository.java
 * @author ThanhTien
 * @since 08-08-2015
 */
public interface IRFOUserRepository extends IOperations<RFOUser> {

	/**
	 * @param RFOUser
	 */
	RFOUser findOne(String username);



	
}
