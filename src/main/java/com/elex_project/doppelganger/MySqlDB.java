/******************************************************************************
 * Project Doppelgänger                                                       *
 *                                                                            *
 * Copyright (c) 2020. Elex. All Rights Reserved.                             *
 * https://www.elex-project.com/                                              *
 ******************************************************************************/

package com.elex_project.doppelganger;

import java.sql.SQLException;

public final class MySqlDB extends BaseDatabase {
	public static final class Builder extends MariaDB.BaseBuilder<MySqlDB> {
		public Builder() {
			super();
		}

		@Override
		protected String getConnectionString() {
			return getConnectionStringMySql(address, port, db, user, password);
		}

		@Override
		public MySqlDB build() throws SQLException {
			return new MySqlDB(getConnectionString());
		}
	}
	public MySqlDB(String connString) throws SQLException {
		super(connString);
	}
}
