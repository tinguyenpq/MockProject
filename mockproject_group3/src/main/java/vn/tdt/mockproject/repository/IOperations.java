/**
 * (c)Copyright 2015, ThanhTien. All rights reserved.
 */
package vn.tdt.mockproject.repository;

import java.io.Serializable;
import java.util.List;

/**
 * IOperations.java
 * 
 * @author ThanhTien
 * @since 08-08-2015
 */
public interface IOperations<T extends Serializable> {

	T findOne(final long id);

	List<T> findAll();

	void create(final T entity);

	T update(final T entity);

	void delete(final T entity);

	void deleteById(final long entityId);

}
