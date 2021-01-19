/******************************************************************************
 * Project Doppelgänger                                                       *
 *                                                                            *
 * Copyright (c) 2019. Elex. All Rights Reserved.                             *
 * https://www.elex-project.com/                                              *
 ******************************************************************************/

package com.elex_project.doppelganger;

import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class DBResultSetTest {
	private static MariaDB mariaDB;

	@BeforeAll
	static void setUp() throws Exception {

		mariaDB = new MariaDB.Builder()
				.address("localhost").port(3306).dbName("test")
				.userName("test").password("test").build();
	}

	@Test
	@Disabled
	public void write() throws SQLException {
		PreparedStatement stmt =
				mariaDB.prepareStatement("INSERT INTO table1 (uid, name, some) VALUES (?,?,?);");
		stmt.putInteger(1, null);
		stmt.setString(2, "boku");
		stmt.putEnum(3, Some.N);
		int s = stmt.executeUpdate();
		log.info("-> {}", s);
	}

	@Test
	@Disabled
	public void read() throws SQLException {
		PreparedStatement statement = mariaDB.prepareStatement("SELECT * FROM table1");
		ResultSet resultSet = statement.executeQuery();

		while (resultSet.next()) {
			Integer idx = resultSet.optInteger("uid");
			String name = resultSet.optString("name");
			Some some = resultSet.optEnum(3, Some.class);
			log.info("=> {}, {}, {}", idx, name, some);
		}
		resultSet.close();
		mariaDB.close();
	}

	@Test
	@Disabled
	public void readAsync() throws SQLException {
		ExecutorService executorService = Executors.newSingleThreadExecutor();
		PreparedStatement statement = mariaDB.prepareStatement("SELECT * FROM table1");

		CompletableFuture<ResultSet> future = statement.executeQuery(executorService);

		future.exceptionally((e) -> {
			//e.printStackTrace();
			return null;
		})
				.thenAccept((resultSet) -> {

					try {
						if (null == resultSet) throw new SQLException();

						while (resultSet.next()) {
							Integer idx = resultSet.optInteger("uid");
							String name = resultSet.optString("name");
							Some some = resultSet.optEnum(3, Some.class);
							log.info("=> {}, {}, {}", idx, name, some);
						}

					} catch (SQLException e) {
						e.printStackTrace();
					} finally {
						try {
							if (null != resultSet) resultSet.close();
						} catch (SQLException e) {
							e.printStackTrace();
						}
						mariaDB.close();
						executorService.shutdown();
					}
				});
		//ResultSet resultSet = null;


	}

	enum Some {
		Y, N;
	}

	//@Test
	public void iterate() throws SQLException {
		//DBStatement statement = new DBStatement(connection, "SELECT * FROM table1");
		//DBResultSet resultSet = statement.query();
		//PreparedStatementWrapper statement = new PreparedStatementWrapper(connection.prepareStatement("SELECT * FROM table1"));
		PreparedStatement statement = mariaDB.prepareStatement("SELECT * FROM table1");

		ResultSet resultSet = statement.executeQuery();
		resultSet.iterate(new ResultSet.Iterator() {
			@Override
			public void beforeFirst(@NotNull ResultSet resultSet) {
				log.info("before first");
			}

			@Override
			public void onEach(@NotNull ResultSet resultSet) {
				Integer idx = resultSet.optInteger("uid");
				String name = resultSet.optString("name");
				log.info("idx= {}, name= {}", idx, name);

			}

			@Override
			public void afterLast(@NotNull ResultSet resultSet) {
				log.info("after last");
				try {
					resultSet.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});
	}
}
