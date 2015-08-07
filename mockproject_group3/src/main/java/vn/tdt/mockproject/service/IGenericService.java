/**
 * (c)Copyright 2015, ThanhTien. All rights reserved.
 */
package vn.tdt.mockproject.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * IGenericService.java
 * 
 * @author ThanhTien
 * @since 31-07-2015
 */

public interface IGenericService<T extends java.io.Serializable> {
	T findById(final long id);

	List<T> findAll();

	void create(final T entity);

	T update(final T entity);

	void delete(final T entity);

	void deleteById(final long id);
}
