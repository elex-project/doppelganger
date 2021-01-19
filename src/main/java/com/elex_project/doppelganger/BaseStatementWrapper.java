/******************************************************************************
 * Project Doppelgänger                                                       *
 *                                                                            *
 * Copyright (c) 2020. Elex. All Rights Reserved.                             *
 * https://www.elex-project.com/                                              *
 ******************************************************************************/

package com.elex_project.doppelganger;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLWarning;

abstract class BaseStatementWrapper implements java.sql.Statement {
	private final java.sql.Statement statement;

	BaseStatementWrapper(java.sql.Statement statement) {
		this.statement = statement;
	}

	@Override
	public ResultSet executeQuery(final String s) throws SQLException {
		return statement.executeQuery(s);
	}

	@Override
	public int executeUpdate(final String s) throws SQLException {
		return statement.executeUpdate(s);
	}

	@Override
	public void close() throws SQLException {
		statement.close();
	}

	@Override
	public int getMaxFieldSize() throws SQLException {
		return statement.getMaxFieldSize();
	}

	@Override
	public void setMaxFieldSize(final int i) throws SQLException {
		statement.setMaxFieldSize(i);
	}

	@Override
	public int getMaxRows() throws SQLException {
		return statement.getMaxRows();
	}

	@Override
	public void setMaxRows(final int i) throws SQLException {
		statement.setMaxRows(i);
	}

	@Override
	public void setEscapeProcessing(final boolean b) throws SQLException {
		statement.setEscapeProcessing(b);
	}

	@Override
	public int getQueryTimeout() throws SQLException {
		return statement.getQueryTimeout();
	}

	@Override
	public void setQueryTimeout(final int i) throws SQLException {
		statement.setQueryTimeout(i);
	}

	@Override
	public void cancel() throws SQLException {
		statement.cancel();
	}

	@Override
	public SQLWarning getWarnings() throws SQLException {
		return statement.getWarnings();
	}

	@Override
	public void clearWarnings() throws SQLException {
		statement.clearWarnings();
	}

	@Override
	public void setCursorName(final String s) throws SQLException {
		statement.setCursorName(s);
	}

	@Override
	public boolean execute(final String s) throws SQLException {
		return statement.execute(s);
	}

	@Override
	public ResultSet getResultSet() throws SQLException {
		return statement.getResultSet();
	}

	@Override
	public int getUpdateCount() throws SQLException {
		return statement.getUpdateCount();
	}

	@Override
	public boolean getMoreResults() throws SQLException {
		return statement.getMoreResults();
	}

	@Override
	public void setFetchDirection(final int i) throws SQLException {
		statement.setFetchDirection(i);
	}

	@Override
	public int getFetchDirection() throws SQLException {
		return statement.getFetchDirection();
	}

	@Override
	public void setFetchSize(final int i) throws SQLException {
		statement.setFetchSize(i);
	}

	@Override
	public int getFetchSize() throws SQLException {
		return statement.getFetchSize();
	}

	@Override
	public int getResultSetConcurrency() throws SQLException {
		return statement.getResultSetConcurrency();
	}

	@Override
	public int getResultSetType() throws SQLException {
		return statement.getResultSetType();
	}

	@Override
	public void addBatch(final String s) throws SQLException {
		statement.addBatch(s);
	}

	@Override
	public void clearBatch() throws SQLException {
		statement.clearBatch();
	}

	@Override
	public int[] executeBatch() throws SQLException {
		return statement.executeBatch();
	}

	@Override
	public Connection getConnection() throws SQLException {
		return statement.getConnection();
	}

	@Override
	public boolean getMoreResults(final int i) throws SQLException {
		return statement.getMoreResults(i);
	}

	@Override
	public ResultSet getGeneratedKeys() throws SQLException {
		return statement.getGeneratedKeys();
	}

	@Override
	public int executeUpdate(final String s, final int i) throws SQLException {
		return statement.executeUpdate(s, i);
	}

	@Override
	public int executeUpdate(final String s, final int[] ints) throws SQLException {
		return statement.executeUpdate(s, ints);
	}

	@Override
	public int executeUpdate(final String s, final String[] strings) throws SQLException {
		return statement.executeUpdate(s, strings);
	}

	@Override
	public boolean execute(final String s, final int i) throws SQLException {
		return statement.execute(s, i);
	}

	@Override
	public boolean execute(final String s, final int[] ints) throws SQLException {
		return statement.execute(s, ints);
	}

	@Override
	public boolean execute(final String s, final String[] strings) throws SQLException {
		return statement.execute(s, strings);
	}

	@Override
	public int getResultSetHoldability() throws SQLException {
		return statement.getResultSetHoldability();
	}

	@Override
	public boolean isClosed() throws SQLException {
		return statement.isClosed();
	}

	@Override
	public void setPoolable(final boolean b) throws SQLException {
		statement.setPoolable(b);
	}

	@Override
	public boolean isPoolable() throws SQLException {
		return statement.isPoolable();
	}

	@Override
	public void closeOnCompletion() throws SQLException {
		statement.closeOnCompletion();
	}

	@Override
	public boolean isCloseOnCompletion() throws SQLException {
		return statement.isCloseOnCompletion();
	}

	@Override
	public <T> T unwrap(final Class<T> aClass) throws SQLException {
		return statement.unwrap(aClass);
	}

	@Override
	public boolean isWrapperFor(final Class<?> aClass) throws SQLException {
		return statement.isWrapperFor(aClass);
	}
}
