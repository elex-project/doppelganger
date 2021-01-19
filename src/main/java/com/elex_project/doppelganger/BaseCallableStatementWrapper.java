/******************************************************************************
 * Project Doppelgänger                                                       *
 *                                                                            *
 * Copyright (c) 2020. Elex. All Rights Reserved.                             *
 * https://www.elex-project.com/                                              *
 ******************************************************************************/

package com.elex_project.doppelganger;

import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.*;
import java.util.Calendar;
import java.util.Map;

class BaseCallableStatementWrapper implements java.sql.CallableStatement {
	private final java.sql.CallableStatement statement;

	BaseCallableStatementWrapper(java.sql.CallableStatement statement) {
		this.statement = statement;
	}

	@Override
	public void registerOutParameter(final int i, final int i1) throws SQLException {
		statement.registerOutParameter(i, i1);
	}

	@Override
	public void registerOutParameter(final int i, final int i1, final int i2) throws SQLException {
		statement.registerOutParameter(i, i1, i2);
	}

	@Override
	public boolean wasNull() throws SQLException {
		return statement.wasNull();
	}

	@Override
	public String getString(final int i) throws SQLException {
		return statement.getString(i);
	}

	@Override
	public boolean getBoolean(final int i) throws SQLException {
		return statement.getBoolean(i);
	}

	@Override
	public byte getByte(final int i) throws SQLException {
		return statement.getByte(i);
	}

	@Override
	public short getShort(final int i) throws SQLException {
		return statement.getShort(i);
	}

	@Override
	public int getInt(final int i) throws SQLException {
		return statement.getInt(i);
	}

	@Override
	public long getLong(final int i) throws SQLException {
		return statement.getLong(i);
	}

	@Override
	public float getFloat(final int i) throws SQLException {
		return statement.getFloat(i);
	}

	@Override
	public double getDouble(final int i) throws SQLException {
		return statement.getDouble(i);
	}

	@Override
	@Deprecated
	public BigDecimal getBigDecimal(final int i, final int i1) throws SQLException {
		return statement.getBigDecimal(i, i1);
	}

	@Override
	public byte[] getBytes(final int i) throws SQLException {
		return statement.getBytes(i);
	}

	@Override
	public Date getDate(final int i) throws SQLException {
		return statement.getDate(i);
	}

	@Override
	public Time getTime(final int i) throws SQLException {
		return statement.getTime(i);
	}

	@Override
	public Timestamp getTimestamp(final int i) throws SQLException {
		return statement.getTimestamp(i);
	}

	@Override
	public Object getObject(final int i) throws SQLException {
		return statement.getObject(i);
	}

	@Override
	public BigDecimal getBigDecimal(final int i) throws SQLException {
		return statement.getBigDecimal(i);
	}

	@Override
	public Object getObject(final int i, final Map<String, Class<?>> map) throws SQLException {
		return statement.getObject(i, map);
	}

	@Override
	public Ref getRef(final int i) throws SQLException {
		return statement.getRef(i);
	}

	@Override
	public Blob getBlob(final int i) throws SQLException {
		return statement.getBlob(i);
	}

	@Override
	public Clob getClob(final int i) throws SQLException {
		return statement.getClob(i);
	}

	@Override
	public Array getArray(final int i) throws SQLException {
		return statement.getArray(i);
	}

	@Override
	public Date getDate(final int i, final Calendar calendar) throws SQLException {
		return statement.getDate(i, calendar);
	}

	@Override
	public Time getTime(final int i, final Calendar calendar) throws SQLException {
		return statement.getTime(i, calendar);
	}

	@Override
	public Timestamp getTimestamp(final int i, final Calendar calendar) throws SQLException {
		return statement.getTimestamp(i, calendar);
	}

	@Override
	public void registerOutParameter(final int i, final int i1, final String s) throws SQLException {
		statement.registerOutParameter(i, i1, s);
	}

	@Override
	public void registerOutParameter(final String s, final int i) throws SQLException {
		statement.registerOutParameter(s, i);
	}

	@Override
	public void registerOutParameter(final String s, final int i, final int i1) throws SQLException {
		statement.registerOutParameter(s, i, i1);
	}

	@Override
	public void registerOutParameter(final String s, final int i, final String s1) throws SQLException {
		statement.registerOutParameter(s, i, s1);
	}

	@Override
	public URL getURL(final int i) throws SQLException {
		return statement.getURL(i);
	}

