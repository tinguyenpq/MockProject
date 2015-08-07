/**
 * (c)Copyright 2015, ThanhTien. All rights reserved.
 */
package vn.tdt.mockproject.repository;

import java.util.List;

/**
 * IGenericRepository.java
 * 
 * @author ThanhTien
 * @since 31-07-2015
 */
public interface IGenericRepository<T extends java.io.Serializable> {
	T findById(final long id);

	List<T> findAll();

	void create(final T entity);

	void update(final T entity);

	void delete(final T entity);

	void deleteById(final long id);
}
