/******************************************************************************
 * Project Doppelgänger                                                       *
 *                                                                            *
 * Copyright (c) 2019. Elex. All Rights Reserved.                             *
 * https://www.elex-project.com/                                              *
 ******************************************************************************/

package com.elex_project.doppelganger;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * getXXX() 계열은 null 등의 경우, 예외를 발생시킨다.
 * optXXX() 계열의 메서드는 DB의 값이 널일 경우 null을 반환한다.
 * optXXX(x, def) 계열의 메서드는 DB의 값이 널이거나 SQLException이 발생한 경우에 def 값을 반환한다.
 */
public final class ResultSet extends BaseResultSetWrapper {

	public ResultSet(java.sql.ResultSet resultSet) {
		super(resultSet);
	}

	public LocalDateTime getLocalDateTime(int i){
		return optLocalDateTime(i);
	}
	public LocalDateTime getLocalDateTime(String i){
		return optLocalDateTime(i);
	}
	public LocalDate getLocalDate(int i){
		return optLocalDate(i);
	}
	public LocalDate getLocalDate(String i){
		return optLocalDate(i);
	}
	public LocalTime getLocalTime(int i){
		return optLocalTime(i);
	}
	public LocalTime getLocalTime(String i){
		return optLocalTime(i);
	}

	public @NotNull InetAddress getInetAddress(int i) throws UnknownHostException {
		return InetAddress.getByAddress(optBytes(i));
	}
	public @NotNull InetAddress getInetAddress(String i) throws UnknownHostException {
		return InetAddress.getByAddress(optBytes(i));
	}
	public @Nullable InetAddress optInetAddress(int i) {
		try {
			return InetAddress.getByAddress(optBytes(i));
		} catch (Throwable e) {
			return null;
		}
	}
	public @Nullable InetAddress optInetAddress(String i) {
		try {
			return InetAddress.getByAddress(optBytes(i));
		} catch (Throwable e) {
			return null;
		}
	}

	@Nullable
	public String optString(int i) {
		try {
			try {
				return opt(i, String.class);
			} catch (SQLFeatureNotSupportedException e) {
			/*String v = resultSet.getString(i);
			return resultSet.wasNull() ? null : v;*/
				return resultSet.getString(i);
			}
		} catch (SQLException e) {
			return null;
		}
	}

	@NotNull
	public String optString(int i, @NotNull String def) {
		try {
			try {
				return opt(i, def, String.class);
			} catch (SQLFeatureNotSupportedException e) {
				String v = resultSet.getString(i);
				return resultSet.wasNull() ? def : v;
				//return resultSet.getString(i);
			}
		} catch (SQLException e) {
			return def;
		}
	}

	@Nullable
	public Boolean optBoolean(int i) {
		try {
			try {
				return opt(i, Boolean.class);
			} catch (SQLFeatureNotSupportedException e) {
				boolean v = resultSet.getBoolean(i);
				return resultSet.wasNull() ? null : v;
			}
		} catch (SQLException e) {
			return null;
		}
	}

	@NotNull
	public Boolean optBoolean(int i, boolean def) {
		try {
			try {
				return opt(i, def, Boolean.class);
			} catch (SQLFeatureNotSupportedException e) {
				boolean v = resultSet.getBoolean(i);
				return resultSet.wasNull() ? def : v;
			}
		} catch (SQLException e) {
			return def;
		}
	}

	@Nullable
	public Byte optByte(int i) {
		try {
			try {
				return opt(i, Byte.class);
			} catch (SQLFeatureNotSupportedException e) {
				byte v = resultSet.getByte(i);
				return resultSet.wasNull() ? null : v;
			}
		} catch (SQLException e) {
			return null;
		}
	}

	@NotNull
	public Byte optByte(int i, byte def) {
		try {
			try {
				return opt(i, def, Byte.class);
			} catch (SQLFeatureNotSupportedException e) {
				byte v = resultSet.getByte(i);
				return resultSet.wasNull() ? def : v;
			}
		} catch (SQLException e) {
			return def;
		}
	}

	@Nullable
	public Short optShort(int i) {
		try {
			try {
				return opt(i, Short.class);
			} catch (SQLFeatureNotSupportedException e) {
				short v = resultSet.getShort(i);
				return resultSet.wasNull() ? null : v;
			}
		} catch (SQLException e) {
			return null;
		}
	}

	@NotNull
	public Short optShort(int i, short def) {
		try {
			try {
				return opt(i, def, Short.class);
			} catch (SQLFeatureNotSupportedException e) {
				short v = resultSet.getShort(i);
				return resultSet.wasNull() ? def : v;
			}
		} catch (SQLException e) {
			return def;
		}
	}

