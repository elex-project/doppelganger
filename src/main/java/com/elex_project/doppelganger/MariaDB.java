/******************************************************************************
 * Project Doppelgänger                                                       *
 *                                                                            *
 * Copyright (c) 2020. Elex. All Rights Reserved.                             *
 * https://www.elex-project.com/                                              *
 ******************************************************************************/

package com.elex_project.doppelganger;

import java.sql.SQLException;

public final class MariaDB extends BaseDatabase {

	public static abstract class BaseBuilder<T extends BaseDatabase> extends AbsBuilder<T> {
		protected int port = 3306;
		protected String address, db, user, password;

		protected BaseBuilder() {
			super();
		}

		public BaseBuilder<T> port(int port) {
			this.port = port;
			return this;
		}

		public BaseBuilder<T> address(String address) {
			this.address = address;
			return this;
		}

		public BaseBuilder<T> dbName(String dbName) {
			this.db = dbName;
			return this;
		}

		public BaseBuilder<T> userName(String user) {
			this.user = user;
			return this;
		}

		public BaseBuilder<T> password(String password) {
			this.password = password;
			return this;
		}

	}

	public static class Builder extends BaseBuilder<MariaDB> {
		@Override
		protected String getConnectionString() {
			return getConnectionStringMariaDB(address, port, db, user, password);
		}
		@Override
		public MariaDB build() throws SQLException {
			return new MariaDB(getConnectionString());
		}

	}

	public MariaDB(String connStr) throws SQLException {
		super(connStr);
	}

}
