/******************************************************************************
 * Project Doppelgänger                                                       *
 *                                                                            *
 * Copyright (c) 2020. Elex. All Rights Reserved.                             *
 * https://www.elex-project.com/                                              *
 ******************************************************************************/

package com.elex_project.doppelganger;

import java.sql.SQLException;

public final class SQLiteDB extends BaseDatabase {
	/**
	 * * jdbc:sqlite:sample.db
	 * * jdbc:sqlite::memory:
	 */
	public static class Builder extends AbsBuilder<SQLiteDB> {
		private String filePath;

		public Builder() {
			super();
		}

		public Builder fileName(String filePath) {
			this.filePath = filePath;
			return this;
		}

		@Override
		protected String getConnectionString() {
			return getConnectionStringSqlite(filePath);
		}

		@Override
		public SQLiteDB build() throws SQLException {
			return new SQLiteDB(getConnectionString());
		}
	}

	public SQLiteDB(String connString) throws SQLException {
		super(connString);
	}

	public static SQLiteDB mem() throws SQLException {
		return new SQLiteDB("jdbc:sqlite::memory:");
	}
}