	@Nullable
	public Integer optInteger(int i) {
		try {
			try {
				return opt(i, Integer.class);
			} catch (SQLFeatureNotSupportedException e) {
				int v = resultSet.getInt(i);
				return resultSet.wasNull() ? null : v;
			}
		} catch (SQLException e) {
			return null;
		}

	}

	@NotNull
	public Integer optInteger(int i, int def) {
		try {
			try {
				return opt(i, def, Integer.class);
			} catch (SQLFeatureNotSupportedException e) {
				int v = resultSet.getInt(i);
				return resultSet.wasNull() ? def : v;
			}
		} catch (SQLException e) {
			return def;
		}

	}

	@Nullable
	public Long optLong(int i) {
		try {
			try {
				return opt(i, Long.class);
			} catch (SQLFeatureNotSupportedException e) {
				long v = resultSet.getLong(i);
				return resultSet.wasNull() ? null : v;
			}
		} catch (SQLException e) {
			return null;
		}

	}

	@NotNull
	public Long optLong(int i, long def) {
		try {
			try {
				return opt(i, def, Long.class);
			} catch (SQLFeatureNotSupportedException e) {
				long v = resultSet.getLong(i);
				return resultSet.wasNull() ? def : v;
			}
		} catch (SQLException e) {
			return def;
		}

	}

	@Nullable
	public Float optFloat(int i) {
		try {
			try {
				return opt(i, Float.class);
			} catch (SQLFeatureNotSupportedException e) {
				float v = resultSet.getFloat(i);
				return resultSet.wasNull() ? null : v;
			}
		} catch (SQLException e) {
			return null;
		}

	}

	@NotNull
	public Float optFloat(int i, float def) {
		try {
			try {
				return opt(i, def, Float.class);
			} catch (SQLFeatureNotSupportedException e) {
				float v = resultSet.getFloat(i);
				return resultSet.wasNull() ? def : v;
			}
		} catch (SQLException e) {
			return def;
		}

	}

	@Nullable
	public Double optDouble(int i) {
		try {
			try {
				return opt(i, Double.class);
			} catch (SQLFeatureNotSupportedException e) {
				double v = resultSet.getDouble(i);
				return resultSet.wasNull() ? null : v;
			}
		} catch (SQLException e) {
			return null;
		}

	}

	@NotNull
	public Double optDouble(int i, double def) {
		try {
			try {
				return opt(i, def, Double.class);
			} catch (SQLFeatureNotSupportedException e) {
				double v = resultSet.getDouble(i);
				return resultSet.wasNull() ? def : v;
			}
		} catch (SQLException e) {
			return def;
		}

	}

	@Nullable
	public byte[] optBytes(int i) {
		/*byte[] v = resultSet.getBytes(i);
		return resultSet.wasNull() ? null : v;*/
		try {
			return resultSet.getBytes(i);
		} catch (SQLException e) {
			return null;
		}
	}

	@NotNull
	public byte[] optBytes(int i, @NotNull byte[] def) {
		try {
			byte[] v = resultSet.getBytes(i);
			return resultSet.wasNull() ? def : v;
			//return resultSet.getBytes(i);
		} catch (SQLException e) {
			return def;
		}
	}

	@Nullable
	public LocalDate optLocalDate(int i) {
		try {
			try {
				return opt(i, LocalDate.class);
			} catch (SQLFeatureNotSupportedException e) {
			/*Date v = resultSet.getDate(i);
			return resultSet.wasNull() ? null : v.toLocalDate();*/
				return resultSet.getDate(i).toLocalDate();
			}
		} catch (SQLException e) {
			return null;
		}
	}

	@NotNull
	public LocalDate optLocalDate(int i, @NotNull LocalDate def) {
		try {
			try {
				return opt(i, def, LocalDate.class);
			} catch (SQLFeatureNotSupportedException e) {
				Date v = resultSet.getDate(i);
				return resultSet.wasNull() ? def : v.toLocalDate();
				//return resultSet.getDate(i).toLocalDate();
			}
		} catch (SQLException e) {
			return def;
		}
	}

	@Nullable
	public LocalTime optLocalTime(int i) {
		try {
			try {
				return opt(i, LocalTime.class);
			} catch (SQLFeatureNotSupportedException e) {
			/*Time v = resultSet.getTime(i);
			return resultSet.wasNull() ? null : v.toLocalTime();*/
				return resultSet.getTime(i).toLocalTime();
			}
		} catch (SQLException e) {
			return null;
		}

	}

