package org.lv326java.two.travelagency.dao;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.Map;

import org.lv326java.two.travelagency.db.ConnectionManager;
import org.lv326java.two.travelagency.entities.Entity;
import org.lv326java.two.travelagency.entities.SqlQueries;

abstract class AbstractDaoCRUD<TEntity extends Entity> extends AbstractDaoRead<TEntity> implements DaoCRUD<TEntity> {
	protected final static String DATABASE_INPUT_ERROR = "Database Input Error";

	protected AbstractDaoCRUD() {
		super();
	}

	// TODO Use Builder
	// TODO Use List<String>
	protected abstract Map<String, String> getFields(TEntity entity);

	// TODO Use List<String>
	protected abstract Map<String, String> getUpdateFields(TEntity entity);

	private boolean executeQuery(String query, SqlQueries sqlQueries) {
		boolean result = false;
		Statement statement = null;
		if (query == null) {
			throw new RuntimeException(String.format(QUERY_NOT_FOUND, sqlQueries.name()));
		}
		try {
			statement = ConnectionManager.getInstance().getConnection().createStatement();
			// TODO CHECK!
			result = statement.execute(query);
		} catch (SQLException e) {
//			throw new RuntimeException(DATABASE_INPUT_ERROR, e);
		} finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (Exception ex) {
					// TODO Warning
				}
			}
		}
		// TODO result must be return if delete Ok
		return result;
	}
	
	// Create
	public boolean insert(TEntity entity) {
        Map<String, String> allFields = getFields(entity);
		String query = String.format(sqlQueries.get(SqlQueries.INSERT).toString(),
					(Object[]) Arrays.copyOfRange(allFields.values().toArray(), 1, allFields.values().size()));
//		System.out.println("query = " + query);
		return executeQuery(query, SqlQueries.INSERT);
	}

	// Update
	public boolean updateByEntity(TEntity entity) {
        Map<String, String> updateFields = getUpdateFields(entity);
		String query = String.format(sqlQueries.get(SqlQueries.UPDATE_BY_ID).toString(),
					updateFields.values());
		return executeQuery(query, SqlQueries.UPDATE_BY_FIELD);
	}

	public boolean updateByFieldName(String fieldName, String text, String fieldCondition, String textCondition) {
		String query = String.format(sqlQueries.get(SqlQueries.UPDATE_BY_FIELD).toString(),
					fieldName, text, fieldCondition, textCondition);
		return executeQuery(query, SqlQueries.UPDATE_BY_FIELD);
	}

	// Delete
	public boolean deleteById(Long id) {
		String query = String.format(sqlQueries.get(SqlQueries.DELETE_BY_ID).toString(),
					id);
		//System.out.println("query=" + query);
		return executeQuery(query, SqlQueries.DELETE_BY_ID);
	}

	public boolean deleteByFieldName(String fieldCondition, String textCondition) {
		String query = String.format(sqlQueries.get(SqlQueries.DELETE_BY_FIELD).toString(),
					fieldCondition, textCondition);
		return executeQuery(query, SqlQueries.DELETE_BY_FIELD);
	}

	public boolean delete(TEntity entity) {
		return deleteById(entity.getId());
	}

}