	@Override
	public void setURL(final String s, final URL url) throws SQLException {
		statement.setURL(s, url);
	}

	@Override
	public void setNull(final String s, final int i) throws SQLException {
		statement.setNull(s, i);
	}

	@Override
	public void setBoolean(final String s, final boolean b) throws SQLException {
		statement.setBoolean(s, b);
	}

	@Override
	public void setByte(final String s, final byte b) throws SQLException {
		statement.setByte(s, b);
	}

	@Override
	public void setShort(final String s, final short i) throws SQLException {
		statement.setShort(s, i);
	}

	@Override
	public void setInt(final String s, final int i) throws SQLException {
		statement.setInt(s, i);
	}

	@Override
	public void setLong(final String s, final long l) throws SQLException {
		statement.setLong(s, l);
	}

	@Override
	public void setFloat(final String s, final float v) throws SQLException {
		statement.setFloat(s, v);
	}

	@Override
	public void setDouble(final String s, final double v) throws SQLException {
		statement.setDouble(s, v);
	}

	@Override
	public void setBigDecimal(final String s, final BigDecimal bigDecimal) throws SQLException {
		statement.setBigDecimal(s, bigDecimal);
	}

	@Override
	public void setString(final String s, final String s1) throws SQLException {
		statement.setString(s, s1);
	}

	@Override
	public void setBytes(final String s, final byte[] bytes) throws SQLException {
		statement.setBytes(s, bytes);
	}

	@Override
	public void setDate(final String s, final Date date) throws SQLException {
		statement.setDate(s, date);
	}

	@Override
	public void setTime(final String s, final Time time) throws SQLException {
		statement.setTime(s, time);
	}

	@Override
	public void setTimestamp(final String s, final Timestamp timestamp) throws SQLException {
		statement.setTimestamp(s, timestamp);
	}

	@Override
	public void setAsciiStream(final String s, final InputStream inputStream, final int i) throws SQLException {
		statement.setAsciiStream(s, inputStream, i);
	}

	@Override
	public void setBinaryStream(final String s, final InputStream inputStream, final int i) throws SQLException {
		statement.setBinaryStream(s, inputStream, i);
	}

	@Override
	public void setObject(final String s, final Object o, final int i, final int i1) throws SQLException {
		statement.setObject(s, o, i, i1);
	}

	@Override
	public void setObject(final String s, final Object o, final int i) throws SQLException {
		statement.setObject(s, o, i);
	}

	@Override
	public void setObject(final String s, final Object o) throws SQLException {
		statement.setObject(s, o);
	}

	@Override
	public void setCharacterStream(final String s, final Reader reader, final int i) throws SQLException {
		statement.setCharacterStream(s, reader, i);
	}

	@Override
	public void setDate(final String s, final Date date, final Calendar calendar) throws SQLException {
		statement.setDate(s, date, calendar);
	}

	@Override
	public void setTime(final String s, final Time time, final Calendar calendar) throws SQLException {
		statement.setTime(s, time, calendar);
	}

	@Override
	public void setTimestamp(final String s, final Timestamp timestamp, final Calendar calendar) throws SQLException {
		statement.setTimestamp(s, timestamp, calendar);
	}

	@Override
	public void setNull(final String s, final int i, final String s1) throws SQLException {
		statement.setNull(s, i, s1);
	}

	@Override
	public String getString(final String s) throws SQLException {
		return statement.getString(s);
	}

	@Override
	public boolean getBoolean(final String s) throws SQLException {
		return statement.getBoolean(s);
	}

	@Override
	public byte getByte(final String s) throws SQLException {
		return statement.getByte(s);
	}

	@Override
	public short getShort(final String s) throws SQLException {
		return statement.getShort(s);
	}

	@Override
	public int getInt(final String s) throws SQLException {
		return statement.getInt(s);
	}

	@Override
	public long getLong(final String s) throws SQLException {
		return statement.getLong(s);
	}

	@Override
	public float getFloat(final String s) throws SQLException {
		return statement.getFloat(s);
	}

	@Override
	public double getDouble(final String s) throws SQLException {
		return statement.getDouble(s);
	}

	@Override
	public byte[] getBytes(final String s) throws SQLException {
		return statement.getBytes(s);
	}

	@Override
	public Date getDate(final String s) throws SQLException {
		return statement.getDate(s);
	}