	@NotNull
	public LocalTime optLocalTime(int i, @NotNull LocalTime def) {
		try {
			try {
				return opt(i, def, LocalTime.class);
			} catch (SQLFeatureNotSupportedException e) {
				Time v = resultSet.getTime(i);
				return resultSet.wasNull() ? def : v.toLocalTime();
				//return resultSet.getTime(i).toLocalTime();
			}
		} catch (SQLException e) {
			return def;
		}

	}

	@Nullable
	public LocalDateTime optLocalDateTime(int i) {
		try {
			try {
				return opt(i, LocalDateTime.class);
			} catch (SQLFeatureNotSupportedException e) {
			/*Timestamp v = resultSet.getTimestamp(i);
			return resultSet.wasNull() ? null : v.toLocalDateTime();*/
				return resultSet.getTimestamp(i).toLocalDateTime();
			}
		} catch (SQLException e) {
			return null;
		}

	}

	@NotNull
	public LocalDateTime optLocalDateTime(int i, @NotNull LocalDateTime def) {
		try {
			try {
				return opt(i, def, LocalDateTime.class);
			} catch (SQLFeatureNotSupportedException e) {
				Timestamp v = resultSet.getTimestamp(i);
				return resultSet.wasNull() ? def : v.toLocalDateTime();
				//return resultSet.getTimestamp(i).toLocalDateTime();
			}
		} catch (SQLException e) {
			return def;
		}

	}

	@Nullable
	public String optString(@NotNull String s) {
		try {
			try {
				return opt(s, String.class);
			} catch (SQLFeatureNotSupportedException e) {
			/*String v = resultSet.getString(s);
			return resultSet.wasNull() ? null : v;*/
				return resultSet.getString(s);
			}
		} catch (SQLException e) {
			return null;
		}

	}

	@NotNull
	public String optString(@NotNull String s, @NotNull String def) {
		try {
			try {
				return opt(s, def, String.class);
			} catch (SQLFeatureNotSupportedException e) {
				String v = resultSet.getString(s);
				return resultSet.wasNull() ? def : v;
				//return resultSet.getString(s);
			}
		} catch (SQLException e) {
			return def;
		}

	}

	@Nullable
	public Boolean optBoolean(@NotNull String s) {
		try {
			try {
				return opt(s, Boolean.class);
			} catch (SQLFeatureNotSupportedException e) {
				boolean v = resultSet.getBoolean(s);
				return resultSet.wasNull() ? null : v;
			}
		} catch (SQLException e) {
			return null;
		}

	}

	@NotNull
	public Boolean optBoolean(@NotNull String s, boolean def) {
		try {
			try {
				return opt(s, def, Boolean.class);
			} catch (SQLFeatureNotSupportedException e) {
				boolean v = resultSet.getBoolean(s);
				return resultSet.wasNull() ? def : v;
			}
		} catch (SQLException e) {
			return def;
		}

	}

	@Nullable
	public Byte optByte(@NotNull String s) {
		try {
			try {
				return opt(s, Byte.class);
			} catch (SQLFeatureNotSupportedException e) {
				byte v = resultSet.getByte(s);
				return resultSet.wasNull() ? null : v;
			}
		} catch (SQLException e) {
			return null;
		}
	}

	@NotNull
	public Byte optByte(@NotNull String s, byte def) {
		try {
			try {
				return opt(s, def, Byte.class);
			} catch (SQLFeatureNotSupportedException e) {
				byte v = resultSet.getByte(s);
				return resultSet.wasNull() ? def : v;
			}
		} catch (SQLException e) {
			return def;
		}

	}

	@Nullable
	public Short optShort(@NotNull String s) {
		try {
			try {
				return opt(s, Short.class);
			} catch (SQLFeatureNotSupportedException e) {
				short v = resultSet.getShort(s);
				return resultSet.wasNull() ? null : v;
			}
		} catch (SQLException e) {
			return null;
		}

	}

	@NotNull
	public Short optShort(@NotNull String s, short def) {
		try {
			try {
				return opt(s, def, Short.class);
			} catch (SQLFeatureNotSupportedException e) {
				short v = resultSet.getShort(s);
				return resultSet.wasNull() ? def : v;
			}
		} catch (SQLException e) {
			return def;
		}

	}

	@Nullable
	public Integer optInteger(@NotNull String s) {
		try {
			try {
				return opt(s, Integer.class);
			} catch (SQLFeatureNotSupportedException e) {
				int v = resultSet.getInt(s);
				return resultSet.wasNull() ? null : v;
			}
		}  catch (SQLException e) {
			return null;
		}

	}

