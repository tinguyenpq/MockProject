/**
 * (c)Copyright 2015, PhatVT. All rights reserved.
 */
package vn.tdt.mockproject.repository;

import java.util.List;

import vn.tdt.mockproject.entity.SystemConfigValue;

/**
 * ISystemConfigValueRepository.java
 * @author ThanhTIen
 * @since Aug 11, 2015
 */
public interface ISystemConfigValueRepository extends IOperations<SystemConfigValue> {

	/**
	 * @param List<SystemConfigValue>
	 */
	List<SystemConfigValue> finAll(int id);

	
}
