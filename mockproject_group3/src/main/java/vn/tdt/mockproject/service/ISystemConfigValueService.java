/**
 * (c)Copyright 2015, PhatVT. All rights reserved.
 */
package vn.tdt.mockproject.service;

import java.util.List;

import vn.tdt.mockproject.entity.SystemConfigValue;
import vn.tdt.mockproject.repository.IOperations;

/**
 * ISystemConfigValueService.java
 * @author ThanhTien
 * @since Aug 11, 2015
 */
public interface ISystemConfigValueService extends IOperations<SystemConfigValue> {

	/**
	 * @param Object
	 */
	List<SystemConfigValue> findAll(int id);

}