	@Override
	public Time getTime(final String s) throws SQLException {
		return statement.getTime(s);
	}

	@Override
	public Timestamp getTimestamp(final String s) throws SQLException {
		return statement.getTimestamp(s);
	}

	@Override
	public Object getObject(final String s) throws SQLException {
		return statement.getObject(s);
	}

	@Override
	public BigDecimal getBigDecimal(final String s) throws SQLException {
		return statement.getBigDecimal(s);
	}

	@Override
	public Object getObject(final String s, final Map<String, Class<?>> map) throws SQLException {
		return statement.getObject(s, map);
	}

	@Override
	public Ref getRef(final String s) throws SQLException {
		return statement.getRef(s);
	}

	@Override
	public Blob getBlob(final String s) throws SQLException {
		return statement.getBlob(s);
	}

	@Override
	public Clob getClob(final String s) throws SQLException {
		return statement.getClob(s);
	}

	@Override
	public Array getArray(final String s) throws SQLException {
		return statement.getArray(s);
	}

	@Override
	public Date getDate(final String s, final Calendar calendar) throws SQLException {
		return statement.getDate(s, calendar);
	}

	@Override
	public Time getTime(final String s, final Calendar calendar) throws SQLException {
		return statement.getTime(s, calendar);
	}

	@Override
	public Timestamp getTimestamp(final String s, final Calendar calendar) throws SQLException {
		return statement.getTimestamp(s, calendar);
	}

	@Override
	public URL getURL(final String s) throws SQLException {
		return statement.getURL(s);
	}

	@Override
	public RowId getRowId(final int i) throws SQLException {
		return statement.getRowId(i);
	}

	@Override
	public RowId getRowId(final String s) throws SQLException {
		return statement.getRowId(s);
	}

	@Override
	public void setRowId(final String s, final RowId rowId) throws SQLException {
		statement.setRowId(s, rowId);
	}

	@Override
	public void setNString(final String s, final String s1) throws SQLException {
		statement.setNString(s, s1);
	}

	@Override
	public void setNCharacterStream(final String s, final Reader reader, final long l) throws SQLException {
		statement.setNCharacterStream(s, reader, l);
	}

	@Override
	public void setNClob(final String s, final NClob nClob) throws SQLException {
		statement.setNClob(s, nClob);
	}

	@Override
	public void setClob(final String s, final Reader reader, final long l) throws SQLException {
		statement.setClob(s, reader, l);
	}

	@Override
	public void setBlob(final String s, final InputStream inputStream, final long l) throws SQLException {
		statement.setBlob(s, inputStream, l);
	}

	@Override
	public void setNClob(final String s, final Reader reader, final long l) throws SQLException {
		statement.setNClob(s, reader, l);
	}

	@Override
	public NClob getNClob(final int i) throws SQLException {
		return statement.getNClob(i);
	}

	@Override
	public NClob getNClob(final String s) throws SQLException {
		return statement.getNClob(s);
	}

	@Override
	public void setSQLXML(final String s, final SQLXML sqlxml) throws SQLException {
		statement.setSQLXML(s, sqlxml);
	}

	@Override
	public SQLXML getSQLXML(final int i) throws SQLException {
		return statement.getSQLXML(i);
	}

	@Override
	public SQLXML getSQLXML(final String s) throws SQLException {
		return statement.getSQLXML(s);
	}

	@Override
	public String getNString(final int i) throws SQLException {
		return statement.getNString(i);
	}

	@Override
	public String getNString(final String s) throws SQLException {
		return statement.getNString(s);
	}

	@Override
	public Reader getNCharacterStream(final int i) throws SQLException {
		return statement.getNCharacterStream(i);
	}

	@Override
	public Reader getNCharacterStream(final String s) throws SQLException {
		return statement.getNCharacterStream(s);
	}

	@Override
	public Reader getCharacterStream(final int i) throws SQLException {
		return statement.getCharacterStream(i);
	}

	@Override
	public Reader getCharacterStream(final String s) throws SQLException {
		return statement.getCharacterStream(s);
	}

	@Override
	public void setBlob(final String s, final Blob blob) throws SQLException {
		statement.setBlob(s, blob);
	}

	@Override
	public void setClob(final String s, final Clob clob) throws SQLException {
		statement.setClob(s, clob);
	}

	@Override
	public void setAsciiStream(final String s, final InputStream inputStream, final long l) throws SQLException {
		statement.setAsciiStream(s, inputStream, l);
	}

