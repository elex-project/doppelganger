/******************************************************************************
 * Project Doppelgänger                                                       *
 *                                                                            *
 * Copyright (c) 2020. Elex. All Rights Reserved.                             *
 * https://www.elex-project.com/                                              *
 ******************************************************************************/

package com.elex_project.doppelganger;


import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeAll;

import java.sql.SQLException;

@Slf4j
public class ConnectionPoolTest {
	private static ConnectionPool<MariaDB> pool;

	@BeforeAll
	static void setUp() throws Exception {
		pool = new ConnectionPool<>();
		pool.add(new ConnectionPool.ConnectionAdapter<MariaDB>() {
			@Override
			public MariaDB createConnection() throws SQLException {
				return new MariaDB.Builder()
						.address("localhost").port(3306).dbName("test")
						.userName("test").password("test").build();
			}
		});
		pool.add(new ConnectionPool.ConnectionAdapter<MariaDB>() {
			@Override
			public MariaDB createConnection() throws SQLException {
				return new MariaDB.Builder()
						.address("localhost").port(3306).dbName("test")
						.userName("test").password("test").build();
			}
		});
	}

	//@Test //@Disables
	void test() throws SQLException {
		PreparedStatement stmt =
				pool.getNext().prepareStatement("INSERT INTO table1 (uid, name, some) VALUES (?,?,?);");
		stmt.putInteger(1, null);
		stmt.setString(2, "boku");
		stmt.putEnum(3, DBResultSetTest.Some.N);
		int s = stmt.executeUpdate();
		log.info("-> {}", s);

		PreparedStatement statement = pool.getNext().prepareStatement("SELECT * FROM table1");
		ResultSet resultSet = statement.executeQuery();

		while (resultSet.next()) {
			Integer idx = resultSet.optInteger("uid");
			String name = resultSet.optString("name");
			DBResultSetTest.Some some = resultSet.optEnum(3, DBResultSetTest.Some.class);
			log.info("=> {}, {}, {}", idx, name, some);
		}
		resultSet.close();

		stmt =
				pool.getNext().prepareStatement("INSERT INTO table1 (uid, name, some) VALUES (?,?,?);");
		stmt.putInteger(1, null);
		stmt.setString(2, "boku");
		stmt.putEnum(3, DBResultSetTest.Some.N);
		s = stmt.executeUpdate();
		log.info("-> {}", s);
	}
}
