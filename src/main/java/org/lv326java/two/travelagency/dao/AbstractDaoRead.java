package org.lv326java.two.travelagency.dao;

import org.lv326java.two.travelagency.db.ConnectionManager;
import org.lv326java.two.travelagency.entities.SqlQueries;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;


abstract class AbstractDaoRead<TEntity> implements DaoRead<TEntity> {
    protected final static String QUERY_NOT_FOUND = "Query not found %s";
    protected final static String EMPTY_RESULTSET = "Empty ResultSet by Query %s";
    protected final static String DATABASE_READING_ERROR = "Database Reading Error";
    //
    protected final Map<Enum<?>, Enum<?>> sqlQueries;

    protected AbstractDaoRead() {
        this.sqlQueries = new LinkedHashMap<Enum<?>, Enum<?>>();
        // TODO Call init();
    }

    // TODO Use Builder
    protected abstract TEntity createInstance(Map<String, String> args);

    // TODO Create abstract method init
    protected abstract void init();

    // Read
    protected List<TEntity> getQueryResult(String query, SqlQueries sqlQueries) {
        List<TEntity> all = new ArrayList<>();
        Statement statement = null;
        ResultSet resultSet = null;
        Map<String, String> queryResult;
        if (query == null) {
            throw new RuntimeException(String.format(QUERY_NOT_FOUND, sqlQueries.name()));
        }
        try {
            statement = ConnectionManager.getInstance().getConnection().createStatement();
            resultSet = statement.executeQuery(query);
            ResultSetMetaData md = resultSet.getMetaData();
            int columns = md.getColumnCount();
            queryResult = new LinkedHashMap<>();
            while (resultSet.next()) {
                for (int i = 1; i <= columns; i++) {
                    queryResult.put(md.getColumnName(i), resultSet.getString(i));
                }
                all.add(createInstance(queryResult));
            }
        } catch (SQLException e) {
            throw new RuntimeException(DATABASE_READING_ERROR, e);
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (Exception ex) {
                    // TODO Warning
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (Exception ex) {
                    // TODO Warning
                }
            }
        }
        if (all.isEmpty()) {
//            throw new RuntimeException(String.format(EMPTY_RESULTSET, query));
        }
        return all;
    }

    public TEntity getById(Long id) {
        return getQueryResult(String.format(
                sqlQueries.get(SqlQueries.GET_BY_ID).toString(), id),
                SqlQueries.GET_BY_ID).get(0);
    }

    public List<TEntity> getByFieldName(String fieldName, String text) {
        return getQueryResult(String.format(
                sqlQueries.get(SqlQueries.GET_BY_FIELD).toString(), fieldName, text),
                SqlQueries.GET_BY_FIELD);
    }

    public List<TEntity> getAll() {
        return getQueryResult(
                sqlQueries.get(SqlQueries.GET_ALL).toString(),
                SqlQueries.GET_ALL);
    }

}
