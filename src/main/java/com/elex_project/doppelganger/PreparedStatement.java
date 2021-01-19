/******************************************************************************
 * Project Doppelgänger                                                       *
 *                                                                            *
 * Copyright (c) 2019. Elex. All Rights Reserved.                             *
 * https://www.elex-project.com/                                              *
 ******************************************************************************/

package com.elex_project.doppelganger;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.math.BigDecimal;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;

/**
 * putXXX()는 값이 널일 경우 널을 삽입한다.
 */
public final class PreparedStatement extends BasePreparedStatementWrapper {

	public PreparedStatement(java.sql.PreparedStatement statement) {
		super(statement);
	}

	public @NotNull CompletableFuture<Integer> executeUpdate(final @NotNull ExecutorService executorService) {
		final CompletableFuture<Integer> future = new CompletableFuture<>();
		executorService.execute(() -> {
			try {
				future.complete(executeUpdate());
			} catch (SQLException e) {
				future.completeExceptionally(e);
			}
		});
		//executorService.submit(()->{});
		return future;
	}

	public @NotNull CompletableFuture<Boolean> execute(final @NotNull ExecutorService executorService) {
		final CompletableFuture<Boolean> future = new CompletableFuture<>();
		executorService.execute(() -> {
			try {
				future.complete(execute());
			} catch (SQLException e) {
				future.completeExceptionally(e);
			}
		});
		return future;
	}

	public @NotNull CompletableFuture<ResultSet> executeQuery(final @NotNull ExecutorService executorService) {
		final CompletableFuture<ResultSet> future = new CompletableFuture<>();
		executorService.execute(() -> {
			try {
				future.complete(executeQuery());
			} catch (SQLException e) {
				future.completeExceptionally(e);
			}
		});
		return future;
	}

	public @NotNull CompletableFuture<int[]> executeBatch(final @NotNull ExecutorService executorService) {
		final CompletableFuture<int[]> future = new CompletableFuture<>();
		executorService.execute(() -> {
			try {
				future.complete(executeBatch());
			} catch (SQLException e) {
				future.completeExceptionally(e);
			}
		});
		return future;
	}

	@NotNull
	@Contract(" -> new")
	public ResultSet executeQuery() throws SQLException {
		return new ResultSet(super.executeQuery());
	}

	public void setLocalDateTime(int i, LocalDateTime localDateTime) throws SQLException {
		putLocalDateTime(i, localDateTime);
	}

	public void setLocalDate(int i, LocalDate localDate) throws SQLException {
		putLocalDate(i, localDate);
	}

	public void setLocalTime(int i, LocalTime localTime) throws SQLException {
		putLocalTime(i, localTime);
	}

	public void setInetAddress(int i, @NotNull String ipAddress) throws SQLException, UnknownHostException {
		setInetAddress(i, InetAddress.getByName(ipAddress));
	}

	public void putInetAddress(int i, @Nullable String ipAddress) throws SQLException {
		try {
			if (null == ipAddress) {
				putBytes(i, null);
			} else {
				putInetAddress(i, InetAddress.getByName(ipAddress));
			}
		} catch (UnknownHostException e) {
			putBytes(i, null);
		}
	}

	public void setInetAddress(int i, @NotNull InetAddress ipAddress) throws SQLException {
		setBytes(i, ipAddress.getAddress());
	}

	public void putInetAddress(int i, @Nullable InetAddress ipAddress) throws SQLException {
		if (null == ipAddress) {
			putBytes(i, null);
		} else {
			putBytes(i, ipAddress.getAddress());
		}
	}

	public void putBoolean(int i, @Nullable Boolean b) throws SQLException {
		if (null == b) {
			statement.setNull(i, Types.BOOLEAN);
		} else {
			statement.setBoolean(i, b);
		}
	}

	public void putByte(int i, @Nullable Byte b) throws SQLException {
		if (null == b) {
			statement.setNull(i, Types.TINYINT);
		} else {
			statement.setByte(i, b);
		}
	}

	public void putShort(int i, @Nullable Short s) throws SQLException {
		if (null == s) {
			statement.setNull(i, Types.SMALLINT);
		} else {
			statement.setShort(i, s);
		}
	}

	public void putInteger(int i, @Nullable Integer i1) throws SQLException {
		if (null == i1) {
			statement.setNull(i, Types.INTEGER);
		} else {
			statement.setInt(i, i1);
		}
	}

	public void putLong(int i, @Nullable Long l) throws SQLException {
		if (null == l) {
			statement.setNull(i, Types.BIGINT);
		} else {
			statement.setLong(i, l);
		}
	}

	public void putFloat(int i, @Nullable Float v) throws SQLException {
		if (null == v) {
			statement.setNull(i, Types.FLOAT);
		} else {
			statement.setFloat(i, v);
		}
	}

	public void putDouble(int i, @Nullable Double v) throws SQLException {
		if (null == v) {
			statement.setNull(i, Types.DOUBLE);
		} else {
			statement.setDouble(i, v);
		}
	}

	//@Override
	public void putBigDecimal(int i, @Nullable BigDecimal bigDecimal) throws SQLException {
		if (null == bigDecimal) {
			statement.setNull(i, Types.BIGINT);
		} else {
			statement.setBigDecimal(i, bigDecimal);
		}
	}

	//@Override
	public void putString(int i, @Nullable String s) throws SQLException {
		if (null == s) {
			statement.setNull(i, Types.VARCHAR);
		} else {
			statement.setString(i, s);
		}
	}

	//@Override
	public void putBytes(int i, @Nullable byte[] bytes) throws SQLException {
		if (null == bytes) {
			statement.setNull(i, Types.VARBINARY);
		} else {
			statement.setBytes(i, bytes);
		}
	}

	public void putLocalDate(int i, @Nullable LocalDate date) throws SQLException {
		if (null == date) {
			statement.setNull(i, Types.DATE);
		} else {
			statement.setDate(i, Date.valueOf(date));
		}
	}

	public void putLocalTime(int i, @Nullable LocalTime time) throws SQLException {
		if (null == time) {
			statement.setNull(i, Types.TIME);
		} else {
			statement.setTime(i, Time.valueOf(time));
		}
	}

	public void putLocalDateTime(int i, @Nullable LocalDateTime dateTime) throws SQLException {
		if (null == dateTime) {
			statement.setNull(i, Types.TIMESTAMP);
		} else {
			statement.setTimestamp(i, Timestamp.valueOf(dateTime));
		}
	}

	public <T extends Enum<?>> void putEnum(int idx, @Nullable T val) throws SQLException {
		if (null == val) {
			statement.setNull(idx, Types.VARCHAR);
		} else {
			statement.setString(idx, val.name());
		}
	}

}