	@Override
	public void setBinaryStream(final String s, final InputStream inputStream, final long l) throws SQLException {
		statement.setBinaryStream(s, inputStream, l);
	}

	@Override
	public void setCharacterStream(final String s, final Reader reader, final long l) throws SQLException {
		statement.setCharacterStream(s, reader, l);
	}

	@Override
	public void setAsciiStream(final String s, final InputStream inputStream) throws SQLException {
		statement.setAsciiStream(s, inputStream);
	}

	@Override
	public void setBinaryStream(final String s, final InputStream inputStream) throws SQLException {
		statement.setBinaryStream(s, inputStream);
	}

	@Override
	public void setCharacterStream(final String s, final Reader reader) throws SQLException {
		statement.setCharacterStream(s, reader);
	}

	@Override
	public void setNCharacterStream(final String s, final Reader reader) throws SQLException {
		statement.setNCharacterStream(s, reader);
	}

	@Override
	public void setClob(final String s, final Reader reader) throws SQLException {
		statement.setClob(s, reader);
	}

	@Override
	public void setBlob(final String s, final InputStream inputStream) throws SQLException {
		statement.setBlob(s, inputStream);
	}

	@Override
	public void setNClob(final String s, final Reader reader) throws SQLException {
		statement.setClob(s, reader);
	}

	@Override
	public <T> T getObject(final int i, final Class<T> aClass) throws SQLException {
		return statement.getObject(i, aClass);
	}

	@Override
	public <T> T getObject(final String s, final Class<T> aClass) throws SQLException {
		return statement.getObject(s, aClass);
	}

	@Override
	public ResultSet executeQuery() throws SQLException {
		return statement.executeQuery();
	}

	@Override
	public int executeUpdate() throws SQLException {
		return statement.executeUpdate();
	}

	@Override
	public void setNull(final int i, final int i1) throws SQLException {
		statement.setNull(i, i1);
	}

	@Override
	public void setBoolean(final int i, final boolean b) throws SQLException {
		statement.setBoolean(i, b);
	}

	@Override
	public void setByte(final int i, final byte b) throws SQLException {
		statement.setByte(i, b);
	}

	@Override
	public void setShort(final int i, final short i1) throws SQLException {
		statement.setShort(i, i1);
	}

	@Override
	public void setInt(final int i, final int i1) throws SQLException {
		statement.setInt(i, i1);
	}

	@Override
	public void setLong(final int i, final long l) throws SQLException {
		statement.setLong(i, l);
	}

	@Override
	public void setFloat(final int i, final float v) throws SQLException {
		statement.setFloat(i, v);
	}

	@Override
	public void setDouble(final int i, final double v) throws SQLException {
		statement.setDouble(i, v);
	}

	@Override
	public void setBigDecimal(final int i, final BigDecimal bigDecimal) throws SQLException {
		statement.setBigDecimal(i, bigDecimal);
	}

	@Override
	public void setString(final int i, final String s) throws SQLException {
		statement.setString(i, s);
	}

	@Override
	public void setBytes(final int i, final byte[] bytes) throws SQLException {
		statement.setBytes(i, bytes);
	}

	@Override
	public void setDate(final int i, final Date date) throws SQLException {
		statement.setDate(i, date);
	}

	@Override
	public void setTime(final int i, final Time time) throws SQLException {
		statement.setTime(i, time);
	}

	@Override
	public void setTimestamp(final int i, final Timestamp timestamp) throws SQLException {
		statement.setTimestamp(i, timestamp);
	}

	@Override
	public void setAsciiStream(final int i, final InputStream inputStream, final int i1) throws SQLException {
		statement.setAsciiStream(i, inputStream, i1);
	}

	@Override
	@Deprecated
	public void setUnicodeStream(final int i, final InputStream inputStream, final int i1) throws SQLException {
		statement.setUnicodeStream(i, inputStream, i1);
	}

	@Override
	public void setBinaryStream(final int i, final InputStream inputStream, final int i1) throws SQLException {
		statement.setBinaryStream(i, inputStream, i1);
	}

	@Override
	public void clearParameters() throws SQLException {
		statement.clearParameters();
	}

	@Override
	public void setObject(final int i, final Object o, final int i1) throws SQLException {
		statement.setObject(i, o, i1);
	}