	@NotNull
	public Integer optInteger(@NotNull String s, int def) {
		try {
			try {
				return opt(s, def, Integer.class);
			} catch (SQLFeatureNotSupportedException e) {
				int v = resultSet.getInt(s);
				return resultSet.wasNull() ? def : v;
			}
		} catch (SQLException e) {
			return def;
		}

	}

	@Nullable
	public Long optLong(@NotNull String s) {
		try {
			try {
				return opt(s, Long.class);
			} catch (SQLFeatureNotSupportedException e) {
				long v = resultSet.getLong(s);
				return resultSet.wasNull() ? null : v;
			}
		} catch (SQLException e) {
			return null;
		}

	}

	@NotNull
	public Long optLong(@NotNull String s, long def) {
		try {
			try {
				return opt(s, def, Long.class);
			} catch (SQLFeatureNotSupportedException e) {
				long v = resultSet.getLong(s);
				return resultSet.wasNull() ? def : v;
			}
		} catch (SQLException e) {
			return def;
		}

	}

	@Nullable
	public Float optFloat(@NotNull String s) {
		try {
			try {
				return opt(s, Float.class);
			} catch (SQLFeatureNotSupportedException e) {
				float v = resultSet.getFloat(s);
				return resultSet.wasNull() ? null : v;
			}
		} catch (SQLException e) {
			return null;
		}
	}

	@NotNull
	public Float optFloat(@NotNull String s, float def) {
		try {
			try {
				return opt(s, def, Float.class);
			} catch (SQLFeatureNotSupportedException e) {
				float v = resultSet.getFloat(s);
				return resultSet.wasNull() ? def : v;
			}
		} catch (SQLException e) {
			return def;
		}

	}

	@Nullable
	public Double optDouble(@NotNull String s) {
		try {
			try {
				return opt(s, Double.class);
			} catch (SQLFeatureNotSupportedException e) {
				double v = resultSet.getDouble(s);
				return resultSet.wasNull() ? null : v;
			}
		} catch (SQLException e) {
			return null;
		}

	}

	@NotNull
	public Double optDouble(@NotNull String s, double def) {
		try {
			try {
				return opt(s, def, Double.class);
			} catch (SQLFeatureNotSupportedException e) {
				double v = resultSet.getDouble(s);
				return resultSet.wasNull() ? def : v;
			}
		} catch (SQLException e) {
			return def;
		}

	}

	@Nullable
	public byte[] optBytes(@NotNull String s) {
		try {
		/*byte[] v = resultSet.getBytes(s);
		return resultSet.wasNull() ? null : v;*/
			return resultSet.getBytes(s);
		}  catch (SQLException e) {
			return null;
		}
	}

	@NotNull
	public byte[] optBytes(@NotNull String s, @NotNull byte[] def) {
		try {
			byte[] v = resultSet.getBytes(s);
			return resultSet.wasNull() ? def : v;
			//return resultSet.getBytes(s);
		} catch (SQLException e) {
			return def;
		}
	}

	@Nullable
	public LocalDate optLocalDate(@NotNull String s) {
		try {
			try {
				return opt(s, LocalDate.class);
			} catch (SQLFeatureNotSupportedException e) {
			/*Date v = resultSet.getDate(s);
			return resultSet.wasNull() ? null : v.toLocalDate();*/
				return resultSet.getDate(s).toLocalDate();
			}
		}  catch (SQLException e) {
			return null;
		}

	}

	@NotNull
	public LocalDate optLocalDate(@NotNull String s, @NotNull LocalDate def) {
		try {
			try {
				return opt(s, def, LocalDate.class);
			} catch (SQLFeatureNotSupportedException e) {
				Date v = resultSet.getDate(s);
				return resultSet.wasNull() ? def : v.toLocalDate();
				//return resultSet.getDate(s).toLocalDate();
			}
		} catch (SQLException e) {
			return def;
		}

	}

	@Nullable
	public LocalTime optLocalTime(@NotNull String s) {
		try {
			try {
				return opt(s, LocalTime.class);
			} catch (SQLFeatureNotSupportedException e) {
			/*Time v = resultSet.getTime(s);
			return resultSet.wasNull() ? null : v.toLocalTime();*/
				return resultSet.getTime(s).toLocalTime();
			}
		} catch (SQLException e) {
			return null;
		}
	}

