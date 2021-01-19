/******************************************************************************
 * Project Doppelgänger                                                       *
 *                                                                            *
 * Copyright (c) 2019. Elex. All Rights Reserved.                             *
 * https://www.elex-project.com/                                              *
 ******************************************************************************/

package com.elex_project.doppelganger;

import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.*;
import java.util.Calendar;

abstract class BasePreparedStatementWrapper implements java.sql.PreparedStatement {
	protected final java.sql.PreparedStatement statement;

	BasePreparedStatementWrapper(java.sql.PreparedStatement statement) {
		this.statement = statement;
	}

	@Override
	public ResultSet executeQuery() throws SQLException {
		return new ResultSet(statement.executeQuery());
	}

	@Override
	public int executeUpdate() throws SQLException {
		return statement.executeUpdate();
	}

	@Override
	public void setNull(int i, int i1) throws SQLException {
		statement.setNull(i, i1);
	}

	@Override
	public void setBoolean(int i, boolean b) throws SQLException {
		statement.setBoolean(i, b);
	}

	@Override
	public void setByte(int i, byte b) throws SQLException {
		statement.setByte(i, b);
	}

	@Override
	public void setShort(int i, short i1) throws SQLException {
		statement.setShort(i, i1);
	}

	@Override
	public void setInt(int i, int i1) throws SQLException {
		statement.setInt(i, i1);
	}

	@Override
	public void setLong(int i, long l) throws SQLException {
		statement.setLong(i, l);
	}

	@Override
	public void setFloat(int i, float v) throws SQLException {
		statement.setFloat(i, v);
	}

	@Override
	public void setDouble(int i, double v) throws SQLException {
		statement.setDouble(i, v);
	}

	@Override
	public void setBigDecimal(int i, BigDecimal bigDecimal) throws SQLException {
		statement.setBigDecimal(i, bigDecimal);
	}

	@Override
	public void setString(int i, String s) throws SQLException {
		statement.setString(i, s);
	}

	@Override
	public void setBytes(int i, byte[] bytes) throws SQLException {
		statement.setBytes(i, bytes);
	}

	@Override
	public void setDate(int i, Date date) throws SQLException {
		statement.setDate(i, date);
	}

	@Override
	public void setTime(int i, Time time) throws SQLException {
		statement.setTime(i, time);
	}

	@Override
	public void setTimestamp(int i, Timestamp timestamp) throws SQLException {
		statement.setTimestamp(i, timestamp);
	}

	@Override
	public void setAsciiStream(int i, InputStream inputStream, int i1) throws SQLException {
		statement.setAsciiStream(i, inputStream, i1);
	}

	@Override
	public void setUnicodeStream(int i, InputStream inputStream, int i1) throws SQLException {
		statement.setUnicodeStream(i, inputStream, i1);
	}

	@Override
	public void setBinaryStream(int i, InputStream inputStream, int i1) throws SQLException {
		statement.setBinaryStream(i, inputStream, i1);
	}

	@Override
	public void clearParameters() throws SQLException {
		statement.clearParameters();
	}

	@Override
	public void setObject(int i, Object o, int i1) throws SQLException {
		statement.setObject(i, o, i1);
	}

	@Override
	public void setObject(int i, Object o) throws SQLException {
		statement.setObject(i, o);
	}

	@Override
	public boolean execute() throws SQLException {
		return statement.execute();
	}

	@Override
	public void addBatch() throws SQLException {
		statement.addBatch();
	}

	@Override
	public void setCharacterStream(int i, Reader reader, int i1) throws SQLException {
		statement.setCharacterStream(i, reader, i1);
	}

	@Override
	public void setRef(int i, Ref ref) throws SQLException {
		statement.setRef(i, ref);
	}

	@Override
	public void setBlob(int i, Blob blob) throws SQLException {
		statement.setBlob(i, blob);
	}

	@Override
	public void setClob(int i, Clob clob) throws SQLException {
		statement.setClob(i, clob);
	}

	@Override
	public void setArray(int i, Array array) throws SQLException {
		statement.setArray(i, array);
	}

	@Override
	public ResultSetMetaData getMetaData() throws SQLException {
		return statement.getMetaData();
	}

	@Override
	public void setDate(int i, Date date, Calendar calendar) throws SQLException {
		statement.setDate(i, date, calendar);
	}

	@Override
	public void setTime(int i, Time time, Calendar calendar) throws SQLException {
		statement.setTime(i, time, calendar);
	}

	@Override
	public void setTimestamp(int i, Timestamp timestamp, Calendar calendar) throws SQLException {
		statement.setTimestamp(i, timestamp, calendar);
	}

	@Override
	public void setNull(int i, int i1, String s) throws SQLException {
		statement.setNull(i, i1, s);
	}

	@Override
	public void setURL(int i, URL url) throws SQLException {
		statement.setURL(i, url);
	}

	@Override
	public ParameterMetaData getParameterMetaData() throws SQLException {
		return statement.getParameterMetaData();
	}

	@Override
	public void setRowId(int i, RowId rowId) throws SQLException {
		statement.setRowId(i, rowId);
	}

	@Override
	public void setNString(int i, String s) throws SQLException {
		statement.setNString(i, s);
	}

