/******************************************************************************
 * Project Doppelgänger                                                       *
 *                                                                            *
 * Copyright (c) 2020. Elex. All Rights Reserved.                             *
 * https://www.elex-project.com/                                              *
 ******************************************************************************/

package com.elex_project.doppelganger;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.sql.SQLException;

/**
 * Moved from Core-Utils @ 2019/05/04
 */
abstract class AbsBuilder<T extends BaseDatabase> {
	@NotNull
	@Contract(" -> new")
	public static JavaDB.Builder javadb() {
		return new JavaDB.Builder();
	}
	@NotNull
	public static JavaDB.Builder derby() {
		return javadb();
	}
	@NotNull
	public static H2DB.Builder h2db() {
		return new H2DB.Builder();
	}
	@NotNull
	@Contract(" -> new")
	public static MariaDB.Builder mariadb() {
		return new MariaDB.Builder();
	}

	@NotNull
	@Contract(" -> new")
	public static MySqlDB.Builder mysql() {
		return new MySqlDB.Builder();
	}

	@NotNull
	@Contract(" -> new")
	public static SQLiteDB.Builder sqlite() {
		return new SQLiteDB.Builder();
	}

	/**
	 * MariaDB
	 * https://mariadb.com/kb/en/mariadb/about-mariadb-connector-j/
	 *
	 * @param address  주소
	 * @param port     3306
	 * @param dbName   데이터베이스
	 * @param user     사용자
	 * @param password 비번
	 * @return 연결문자열
	 */
	@NotNull
	@Contract(pure = true)
	static String getConnectionStringMariaDB(String address, int port, String dbName, String user, String password) {
		return "jdbc:mariadb://" + address + ":" + port + "/" + dbName + "?user=" + user + "&password=" + password;
	}

	@NotNull
	@Contract(pure = true)
	static String getConnectionStringMariaDB(String address, String dbName, String user, String password) {
		return getConnectionStringMariaDB(address, 3306, dbName, user, password);
	}

	/**
	 * MySQL
	 * https://dev.mysql.com/downloads/connector/j/
	 *
	 * @param address  주소
	 * @param port     포트
	 * @param dbName   데이터베이스
	 * @param user     사용자
	 * @param password 비번
	 * @return 연결문자열
	 */
	@NotNull
	@Contract(pure = true)
	static String getConnectionStringMySql(String address, int port, String dbName, String user, String password) {
		return "jdbc:mysql://" + address + ":" + port + "/" + dbName + "?user=" + user + "&password=" + password;
	}

	@NotNull
	@Contract(pure = true)
	static String getConnectionStringMySql(String address, String dbName, String user, String password) {
		return getConnectionStringMySql(address, 3306, dbName, user, password);
	}

	/**
	 * SQLite
	 * https://bitbucket.org/xerial/sqlite-jdbc
	 *
	 * @param file 파일
	 * @return 연결문자열
	 */
	@NotNull
	@Contract(pure = true)
	static String getConnectionStringSqlite(String file) {
		if (null == file) return getConnectionStringSqlite();
		return "jdbc:sqlite:" + file;
	}

	@NotNull
	@Contract(pure = true)
	public static String getConnectionStringSqlite() {
		return "jdbc:sqlite::memory:";
	}

	/**
	 * 자바 DB
	 *
	 * @param file 파일
	 * @return 연결문자열
	 */
	@NotNull
	@Contract(pure = true)
	static String getConnectionStringJavaDB(String file) {
		return "jdbc:derby:" + file + ";create=true";
	}
	@NotNull
	static String getConnectionStringH2DB(String file) {
		return "jdbc:h2:" + file ;
	}
	protected abstract String getConnectionString();

	public abstract T build() throws SQLException;
	//public Connection getConnection() throws SQLException {
	//	return DriverManager.getConnection(getConnectionString());
	//}

}
