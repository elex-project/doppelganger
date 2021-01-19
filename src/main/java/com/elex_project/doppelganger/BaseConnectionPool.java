/******************************************************************************
 * Project Doppelgänger                                                       *
 *                                                                            *
 * Copyright (c) 2020. Elex. All Rights Reserved.                             *
 * https://www.elex-project.com/                                              *
 ******************************************************************************/

package com.elex_project.doppelganger;

import java.sql.SQLException;

abstract class BaseConnectionPool<T extends Database> {
	/**
	 * 데이터베이스와 생성 메서드를 함께 묶어 관리함
	 * @param <T>
	 */
	protected static class ConnectionHolder<T extends Database> {
		protected T database = null;
		protected final ConnectionAdapter<T> adapter;

		protected ConnectionHolder(final ConnectionAdapter<T> adapter) {

			this.adapter = adapter;
			//.database = null;
		}
		protected void close() throws SQLException {
			if (null!=database) database.close();
		}
	}

	/**
	 * 데이터베이스 연결 생성 메서드
	 * @param <T>
	 */
	public interface ConnectionAdapter<T extends Database> {
		public T createConnection() throws SQLException;
	}
}