	@NotNull
	public LocalTime optLocalTime(@NotNull String s, @NotNull LocalTime def) {
		try {
			try {
				return opt(s, def, LocalTime.class);
			} catch (SQLFeatureNotSupportedException e) {
				Time v = resultSet.getTime(s);
				return resultSet.wasNull() ? def : v.toLocalTime();
				//return resultSet.getTime(s).toLocalTime();
			}
		} catch (SQLException e) {
			return def;
		}

	}

	@Nullable
	public LocalDateTime optLocalDateTime(@NotNull String s)  {
		try {
			try {
				return opt(s, LocalDateTime.class);
			} catch (SQLFeatureNotSupportedException e) {
			/*Timestamp v = resultSet.getTimestamp(s);
			return resultSet.wasNull() ? null : v.toLocalDateTime();*/
				return resultSet.getTimestamp(s).toLocalDateTime();
			}
		} catch (SQLException e) {
			return null;
		}

	}

	@NotNull
	public LocalDateTime optLocalDateTime(@NotNull String s, @NotNull LocalDateTime def) {
		try {
			try {
				return opt(s, def, LocalDateTime.class);
			} catch (SQLFeatureNotSupportedException e) {
				Timestamp v = resultSet.getTimestamp(s);
				return resultSet.wasNull() ? def : v.toLocalDateTime();
				//return resultSet.getTimestamp(s).toLocalDateTime();
			}
		} catch (SQLException e) {
			return def;
		}

	}

	@Nullable
	public <T extends Enum> T optEnum(@NotNull String colName, Class<T> type) {
		try {
			try {
				return opt(colName, type);
			} catch (SQLFeatureNotSupportedException e) {
				String val = resultSet.getString(colName);
				return resultSet.wasNull() ? null : (T) T.valueOf(type, val);
			}
		} catch (SQLException e) {
			return null;
		}

	}

	@NotNull
	public <T extends Enum> T optEnum(@NotNull String colName, @NotNull T def, Class<T> type) {
		try {
			try {
				return opt(colName, def, type);
			} catch (SQLFeatureNotSupportedException e) {
				String val = resultSet.getString(colName);
				return resultSet.wasNull() ? def : (T) T.valueOf(type, val);
			}
		} catch (SQLException e) {
			return def;
		}

	}

	@Nullable
	public <T extends Enum> T optEnum(int colIdx, Class<T> type) {
		try {
			try {
				return opt(colIdx, type);
			} catch (SQLFeatureNotSupportedException e) {
				String val = resultSet.getString(colIdx);
				return resultSet.wasNull() ? null : (T) T.valueOf(type, val);
			}
		} catch (SQLException e) {
			return null;
		}

	}

	public <T extends Enum> T optEnum(int colIdx, T def, Class<T> type) {
		try {
			try {
				return opt(colIdx, def, type);
			} catch (SQLFeatureNotSupportedException e) {
				String val = resultSet.getString(colIdx);
				return resultSet.wasNull() ? def : (T) T.valueOf(type, val);
			}
		} catch (SQLException e) {
			return def;
		}

	}

	@Nullable
	private  <T> T opt(@NotNull String colName, Class<? extends T> type)
			throws SQLException, SQLFeatureNotSupportedException {
		return resultSet.getObject(colName, type);
	}

	@NotNull
	private <T> T opt(@NotNull String colName, @NotNull T def, Class<? extends T> type)
			throws SQLFeatureNotSupportedException {
		try {
			T v = resultSet.getObject(colName, type);
			return null == v ? def : v;
		} catch (SQLException e) {
			return def;
		}
	}

	@Nullable
	private <T> T opt(int colIdx, Class<? extends T> type)
			throws SQLException, SQLFeatureNotSupportedException {
		return resultSet.getObject(colIdx, type);
	}

	@NotNull
	private <T> T opt(int colIdx, @NotNull T def, Class<? extends T> type)
			throws SQLFeatureNotSupportedException {
		try {
			T v = resultSet.getObject(colIdx, type);
			return null == v ? def : v;
		} catch (SQLException e) {
			return def;
		}
	}

	/**
	 * ResultSet Iterator
	 *
	 * @param iterator
	 * @throws SQLException
	 */
	public void iterate(@NotNull ResultSet.Iterator iterator) throws SQLException {
		while (this.next()) {
			if (resultSet.isFirst()) {
				iterator.beforeFirst(this);
			}

			iterator.onEach(this);
		}
		iterator.afterLast(this);
	}

	/**
	 * ResultSet Iterator
	 */
	public interface Iterator {
		public void beforeFirst(@NotNull ResultSet resultSet);

		public void onEach(@NotNull ResultSet resultSet);

		public void afterLast(@NotNull ResultSet resultSet);
	}
}
