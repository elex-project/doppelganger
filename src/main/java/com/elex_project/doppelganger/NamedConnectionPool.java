/******************************************************************************
 * Project Doppelgänger                                                       *
 *                                                                            *
 * Copyright (c) 2020. Elex. All Rights Reserved.                             *
 * https://www.elex-project.com/                                              *
 ******************************************************************************/

package com.elex_project.doppelganger;

import java.sql.SQLException;
import java.util.HashMap;

/**
 * 몇 개의 데이터베이스 연결을 저장해두고 이름으로 호출해서 사용한다.
 * @param <T>
 */
public final class NamedConnectionPool<T extends Database> extends BaseConnectionPool<T>{

	private final int checkSec;
	private final HashMap<String, ConnectionHolder<T>> pool;

	public NamedConnectionPool() {
		this(5);
	}
	public NamedConnectionPool(int checkSec) {
		this.pool = new HashMap<>();
		this.checkSec = checkSec;
	}

	/**
	 * 끊겼을 경우 재 연결을 위해, 데이터베이스 연결을 생성할 메서드가 필요하다.
	 * @param adapter 데이터베이스 연결 메서드
	 */
	public void add(final String name, ConnectionPool.ConnectionAdapter<T> adapter) {
		this.pool.put(name, new ConnectionHolder<T>(adapter));
	}

	/**
	 * 다음 커넥션을 반환한다. 연결이 끊겼다거나 등등의 경우 다시 연결을 시도한 후에 반환한다.
	 * @return 데이터베이스 커넥션
	 * @throws SQLException
	 */
	public T get(final String name) throws SQLException {
		final ConnectionHolder<T> holder = pool.get(name);
		if (null==holder) throw new SQLException("No Connection found with that name; " + name);

		T database = holder.database;
		if (null == database) {
			database = holder.adapter.createConnection();

		} else if (database.isClosed() || !database.isValid(checkSec)) {
			try {
				holder.database.close();
			} catch (SQLException ignore) {
			}
			holder.database = holder.adapter.createConnection();
		}

		return database;
	}

	/**
	 * 모든 데이터베이스 연결을 종료시킨다.
	 */
	public void close(){
		for (String name : pool.keySet()){
			try {
				ConnectionHolder<T> conn = pool.get(name);
				if (null!=conn) {
					conn.close();
				}
			} catch (SQLException ignore) {
			}
		}
		pool.clear();
	}


}