	@Override
	public void setNCharacterStream(int i, Reader reader, long l) throws SQLException {
		statement.setNCharacterStream(i, reader, l);
	}

	@Override
	public void setNClob(int i, NClob nClob) throws SQLException {
		statement.setNClob(i, nClob);
	}

	@Override
	public void setClob(int i, Reader reader, long l) throws SQLException {
		statement.setClob(i, reader, l);
	}

	@Override
	public void setBlob(int i, InputStream inputStream, long l) throws SQLException {
		statement.setBlob(i, inputStream, l);
	}

	@Override
	public void setNClob(int i, Reader reader, long l) throws SQLException {
		statement.setNClob(i, reader, l);
	}

	@Override
	public void setSQLXML(int i, SQLXML sqlxml) throws SQLException {
		statement.setSQLXML(i, sqlxml);
	}

	@Override
	public void setObject(int i, Object o, int i1, int i2) throws SQLException {
		statement.setObject(i, o, i1, i2);
	}

	@Override
	public void setAsciiStream(int i, InputStream inputStream, long l) throws SQLException {
		statement.setAsciiStream(i, inputStream, l);
	}

	@Override
	public void setBinaryStream(int i, InputStream inputStream, long l) throws SQLException {
		statement.setBinaryStream(i, inputStream, l);
	}

	@Override
	public void setCharacterStream(int i, Reader reader, long l) throws SQLException {
		statement.setCharacterStream(i, reader, l);
	}

	@Override
	public void setAsciiStream(int i, InputStream inputStream) throws SQLException {
		statement.setAsciiStream(i, inputStream);
	}

	@Override
	public void setBinaryStream(int i, InputStream inputStream) throws SQLException {
		statement.setBinaryStream(i, inputStream);
	}

	@Override
	public void setCharacterStream(int i, Reader reader) throws SQLException {
		statement.setCharacterStream(i, reader);
	}

	@Override
	public void setNCharacterStream(int i, Reader reader) throws SQLException {
		statement.setNCharacterStream(i, reader);
	}

	@Override
	public void setClob(int i, Reader reader) throws SQLException {
		statement.setClob(i, reader);
	}

	@Override
	public void setBlob(int i, InputStream inputStream) throws SQLException {
		statement.setBlob(i, inputStream);
	}

	@Override
	public void setNClob(int i, Reader reader) throws SQLException {
		statement.setNClob(i, reader);
	}

	@Override
	public ResultSet executeQuery(String s) throws SQLException {
		return new ResultSet(statement.executeQuery(s));
	}

	@Override
	public int executeUpdate(String s) throws SQLException {
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
	public void setMaxFieldSize(int i) throws SQLException {
		statement.setMaxFieldSize(i);
	}

	@Override
	public int getMaxRows() throws SQLException {
		return statement.getMaxRows();
	}

	@Override
	public void setMaxRows(int i) throws SQLException {
		statement.setMaxRows(i);
	}

	@Override
	public void setEscapeProcessing(boolean b) throws SQLException {
		statement.setEscapeProcessing(b);
	}

	@Override
	public int getQueryTimeout() throws SQLException {
		return statement.getQueryTimeout();
	}

	@Override
	public void setQueryTimeout(int i) throws SQLException {
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
	public void setCursorName(String s) throws SQLException {
		statement.setCursorName(s);
	}

	@Override
	public boolean execute(String s) throws SQLException {
		return statement.execute(s);
	}

	@Override
	public ResultSet getResultSet() throws SQLException {
		return new ResultSet(statement.getResultSet());
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
	public void setFetchDirection(int i) throws SQLException {
		statement.setFetchDirection(i);
	}

	@Override
	public int getFetchDirection() throws SQLException {
		return statement.getFetchDirection();
	}

	@Override
	public void setFetchSize(int i) throws SQLException {
		statement.setFetchDirection(i);
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
	public void addBatch(String s) throws SQLException {
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
	public boolean getMoreResults(int i) throws SQLException {
		return statement.getMoreResults(i);
	}

	@Override
	public ResultSet getGeneratedKeys() throws SQLException {
		return new ResultSet(statement.getGeneratedKeys());
	}

	@Override
	public int executeUpdate(String s, int i) throws SQLException {
		return statement.executeUpdate(s, i);
	}

	@Override
	public int executeUpdate(String s, int[] ints) throws SQLException {
		return statement.executeUpdate(s, ints);
	}

	@Override
	public int executeUpdate(String s, String[] strings) throws SQLException {
		return statement.executeUpdate(s, strings);
	}

	@Override
	public boolean execute(String s, int i) throws SQLException {
		return statement.execute(s, i);
	}

	@Override
	public boolean execute(String s, int[] ints) throws SQLException {
		return statement.execute(s, ints);
	}

	@Override
	public boolean execute(String s, String[] strings) throws SQLException {
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
	public void setPoolable(boolean b) throws SQLException {
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
	public <T> T unwrap(Class<T> aClass) throws SQLException {
		return statement.unwrap(aClass);
	}

	@Override
	public boolean isWrapperFor(Class<?> aClass) throws SQLException {
		return statement.isWrapperFor(aClass);
	}
}
