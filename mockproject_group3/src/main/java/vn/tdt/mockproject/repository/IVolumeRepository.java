/**
 * (c)Copyright 2015, PhatVT. All rights reserved.
 */
package vn.tdt.mockproject.repository;

import vn.tdt.mockproject.entity.Volume;

/**
 * IVolumeRepository.java
 * @author PhatVT
 * @since Aug 11, 2015
 */
public interface IVolumeRepository extends IOperations<Volume> {

	Volume findOneByAgreementId(int id);
}
