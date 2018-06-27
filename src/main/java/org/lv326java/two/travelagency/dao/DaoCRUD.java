package org.lv326java.two.travelagency.dao;

public interface DaoCRUD<TEntity> extends DaoRead<TEntity> {

	// Create
	boolean insert(TEntity entity);

	// Update
	boolean updateByEntity(TEntity entity);
	
	boolean updateByFieldName(String fieldName, String text, String fieldCondition, String textCondition);

	// Delete
	boolean deleteById(Long id);

	boolean deleteByFieldName(String fieldCondition, String textCondition);

	boolean delete(TEntity entity);

}
