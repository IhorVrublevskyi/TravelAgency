package org.lv326java.two.travelagency.dao;

import java.util.List;

public interface DaoRead<TEntity> {

	// Read
	TEntity getById(Long id);

	List<TEntity> getByFieldName(String fieldName, String text);

	List<TEntity> getAll();

	// List<TEntity> getFilterRange(int partNumber, int partSize, Map<String, String> filters);

}