	@Override
	public void setObject(final int i, final Object o) throws SQLException {
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
	public void setCharacterStream(final int i, final Reader reader, final int i1) throws SQLException {
		statement.setCharacterStream(i, reader, i1);
	}

	@Override
	public void setRef(final int i, final Ref ref) throws SQLException {
		statement.setRef(i, ref);
	}

	@Override
	public void setBlob(final int i, final Blob blob) throws SQLException {
		statement.setBlob(i, blob);
	}

	@Override
	public void setClob(final int i, final Clob clob) throws SQLException {
		statement.setClob(i, clob);
	}

	@Override
	public void setArray(final int i, final Array array) throws SQLException {
		statement.setArray(i, array);
	}

	@Override
	public ResultSetMetaData getMetaData() throws SQLException {
		return statement.getMetaData();
	}

	@Override
	public void setDate(final int i, final Date date, final Calendar calendar) throws SQLException {
		statement.setDate(i, date, calendar);
	}

	@Override
	public void setTime(final int i, final Time time, final Calendar calendar) throws SQLException {
		statement.setTime(i, time, calendar);
	}

	@Override
	public void setTimestamp(final int i, final Timestamp timestamp, final Calendar calendar) throws SQLException {
		statement.setTimestamp(i, timestamp, calendar);
	}

	@Override
	public void setNull(final int i, final int i1, final String s) throws SQLException {
		statement.setNull(i, i1, s);
	}

	@Override
	public void setURL(final int i, final URL url) throws SQLException {
		statement.setURL(i, url);
	}

	@Override
	public ParameterMetaData getParameterMetaData() throws SQLException {
		return statement.getParameterMetaData();
	}

	@Override
	public void setRowId(final int i, final RowId rowId) throws SQLException {
		statement.setRowId(i, rowId);
	}

	@Override
	public void setNString(final int i, final String s) throws SQLException {
		statement.setNString(i, s);
	}

	@Override
	public void setNCharacterStream(final int i, final Reader reader, final long l) throws SQLException {
		statement.setNCharacterStream(i, reader, l);
	}

	@Override
	public void setNClob(final int i, final NClob nClob) throws SQLException {
		statement.setNClob(i, nClob);
	}

	@Override
	public void setClob(final int i, final Reader reader, final long l) throws SQLException {
		statement.setClob(i, reader, l);
	}

	@Override
	public void setBlob(final int i, final InputStream inputStream, final long l) throws SQLException {
		statement.setBlob(i, inputStream, l);
	}

	@Override
	public void setNClob(final int i, final Reader reader, final long l) throws SQLException {
		statement.setNClob(i, reader, l);
	}

	@Override
	public void setSQLXML(final int i, final SQLXML sqlxml) throws SQLException {
		statement.setSQLXML(i, sqlxml);
	}

	@Override
	public void setObject(final int i, final Object o, final int i1, final int i2) throws SQLException {
		statement.setObject(i, o, i1, i2);
	}

	@Override
	public void setAsciiStream(final int i, final InputStream inputStream, final long l) throws SQLException {
		statement.setAsciiStream(i, inputStream, l);
	}

	@Override
	public void setBinaryStream(final int i, final InputStream inputStream, final long l) throws SQLException {
		statement.setBinaryStream(i, inputStream, l);
	}

	@Override
	public void setCharacterStream(final int i, final Reader reader, final long l) throws SQLException {
		statement.setCharacterStream(i, reader, l);
	}

	@Override
	public void setAsciiStream(final int i, final InputStream inputStream) throws SQLException {
		statement.setAsciiStream(i, inputStream);
	}

	@Override
	public void setBinaryStream(final int i, final InputStream inputStream) throws SQLException {
		statement.setBinaryStream(i, inputStream);
	}

	@Override
	public void setCharacterStream(final int i, final Reader reader) throws SQLException {
		statement.setCharacterStream(i, reader);
	}

	@Override
	public void setNCharacterStream(final int i, final Reader reader) throws SQLException {
		statement.setNCharacterStream(i, reader);
	}

	@Override
	public void setClob(final int i, final Reader reader) throws SQLException {
		statement.setClob(i, reader);
	}

	@Override
	public void setBlob(final int i, final InputStream inputStream) throws SQLException {
		statement.setBlob(i, inputStream);
	}

	@Override
	public void setNClob(final int i, final Reader reader) throws SQLException {
		statement.setNClob(i, reader);
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
